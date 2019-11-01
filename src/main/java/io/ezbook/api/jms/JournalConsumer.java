package io.ezbook.api.jms;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;

import javax.jms.Session;

import io.ezbook.api.model.MQMessage;
import io.ezbook.api.util.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import io.ezbook.api.entity.Account;
import io.ezbook.api.entity.JournalEntity;
import io.ezbook.api.entity.JournalDetail;
import io.ezbook.api.entity.JournalStatus;
import io.ezbook.api.repository.AccountRepository;
import io.ezbook.api.repository.JournalRepository;

@Component
public class JournalConsumer {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private AccountRepository accountRepository;


    @JmsListener(destination = JOURNAL_QUEUE)
    public void receiveMessage(@Payload MQMessage mqMessage, @Headers MessageHeaders headers, Message<?> message,
                               Session session) {
        String tenantId = mqMessage.getTenantId();
        TenantContext.setCurrentTenant(tenantId);

        JournalEntity journalEntity = mqMessage.getPayload();

        for (JournalDetail detail : journalEntity.getJournalDetails()) {
            long accountId = detail.getAccount().getId();
            Account account = accountRepository.findById(accountId).get();

            account.setCreditBalance(account.getCreditBalance() + detail.getCredit());
            account.setDebtBalance(account.getDebtBalance() + detail.getDebt());

            accountRepository.save(account);
        }
        journalEntity.setStatus(JournalStatus.PUBLISHED);
        journalRepository.save(journalEntity);

    }

}

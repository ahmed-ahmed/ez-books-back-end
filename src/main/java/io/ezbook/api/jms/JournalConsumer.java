package io.ezbook.api.jms;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;

import javax.jms.Session;

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
    public void receiveMessage(@Payload JournalEntity journalEntity, @Headers MessageHeaders headers, Message<?> message,
                               Session session) {

        for (JournalDetail detail : journalEntity.getJournalDetails()) {
            long accountId = detail.getAccountId();
            Account account = accountRepository.findById(accountId).get();

            account.setCreditBalance(account.getCreditBalance() + detail.getCredit());
            account.setDebtBalance(account.getDebtBalance() + detail.getDebt());

            accountRepository.save(account);
        }
        journalEntity.setStatus(JournalStatus.PUBLISHED);
        journalRepository.save(journalEntity);

    }

}

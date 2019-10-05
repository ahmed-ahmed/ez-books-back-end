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

import io.ezbook.api.model.Account;
import io.ezbook.api.model.Journal;
import io.ezbook.api.model.JournalDetail;
import io.ezbook.api.repository.AccountRepository;
import io.ezbook.api.repository.JournalRepository;

@Component
public class JournalConsumer {
	
	@Autowired
	private JournalRepository journalRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	

	@JmsListener(destination = JOURNAL_QUEUE)
	public void receiveMessage(@Payload Journal journal, @Headers MessageHeaders headers, Message<?> message,
			Session session) {
		
		for (JournalDetail detail: journal.getJournalDetails()) {
			long accountId = detail.getAccountId();
			Account account = accountRepository.findById(accountId).get();
			
			account.getCreditBalance().add(detail.getCredit());
			account.getDebtBalance().add(detail.getDebt());
			
			accountRepository.save(account);
		}
		journalRepository.save(journal);
		
	}

}
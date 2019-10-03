package io.ezbook.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.Journal;
import io.ezbook.api.repo.JournalRepository;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;;

@Service
public class JournalService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private JournalRepository journalRepo;

	public List<Journal> findAll() {
		return journalRepo.findAll();
	}
	
	public void addJournal(Journal journal) {
		jmsTemplate.convertAndSend(JOURNAL_QUEUE, journal);
	}

}

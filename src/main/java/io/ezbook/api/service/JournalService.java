package io.ezbook.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.Journal;
import io.ezbook.api.repository.JournalRepository;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;;

@Service
public class JournalService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private JournalRepository journalRepository;

	public List<Journal> findAll() {
		return journalRepository.findAll();
	}
	
	public Journal addJournal(Journal journal) {
		Journal journalResponse = journalRepository.save(journal);
		jmsTemplate.convertAndSend(JOURNAL_QUEUE, journalResponse);
		return journalResponse;
	}

}

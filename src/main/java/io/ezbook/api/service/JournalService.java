package io.ezbook.api.service;

import java.util.List;

import io.ezbook.api.entity.JournalEntity;
import io.ezbook.api.model.Journal;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import io.ezbook.api.repository.JournalRepository;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;;

@Service
public class JournalService extends AbstractService<Journal> {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private JournalRepository journalRepository;

	public List<JournalEntity> findAll() {
		return journalRepository.findAll();
	}

	public JournalEntity addJournal(JournalEntity journalEntity) {
		JournalEntity journalEntityResponse = journalRepository.save(journalEntity);
		jmsTemplate.convertAndSend(JOURNAL_QUEUE, journalEntityResponse);
		return journalEntityResponse;
	}

	@Override
	public CrudRepository getRepo() {
		return journalRepository;
	}
}

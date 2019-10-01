package io.ezbook.api.jms;

import static io.ezbook.api.configuration.ActiveMQConfig.JOURNAL_QUEUE;

import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import io.ezbook.api.model.Journal;

@Component
public class JournalConsumer {
	
	private static Logger log = LoggerFactory.getLogger(JournalConsumer.class);

	@JmsListener(destination = JOURNAL_QUEUE)
	public void receiveMessage(@Payload Journal journal, @Headers MessageHeaders headers, Message<?> message,
			Session session) {
		log.info("received <" + journal + ">");

		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
		log.info("######          Message Details           #####");
		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
		log.info("headers: " + headers);
		log.info("message: " + message);
		log.info("session: " + session);
		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
	}

}
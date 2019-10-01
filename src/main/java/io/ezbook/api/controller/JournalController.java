package io.ezbook.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ezbook.api.model.Journal;
import io.ezbook.api.service.JournalService;

@RestController
@RequestMapping("/journals")
public class JournalController {

	@Autowired
	private JournalService journalService;

    @GetMapping
    public List<Journal> findAll() {
        return journalService.findAll();
    }
    
    @GetMapping(path = "/addJournal")
    public void addJournal() {
    	Journal journal = new Journal();
    	journal.setId(1111111L);
        journalService.addJournal(journal);
    }

	
}

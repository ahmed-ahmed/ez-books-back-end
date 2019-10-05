package io.ezbook.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ezbook.api.model.Journal;
import io.ezbook.api.service.JournalService;

@RestController
@RequestMapping("/journals")
@CrossOrigin
public class JournalController {

	@Autowired
	private JournalService journalService;

    @GetMapping
    public List<Journal> findAll() {
        return journalService.findAll();
    }

    @PostMapping
    public void addJournal(@RequestBody Journal journal) {
        journalService.addJournal(journal);
    }
}

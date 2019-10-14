package io.ezbook.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import io.ezbook.api.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ezbook.api.entity.JournalEntity;
import io.ezbook.api.service.JournalService;

@RestController
@RequestMapping("/journals")
@CrossOrigin
public class JournalController {

    @Autowired
    private JournalService journalService;

//	    @GetMapping(value = "/{id}")
//    public Foo findById(@PathVariable("id") Long id) {

    @GetMapping(value = "/{id}")
    public JournalEntity findById(@PathVariable("id") long id) {
        return journalService.findByJournalId(id).get();
    }

    @GetMapping
    public List<Journal> findAll() {
        return journalService.findAll().stream()
                .map(journalEntity -> new Journal(journalEntity))
                .collect(Collectors.toList());
    }

    @PostMapping
    public JournalEntity addJournal(@RequestBody JournalEntity journalEntity) {
        return journalService.addJournal(journalEntity);
    }
}

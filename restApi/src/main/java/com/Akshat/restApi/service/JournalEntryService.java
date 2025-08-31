package com.Akshat.restApi.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Akshat.restApi.entity.JournalEntry;
import com.Akshat.restApi.repository.JournalEntryRepository;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    // Interface ko inject or spring by self at runtime mein iss interface ka
    // implementaion gernarate kr denga
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
// mongodb repository k inside these all method ex-->findAll(),save() predefine
// so we dont have to nothing
// iss class ko call krana h controller so autowired help lege
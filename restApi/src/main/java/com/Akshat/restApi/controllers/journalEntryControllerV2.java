package com.Akshat.restApi.controllers;

import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Akshat.restApi.entity.JournalEntry;
import com.Akshat.restApi.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<JournalEntry> li= journalEntryService.getAll();
        if(li !=null && !li.isEmpty()){
            return new ResponseEntity<>(li, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   @PostMapping("/add")
public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry){
    try{
         myentry.setDate(LocalDateTime.now());
   journalEntryService.saveEntry(myentry);
   return new ResponseEntity<>(myentry,HttpStatus.CREATED);  // return the created entry
    }
   catch(Exception e){
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }

  
}

    @GetMapping("/id/{d_Id}")
    public ResponseEntity<JournalEntry> getbyId(@PathVariable ObjectId d_Id) {
        Optional<JournalEntry> journalentry = journalEntryService.findById(d_Id);

        if (journalentry.isPresent()) {
            return new ResponseEntity<>(journalentry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{d_id}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId d_id) {
        journalEntryService.deleteById(d_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{d_id}")
    public ResponseEntity<?> updJournalEntry(@PathVariable ObjectId d_id, @RequestBody JournalEntry myentry) {
        JournalEntry old = journalEntryService.findById(d_id).orElse(null);
        if (old != null) {
            old.setTitle(myentry.getTitle() != null && !myentry.equals("") ? myentry.getTitle() : old.getTitle());
            old.setContent(
                    myentry.getContent() != null && !myentry.equals("") ? myentry.getContent() : old.getContent());
            // content send toh title as it and if title sent then content as it
             journalEntryService.saveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
        }
       return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);

    }

}

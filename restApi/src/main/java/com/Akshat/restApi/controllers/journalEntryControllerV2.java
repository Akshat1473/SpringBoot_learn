package com.Akshat.restApi.controllers;

import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

   @PostMapping("/add")
public JournalEntry createEntry(@RequestBody JournalEntry myentry){
    myentry.setDate(LocalDateTime.now());
   journalEntryService.saveEntry(myentry);
   return null;  // return the created entry
}


    @GetMapping("/addById/{d_Id}")
    public JournalEntry getbyId(@PathVariable ObjectId myId){
        // bcoz in service optional is like box where data may present or not if present give date else return null
        return journalEntryService.findById(myId).orElse(null);
        
    }

    @DeleteMapping("/delete/{d_id}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId d_id){
        journalEntryService.deleteById(d_id);
        return true;
    }

    @PutMapping("/update/{d_id}")
    public JournalEntry updJournalEntry(@PathVariable ObjectId d_id,@RequestBody JournalEntry myentry){
        JournalEntry old=journalEntryService.findById(d_id).orElse(null);
        if(old!=null){
            old.setTitle(myentry.getTitle()!=null && !myentry.equals("")?myentry.getTitle():old.getTitle());
            old.setContent(myentry.getContent()!=null && !myentry.equals("")? myentry.getContent():old.getContent());
            // content send toh title as it and if title sent then content as it 
        }
        journalEntryService.saveEntry(old);
        return old;
        
    }
    
    
}

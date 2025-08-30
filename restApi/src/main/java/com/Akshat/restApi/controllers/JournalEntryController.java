package com.Akshat.restApi.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.Akshat.restApi.entity.JournalEntry;

@RestController
@RequestMapping("/Akshat")

public class JournalEntryController {
    private Map<Long ,JournalEntry> JournalEntries=new HashMap<>();
    
    @GetMapping("/getAll")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(JournalEntries.values());
    }

   @PostMapping("/add")
public JournalEntry createEntry(@RequestBody JournalEntry myentry){
   JournalEntries.put(myentry.getId(), myentry);
   return myentry;  // return the created entry
}


    @GetMapping("/addById/{d_Id}")
    public JournalEntry getbyId(@PathVariable Long d_Id){
        return JournalEntries.get(d_Id);
    }

    @DeleteMapping("/delete/{d_id}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long d_id){
        return JournalEntries.remove(d_id);
    }

    @PutMapping("/update/{d_id}")
    public JournalEntry updJournalEntry(@PathVariable Long d_id,@RequestBody JournalEntry myentry){
        return JournalEntries.put(d_id,myentry);
    }
}

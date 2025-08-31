package com.Akshat.restApi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Akshat.restApi.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,ObjectId>{
    
    
    // Controller call-->serveic call --->repeository
    // By spring Mongodb an iterface is provide which is called mongo repository so we extend mongo respository in our repository interface
    // in extends generic se pass two thing 1)jis pr operation krna h, here we have pom.xml is journal entry and 2)String which is for id
    //orm mapping--> so now we have to map pojo by collection which is inside in db
    // in entity we add  @Document tell ye jo h mongodb k collection se mapped entity h so here in controlller Journal entity ka ek instance row k equal hoga
    // @Id document mein collection ki unique key not compulsory but good practise
    // after this journal entry of service layer ko call krana h controller

    // in post request if we dont pass id then mongodb give it by itself and if pass id by itself then take that id and if again pass reduntant id then it upadte that id data
}

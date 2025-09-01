package com.Akshat.restApi.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDateTime;
// import java.util.Date;

// Doucument give by mongodb document to create entity
@Document(collection = "journal_entries")
@Data
// also give @Getter,@Setter,@RequirmentArgConstructor,@ToString,@EqualsHashCode,@Value uniquely but @Data contain all in it and lombok scanner scan the method when we create in source file
// if not write () in document then framework mongo search Jouranl entry in db present in collection otherwise provide collection and the instance is mapped with entities
public class JournalEntry {
    @Id
     private ObjectId id;

     private String title;
     private String content;
     private LocalDateTime date;
     
    //  public LocalDateTime getDate() {
    //     return date;
    // }
    //  public void setDate(LocalDateTime date) {
    //      this.date = date;
    //  }
    //  public ObjectId getId() {
    //      return id;
    //  }
    //  public void setId(ObjectId id) {
    //      this.id = id;
    //  }
    //  public String getTitle() {
    //      return title;
    //  }
    //  public void setTitle(String title) {
    //      this.title = title;
    //  }
    //  public String getContent() {
    //      return content;
    //  }
    //  public void setContent(String content) {
    //      this.content = content;
    //  }
     
}

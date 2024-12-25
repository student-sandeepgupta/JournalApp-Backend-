package net.engineerdigest2.journalapp2.entity2;

import org.bson.types.ObjectId;

//import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Document(collection="journal_entries")
public class JournalEntry2 {
@Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
     private LocalDateTime date;
    

}

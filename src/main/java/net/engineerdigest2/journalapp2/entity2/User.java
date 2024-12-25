package net.engineerdigest2.journalapp2.entity2;
import java.util.*;
import org.bson.types.ObjectId;
//import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.mongodb.DBRef;
import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection="users")
@Data
public class User {
    @Id
private ObjectId id;

@Indexed (unique = true)
@NonNull
    private String userName;
    @NonNull
    private String passward;

    
@DBRef
    private List<JournalEntry2> journalEntries = new ArrayList<>();
}

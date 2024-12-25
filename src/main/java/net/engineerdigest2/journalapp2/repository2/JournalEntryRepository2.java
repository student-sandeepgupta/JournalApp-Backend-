package net.engineerdigest2.journalapp2.repository2;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.engineerdigest2.journalapp2.entity2.JournalEntry2;

public interface JournalEntryRepository2 extends MongoRepository<JournalEntry2 ,ObjectId>{

}
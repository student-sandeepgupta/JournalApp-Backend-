package net.engineerdigest2.journalapp2.service2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineerdigest2.journalapp2.entity2.JournalEntry2;
import net.engineerdigest2.journalapp2.entity2.User;
//import net.engineerdigest2.journalapp2.entity2.User;
import net.engineerdigest2.journalapp2.repository2.JournalEntryRepository2;

@Component
public class JouranEntryService2 {

    @Autowired
    private JournalEntryRepository2 journalRepository;

    @Autowired
    private UserService userService;
    
    public void saveEntry(JournalEntry2 journalEntry,String userName){
        User user = userService.findByUserName(userName);

        journalEntry.setDate(LocalDateTime.now());
     JournalEntry2 saved =    journalRepository.save(journalEntry);
     user.getJournalEntries().add(saved);
     userService.saveEntry(user);
    }


    public void saveEntry(JournalEntry2 journalEntry){
     journalRepository.save(journalEntry);
    }


    

    public List<JournalEntry2> getAll(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntry2> findById(ObjectId id){
        return journalRepository.findById(id);

    }

    public void deleteById(ObjectId id,String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalRepository.deleteById(id);
    }

}
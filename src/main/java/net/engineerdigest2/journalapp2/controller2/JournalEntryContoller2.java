package net.engineerdigest2.journalapp2.controller2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineerdigest2.journalapp2.entity2.JournalEntry2;
import net.engineerdigest2.journalapp2.entity2.User;
import net.engineerdigest2.journalapp2.service2.JouranEntryService2;
import net.engineerdigest2.journalapp2.service2.UserService;

@RestController
@RequestMapping("/journal")
public class JournalEntryContoller2 {
@Autowired
private JouranEntryService2 journalEntryServices2;
@Autowired
private UserService userService;

@GetMapping("{userName}")
    public ResponseEntity<?>getAllJournalEntriesOfUSer(@PathVariable String userName){
               User user = userService.findByUserName(userName);
               List<JournalEntry2> all = user.getJournalEntries();
               if(all !=null&& !all.isEmpty()){
                return new ResponseEntity<>(all,HttpStatus.OK);
               }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
     
    }


@PostMapping("{userName}")
    public ResponseEntity<JournalEntry2> createEntry(@RequestBody JournalEntry2 myEntry,@PathVariable String userName){
      try{
        // User user = userService.findByUserName(userName);
        myEntry.setDate(LocalDateTime.now());
        journalEntryServices2.saveEntry(myEntry, userName);
        return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
      }
      catch(Exception e){
return new ResponseEntity<>(myEntry,HttpStatus.BAD_REQUEST);
    }
    }



    @GetMapping("id/{myid}")
    public ResponseEntity<?> getMethodName(@PathVariable ObjectId myid) {
        Optional<JournalEntry2> journalEntry2 =journalEntryServices2.findById(myid);
      if(journalEntry2.isPresent()){
        return new ResponseEntity<>(journalEntry2.get(),HttpStatus.OK);
      }
      return new ResponseEntity<>(journalEntry2.get(),HttpStatus.NOT_FOUND);
    }
    

    @DeleteMapping("id/{userName}/{myid}")
    public ResponseEntity<?> deleteMethodName(@PathVariable ObjectId myid,@PathVariable String userName) {
        journalEntryServices2.deleteById(myid,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   @PutMapping("id/{userName}/{myid}")
  public ResponseEntity<?> putbyId(@PathVariable ObjectId myId, @RequestBody JournalEntry2 newEntry2,@PathVariable String userName){
       JournalEntry2  old= journalEntryServices2.findById(myId).orElse(null);
if(old!=null){

    old.setTitle(newEntry2.getTitle() != null && !newEntry2.getTitle().equals("")? newEntry2.getTitle():old.getTitle());
    old.setContent(newEntry2.getContent() != null&& !newEntry2.getContent().equals("") ? newEntry2.getContent():old.getContent());
    journalEntryServices2.saveEntry(old);
    return new ResponseEntity<>(old,HttpStatus.OK);
}

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }

package net.engineerdigest2.journalapp2.service2;

import java.util.List;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import net.engineerdigest2.journalapp2.entity2.JournalEntry2;
import net.engineerdigest2.journalapp2.entity2.User;
//import net.engineerdigest2.journalapp2.repository2.JournalEntryRepository2;
import net.engineerdigest2.journalapp2.repository2.UserRepository;
   
@Component
public class UserService {


    @Autowired
    private UserRepository userRepository;
    
    public void saveEntry(User user){
       userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);

    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }

}

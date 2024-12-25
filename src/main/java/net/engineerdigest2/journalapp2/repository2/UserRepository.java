package net.engineerdigest2.journalapp2.repository2;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.engineerdigest2.journalapp2.entity2.User;
//import java.util.List;


public interface UserRepository extends MongoRepository<User, ObjectId>{

    User findByUserName(String username);
}

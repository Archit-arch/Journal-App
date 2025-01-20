package net.engineeringdigest.jounalApp.repository;

import net.engineeringdigest.jounalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
}


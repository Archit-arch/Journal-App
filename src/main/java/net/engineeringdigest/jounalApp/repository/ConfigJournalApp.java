package net.engineeringdigest.jounalApp.repository;

import net.engineeringdigest.jounalApp.entity.ConfigJournalAppEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalApp extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}

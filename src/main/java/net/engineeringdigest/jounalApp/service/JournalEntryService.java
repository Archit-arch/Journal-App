package net.engineeringdigest.jounalApp.service;

import net.engineeringdigest.jounalApp.entity.JournalEntry;
import net.engineeringdigest.jounalApp.entity.User;
import net.engineeringdigest.jounalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private UserService userService;
    @Autowired
    //Dependency Injection...
    private JournalEntryRepository journalEntryRepository;



    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            JournalEntry saved = journalEntryRepository.save(journalEntry);  //We get that journal entry

            user.getJournalEntries().add(saved);  //We add that journal entry to the list.
            userService.saveEntry(user);  //User ko bhi save krliya with new journal entry.
        }catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("Error saving journal entry", e);
        }


    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }


    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
        userService.saveEntry(user);  //Updated user save ho jaay gi
        journalEntryRepository.deleteById(id);
    }


}

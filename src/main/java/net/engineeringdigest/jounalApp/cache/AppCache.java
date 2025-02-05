package net.engineeringdigest.jounalApp.cache;

import jakarta.annotation.PostConstruct;
import net.engineeringdigest.jounalApp.entity.ConfigJournalAppEntity;
import net.engineeringdigest.jounalApp.repository.ConfigJournalApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public Map<String, String> APP_CACHE = new HashMap<>();

    @Autowired
    private ConfigJournalApp configJournalApp;

    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntity> all = configJournalApp.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity : all){
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }
}

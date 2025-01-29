package net.engineeringdigest.jounalApp.service;

import net.engineeringdigest.jounalApp.entity.User;
import net.engineeringdigest.jounalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;


    @ParameterizedTest
    @ValueSource(strings={
            "Ram",
            "Aditya",
            "Akshay",
            "Weeknd",
            "enicne",
            "ebfiueb"
    })
    public void testfindByUserName(String name){

        assertNotNull(userRepository.findByUserName(name), "Failed for: "+name);

    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}

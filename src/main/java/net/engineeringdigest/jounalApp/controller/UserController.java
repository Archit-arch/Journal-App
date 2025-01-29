package net.engineeringdigest.jounalApp.controller;

import net.engineeringdigest.jounalApp.api.response.WeatherResponse;
import net.engineeringdigest.jounalApp.entity.User;
import net.engineeringdigest.jounalApp.repository.UserRepository;
import net.engineeringdigest.jounalApp.service.UserService;
import net.engineeringdigest.jounalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;
    /*@GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    */



    //This has aldready been authenticated...
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){

        //This securityContextHolder will get hold of username and password
        //So that it gets automatically retrieved as we have aldready logged in.

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         String userName = authentication.getName();

       User userInDb = userService.findByUserName(userName);

       userInDb.setUserName(user.getUserName());
       userInDb.setPassword(user.getPassword());
       userService.saveNewuser(userInDb);

       return new ResponseEntity<>(userInDb, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");

        String greeting ="";

        if(weatherResponse!=null){
            greeting += ", Weather feels like "+weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName() + greeting, HttpStatus.OK);
    }

}

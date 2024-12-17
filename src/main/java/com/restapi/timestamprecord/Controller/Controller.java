package com.restapi.timestamprecord.Controller;

import com.restapi.timestamprecord.Entity.User;
import com.restapi.timestamprecord.Service.RecordService;
import com.restapi.timestamprecord.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/user")
@RestController
public class Controller {
    private final UserService userService;
    private final RecordService recordService;
    public Controller(UserService userService, RecordService recordService) {
        this.userService = userService;
        this.recordService = recordService;
    }

    // for adding user in database
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("Added successfully");
    }

    // showing all users from database
    @GetMapping("/all")
    public List<User> findAllUser(){
       return userService.findUser();
    }


    // save time stamp when id is post
    @PostMapping("/{id}")
    public ResponseEntity<String> updateTimestamp(@PathVariable Long id) {
        String response = recordService.saveTimestamp(id);
        return ResponseEntity.ok(response);
    }
}

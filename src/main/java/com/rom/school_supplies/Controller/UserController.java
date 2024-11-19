package com.rom.school_supplies.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rom.school_supplies.Entity.Message;
import com.rom.school_supplies.Entity.User;
import com.rom.school_supplies.Service.MyConfigService;
import com.rom.school_supplies.Service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private MyConfigService myConfigService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
            // Repository Layer
            List<User> users = userService.getAllUser();

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
            // Repository Layer
            return new ResponseEntity<>("GetOne Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User userl = new User();
        ResponseEntity responseEntity;
        try {
            userl = userService.login(user.getUsername(), user.getPassword());

            if (userl instanceof User) {
                responseEntity = new ResponseEntity<>(userl, HttpStatus.OK);
            } else {
                Message message = new Message();
                message.setMessage(myConfigService.getUserMessageNotFound());
                responseEntity = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

            }

            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody User dto) {
        try {
            // TODO Implement Your Logic To Save Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody User dto) {
        try {
            // TODO Implement Your Logic To Update Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Destroy Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

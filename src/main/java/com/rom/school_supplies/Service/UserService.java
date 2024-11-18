package com.rom.school_supplies.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.rom.school_supplies.Entity.User;
import com.rom.school_supplies.Repository.UserRepository;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User login(String username, String password) {

        User user = userRepository.login(username, password);

        return user;

    }

}

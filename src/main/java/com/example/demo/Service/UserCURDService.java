package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCURDService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        user.setRole("ROLE_USER");
        return  this.userRepository.save(user);
    }
}

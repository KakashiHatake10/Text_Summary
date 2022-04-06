package com.example.demo.Service;

import com.example.demo.Model.Notes;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCURDService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User getUser(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println("user" + user);
        return user;
    }

    public List<Notes> viewAll(String email) {
        User user = userRepository.findByEmail(email);

        System.out.println("notes" + user);
        List<Notes> notes = new ArrayList<>();
        try {
            for (Notes s : user.getNotes()) {
                notes.add(s);
            }
        }
        catch (Exception e)
        {
            System.out.println("empty");
        }
        System.out.println("note is" + notes);
        return notes;
    }
}

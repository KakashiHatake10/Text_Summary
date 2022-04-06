package com.example.demo.Service;

import com.example.demo.Model.Notes;
import com.example.demo.Model.User;
import com.example.demo.Repository.NotesRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {
//
//    @Autowired
//    private UserCURDService userCURDService;
    @Autowired
    private NotesRepository notesRepository;

    public Notes add(User user, Notes notes) {
        notes.setUser(user);
        Notes save = notesRepository.save(notes);
        return save;
    }

    public void deleteNotes(int id) {
        System.out.println("inside delete method");
        this.notesRepository.deleteById(id);
       // List<Notes> notes = userCURDService.viewAll(principal.getName());

    }

    public void updateNotes(int id) {
        Optional<Notes> byId = notesRepository.findById(10);
        Notes notes = byId.get();
        notes.setTitle("mohit");
        notesRepository.save(notes);
    }
}

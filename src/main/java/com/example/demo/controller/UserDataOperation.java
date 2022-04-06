package com.example.demo.controller;

import com.example.demo.Model.Notes;
import com.example.demo.Model.User;
import com.example.demo.Repository.NotesRepository;
import com.example.demo.Service.NotesService;
import com.example.demo.Service.UserCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/notes")
public class UserDataOperation {

    @Autowired
    private NotesService notesService;

    @Autowired
    private UserCURDService userCURDService;

    @GetMapping("/addNote")
    public String addNote() throws ParseException {

        System.out.println("inside save method");
        return "addNote";
    }

    @PostMapping("/add")
    public String add(Notes notes, Principal principal, Model model) {
        User user = userCURDService.getUser(principal.getName());
        Notes add = notesService.add(user, notes);
        System.out.println("add" + add);
        model.addAttribute("show", "Note added, click on view All Notes");
        return "addNote";
    }

    @GetMapping("/viewAllNote")
    public String viewNotes(Principal principal, Model model) {
        List<Notes> notes = notesRepository.findByUser_Email(principal.getName());
        model.addAttribute("notes", notes);
        return "Note";
    }

    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable int id, Principal principal, Model model) {
        System.out.println("id = " + id);
        notesService.deleteNotes(id);
        List<Notes> byUser_email = notesRepository.findByUser_Email(principal.getName());
        model.addAttribute("notes", byUser_email);
        return "Note";
    }

    @GetMapping("/update/{id}")
    public String updateNote_Page(@PathVariable int id, Principal principal, Model model) {
//
        //      notesService.updateNotes(id);
        Optional<Notes> User_email = notesRepository.findById(id);
        Notes note = User_email.get();
        System.out.println(note.getUser());
        model.addAttribute("notes", User_email.get());
        return "updateNote";
    }

    @PostMapping("/update")
    public String updateNote(Notes notes, Model model) {
        System.out.println(notes.getId() + " " + notes.getTitle() + "  " + notes.getNoteData() + " " + notes.getUser());
        Optional<Notes> byUser_email = notesRepository.findById(notes.getId());
        Notes notes1 = byUser_email.get();
        notes1.setTitle(notes.getTitle());
        notes1.setNoteData(notes.getNoteData());
        Notes save = this.notesRepository.save(notes1);

        Optional<Notes> byUser_email1 = notesRepository.findById(notes.getId());
        model.addAttribute("notes", byUser_email1.get());
        return "Note";
    }


    @PostMapping("/saveForLater")
    public String SummaryDataPage(@RequestParam("text") String text, Model model) {
        System.out.println(text);
        Notes note = new Notes();
        note.setNoteData(text);
        model.addAttribute("notes", note);
        return "updateNote";
    }

    @PostMapping("/saveNewNote")
    public String saveSummaryData(Notes notes, Principal principal, Model model) {
        User user = userCURDService.getUser(principal.getName());
        Notes add = notesService.add(user, notes);
        System.out.println("add" + add);
        Optional<Notes> byUser_email1 = notesRepository.findById(notes.getId());
        model.addAttribute("notes", byUser_email1.get());
        return "Note";

    }
}
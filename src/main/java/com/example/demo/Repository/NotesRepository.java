package com.example.demo.Repository;

import com.example.demo.Model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotesRepository extends JpaRepository<Notes, Integer> {

    public List<Notes> findByUser_Email(String email);
}

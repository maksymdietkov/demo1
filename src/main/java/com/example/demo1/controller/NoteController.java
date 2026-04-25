package com.example.demo1.controller;

import com.example.demo1.model.Note;
import com.example.demo1.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository repo;

    public NoteController(NoteRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public Note create(@RequestBody Note note) {
        return repo.save(note);
    }

    // READ ALL
    @GetMapping
    public List<Note> getAll() {
        return repo.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
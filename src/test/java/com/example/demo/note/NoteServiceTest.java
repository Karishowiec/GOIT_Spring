package com.example.demo.note;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {
    NoteService noteService;

    @BeforeEach
    void setUp() {
        noteService = new NoteService();
    }

    @Test
    void listAll() {
        noteService.add(new Note("please help", "no"));
        noteService.add(new Note("please help", "no"));
        noteService.add(new Note("please help", "no"));
        noteService.add(new Note("please help", "no"));
        noteService.add(new Note("please help", "no"));
        assertEquals(5, noteService.listAll().size());
    }

    @Test
    void add() {
        Note note = new Note("please help", "no");
        Note add = noteService.add(note);
        assertNotNull(add);
        assertEquals(note.getTitle(), add.getTitle());
        assertEquals(note.getContent(), add.getContent());

    }

    @Test
    void deleteById() {
        Note note = new Note("please help", "no");
        Note add = noteService.add(note);
        noteService.deleteById(add.getId());
        assertEquals(0, noteService.listAll().size());
    }

    @Test
    void update() {
        Note note = new Note("please help", "no");
        Note add = noteService.add(note);
        Note updated = new Note();
        noteService.update(updated);
        add = noteService.getById(add.getId());
        assertNotNull(add);
        assertEquals(updated.getTitle(), add.getTitle());
        assertEquals(updated.getContent(), add.getContent());
    }

    @Test
    void getById() {
        Note note = new Note("please help", "no");
        Note add = noteService.add(note);
        add = noteService.getById(add.getId());
        assertNotNull(add);
        assertEquals(note.getTitle(), add.getTitle());
        assertEquals(note.getContent(), add.getContent());
    }
}
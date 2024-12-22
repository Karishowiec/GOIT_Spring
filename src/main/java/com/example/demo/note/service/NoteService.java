package com.example.demo.note.service;

import com.example.demo.note.Note;
import com.example.demo.note.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(String title, String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        return noteRepository.save(note);
    }
    public void  deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Long id, String title, String content) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(title);
        note.setContent(content);
        return noteRepository.save(note);
    }

    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

}
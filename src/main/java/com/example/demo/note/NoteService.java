package com.example.demo.note;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    private long id = 0;
    private final Map<Long, Note> notes = new HashMap<>();

    private long incrementID() {

        return ++id;
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        note.setId(incrementID());
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(int id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("note with id = " + id + " not founded");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new IllegalArgumentException("note with id = " + note.getId() + " not founded");
        }
        Note savedNote = notes.get(note.getId());
        savedNote.setTitle(note.getTitle());
        savedNote.setContent(note.getContent());
    }

    public Note getById(int id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("note with id = " + id + " not founded");
        }
        return notes.get(id);
    }

}
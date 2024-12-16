package com.example.demo.note.controller;

import com.example.demo.note.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", notes);
        return "note_list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        notes.removeIf(note -> note.getId().equals(id));
        return "redirect:/note/list";
    }


    @GetMapping("/edit")
    public String editNote(@RequestParam("id") Long id, Model model) {
        Note note = notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("note", note);
        return "note_edit";
    }

    @PostMapping("/edit")
    public String updateNote(@RequestParam("id") Long id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        notes.stream()
                .filter(n -> n.getId().equals(id))
                .forEach(note -> {
                    note.setTitle(title);
                    note.setContent(content);
                });
        return "redirect:/note/list";
    }

    @PostMapping("/create")
    public String createNote(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        Note note = new Note();
        note.setId(counter.getAndIncrement());
        note.setTitle(title);
        note.setContent(content);
        notes.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "note_create";
    }
}

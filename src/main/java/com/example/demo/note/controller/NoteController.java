package com.example.demo.note.controller;

import com.example.demo.note.Note;
import com.example.demo.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "note_list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/note/list";
    }


    @GetMapping("/edit")
    public String editNote(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note_edit";
    }

    @PostMapping("/edit")
    public String updateNote(@RequestParam("id") Long id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        noteService.updateNote(id, title, content);
        return "redirect:/note/list";
    }

    @PostMapping("/create")
    public String createNote(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        noteService.createNote(title, content);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "note_create";
    }
}

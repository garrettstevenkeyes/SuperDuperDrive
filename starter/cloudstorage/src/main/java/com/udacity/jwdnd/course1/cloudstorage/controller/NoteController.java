package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String getNotePage(NoteForm noteForm, Model model) {
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }

//     After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping
    public String postNewNote(NoteForm noteForm, Model model) {
        this.noteService.addNote(noteForm);
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }

}

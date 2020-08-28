package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteService noteService;

    //I'll be adding the other services to this
    public HomeController(NoteService noteService) {
        this.noteService = noteService;
    }

    // when the notes section is clicked on it should load all of the notes that are saved
    @GetMapping
    public String getNotePage(NoteForm noteForm, Model model) {
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }

    // After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping
    public String postNewNote(Authentication authentication, NoteForm noteForm, Model model) {
        noteForm.setNoteTitle("");
        noteForm.setNoteDescription("");
        this.noteService.addNote(noteForm);
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }

    // come back to this
   /* @ModelAttribute()*/



}
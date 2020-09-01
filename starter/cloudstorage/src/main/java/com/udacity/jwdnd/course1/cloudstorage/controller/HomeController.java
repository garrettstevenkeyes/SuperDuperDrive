package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteService noteService;
    private FileService fileService;

    //I'll be adding the other services to this
    public HomeController(NoteService noteService, FileService fileService) {
        this.noteService = noteService;
        this.fileService = fileService;
    }

    // take us back to the home page when notes are submitted

    @GetMapping
    public String getNotePage(NoteForm noteForm, Model model) {
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }


    public String getFilePage(FileForm fileForm, Model model) {
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        return "home";
    }

    // After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping
    public String postNewNote(Authentication authentication, NoteForm noteForm, Model model) {
        this.noteService.addNote(noteForm);
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home/note";
    }

    // i need to add in html mapped tags

//    @PostMapping
    public String postNewFile(Authentication authentication, FileForm fileForm, Model model){
        this.fileService.addFile(fileForm);
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        return "home/file";
    }
}

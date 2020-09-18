package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    private NoteService noteService;
    private FileService fileService;
    private CredentialService credentialService;

    public NoteController(NoteService noteService, FileService fileService, CredentialService credentialService){
        this.noteService = noteService;
        this.fileService = fileService;
        this.credentialService = credentialService;
    }

    @GetMapping("/notes")
    public String getNotePage(NoteForm noteForm, Model model) {
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }

//     After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping("/notes")
    public String postNewNote(NoteForm noteForm, Model model) {
        this.noteService.addNote(noteForm);
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        model.addAttribute("pageCredentials", this.credentialService.getPageCredentials());
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        model.addAttribute("noteForm", new NoteForm());
        model.addAttribute("credentialForm", new CredentialForm());
        return "home";
    }
}

package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @ModelAttribute("noteForm")
    public NoteForm getNoteForm() {
        return new NoteForm();
    }

//     After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping("/notes")
    public String postNewNote(@ModelAttribute("noteForm") NoteForm noteForm, Model model) {
        this.noteService.addNote(noteForm);
        return "redirect:/home";
    }

    @DeleteMapping("/notes/{noteId}")
    public String deleteNote(@PathVariable(value = "noteId") Integer noteId, Model model) {
        noteService.deleteNote(noteId);
        return "redirect:/home";
    }
}

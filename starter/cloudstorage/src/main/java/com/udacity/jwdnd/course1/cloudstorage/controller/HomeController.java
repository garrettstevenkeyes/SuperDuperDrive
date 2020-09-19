package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private FileService fileService;

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private NoteService noteService;

    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        model.addAttribute("pageCredentials", this.credentialService.getPageCredentials());
        model.addAttribute("pageNotes", this.noteService.getPageNotes());
        return "home";
    }
}

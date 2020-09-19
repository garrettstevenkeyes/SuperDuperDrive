package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialController {
    private CredentialService credentialService;

    public CredentialController(CredentialService credentialService){
        this.credentialService = credentialService;
    }

    @ModelAttribute("credentialForm")
    public CredentialForm getCredentialForm() {
        return new CredentialForm();
    }

    //     After the page has initially been loaded it should do be able to add notes to the page
    @PostMapping("/credentials")
    public String postNewCredential(@ModelAttribute("credentialForm") CredentialForm credentialForm, Model model) {
        this.credentialService.addCredential(credentialForm);
        return "redirect:/home";
    }
}

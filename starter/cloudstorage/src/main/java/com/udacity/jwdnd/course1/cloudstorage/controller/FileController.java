package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {
    private FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping("/files")
    public String getFilePage(FileForm fileForm, Model model) {
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        return "home";
    }

    @PostMapping
    public String postNewFile(FileForm fileForm, Model model){
        this.fileService.addFile(fileForm);
        model.addAttribute("pageFiles", this.fileService.getPageFiles());
        return "home";
    }

}

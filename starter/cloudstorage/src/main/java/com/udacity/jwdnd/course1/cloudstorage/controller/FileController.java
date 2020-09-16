package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

import java.io.IOException;

@Controller
public class FileController {
    private FileService fileService;

    @Autowired
    private UserService userService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/files")
    public String postNewFile(@RequestParam("fileUpload") MultipartFile fileUpload, Model model, Authentication authentication) throws IOException {
        int userId = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()).getUserId();
        fileService.addFile(new File(null, fileUpload.getOriginalFilename(), fileUpload.getContentType(), fileUpload.getSize(), userId, fileUpload.getBytes()));
        return "redirect:/home";
    }
}
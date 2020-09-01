package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void addFile(FileForm fileform){
        File newFile = new File();
        newFile.setFileName(fileform.getFileName());
        fileMapper.insertFile(newFile);
    }

    public List<File> getPageFiles() {
        return fileMapper.getAllFiles();
    }
}

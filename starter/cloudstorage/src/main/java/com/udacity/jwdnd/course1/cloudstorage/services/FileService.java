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

    public int addFile(File file){
        return fileMapper.insertFile(new File(null, file.getFileName(), file.getContentType(), file.getFileSize(), file.getUserId(), file.getFileData()));
    }

    public List<File> getPageFiles() {
        return fileMapper.getAllFiles();
    }

    public void deleteFile(Integer fileId) {
        fileMapper.deleteFile(fileId);
    }
}

package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    /*constructor*/
    public NoteService(NoteMapper noteMapper){
        this.noteMapper = noteMapper;
    }

    public void addNote(NoteForm noteForm) {
        Note newNote = new Note();
        newNote.setNoteTitle(noteForm.getNoteTitle());
        /*maybe some logic to prevent notes with the same name*/
        noteMapper.insertNote(newNote);
//        System.out.println("New note added");
    }

    public List<Note> getPageNotes() {
//        System.out.println("note list reached!");
        return noteMapper.getAllNotes();

    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating NoteService bean");
    }

    /*
    *//*Use this method to delete a note*//*
    public void deleteNote(NoteForm noteForm) {
        noteMapper.delete(note);
        *//*build something that checks if the object exists, and put this note controller*//*
    }

    *//*Use this method to check whether a username is available or has already been taken*//*
    public boolean isNoteTitleAvailable(String notetitle) {
        return noteMapper.getNoteTitle(notetitle) == null;
    }

    *//*Use this method to create a new note*//*
    public int createNote(Note note) {
        return noteMapper.insert(new Note(null, note.getNoteTitle(), note.getNoteDescription(), note.getUserId()));
    }
*/
}

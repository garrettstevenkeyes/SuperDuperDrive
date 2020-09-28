package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper){
        this.noteMapper = noteMapper;
    }

    public void addNote(NoteForm noteForm) {
        Note notes = noteMapper.findNoteById(noteForm.getNoteId());
        if (notes != null) {
            notes.setNoteTitle(noteForm.getNoteTitle());
            notes.setNoteDescription(noteForm.getNoteDescription());
            noteMapper.updateNoteById(notes);
        } else {
            notes = new Note();
            notes.setNoteTitle(noteForm.getNoteTitle());
            notes.setNoteDescription(noteForm.getNoteDescription());
            noteMapper.insertNote(notes);
        }
    }

    public Note getNote(Integer noteId) {
        return noteMapper.findNoteById(noteId);
    }

    public List<Note> getPageNotes() {
        return noteMapper.getAllNotes();
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }


}

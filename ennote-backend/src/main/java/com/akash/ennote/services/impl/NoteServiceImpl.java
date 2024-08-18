package com.akash.ennote.services.impl;

import com.akash.ennote.entity.Note;
import com.akash.ennote.repository.NoteRepository;
import com.akash.ennote.services.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    private  final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUserName(userName);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(Long noteId, String userName, String content) {
        Note note=noteRepository.findById(noteId).orElseThrow(
                ()-> new RuntimeException("Note not found")
        );
        note.setContent(content);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String userName) {
        return noteRepository.findByOwnerUserName(userName);
    }
}

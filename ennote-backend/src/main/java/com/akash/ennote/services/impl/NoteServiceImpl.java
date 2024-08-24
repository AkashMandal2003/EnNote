package com.akash.ennote.services.impl;

import com.akash.ennote.entity.Note;
import com.akash.ennote.repository.NoteRepository;
import com.akash.ennote.services.AuditLogService;
import com.akash.ennote.services.NoteService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    private  final NoteRepository noteRepository;

    private final AuditLogService auditLogService;

    public NoteServiceImpl(NoteRepository noteRepository, AuditLogService auditLogService) {
        this.noteRepository = noteRepository;
        this.auditLogService = auditLogService;
    }

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUserName(userName);
        note.setCreatedAt(new Date());
        Note savedNote = noteRepository.save(note);
        auditLogService.logNoteCreation(userName, note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String userName, String content) {
        Note note=noteRepository.findById(noteId).orElseThrow(
                ()-> new RuntimeException("Note not found")
        );
        note.setContent(content);
        Note updatedNote = noteRepository.save(note);
        auditLogService.logNoteUpdate(userName, note);
        return updatedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        Note note=noteRepository.findById(noteId).orElseThrow(()->new RuntimeException("Note not found"));
        auditLogService.logNoteDeletion(userName, noteId);
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getNotesForUser(String userName) {
        return noteRepository.findByOwnerUserName(userName);
    }
}

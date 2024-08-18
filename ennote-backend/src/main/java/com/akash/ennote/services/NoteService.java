package com.akash.ennote.services;

import com.akash.ennote.entity.Note;

import java.util.List;

public interface NoteService {

    Note createNoteForUser(String userName, String content);

    Note updateNoteForUser(Long noteId, String userName, String content);

    void deleteNoteForUser(Long noteId, String userName);

    List<Note> getNotesForUser(String userName);

}

package com.akash.ennote.services;

import com.akash.ennote.entity.AuditLog;
import com.akash.ennote.entity.Note;

import java.util.List;

public interface AuditLogService {

    void logNoteCreation(String username, Note note);

    void logNoteUpdate(String username, Note note);

    void logNoteDeletion(String username, Long noteId);

    List<AuditLog> getAllAuditLogs();

    List<AuditLog> getAllAuditLogsForNoteId(Long noteId);
}

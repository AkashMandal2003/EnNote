package com.akash.ennote.services.impl;

import com.akash.ennote.entity.AuditLog;
import com.akash.ennote.entity.Note;
import com.akash.ennote.repository.AuditLogRepository;
import com.akash.ennote.services.AuditLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void logNoteCreation(String username, Note note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("CREATE");
        auditLog.setUsername(username);
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);

    }

    @Override
    public void logNoteUpdate(String username, Note note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("UPDATE");
        auditLog.setUsername(username);
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);

    }

    @Override
    public void logNoteDeletion(String username, Long noteId) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("DELETE");
        auditLog.setUsername(username);
        auditLog.setNoteId(noteId);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    @Override
    public List<AuditLog> getAllAuditLogsForNoteId(Long noteId) {
        return auditLogRepository.findByNoteId(noteId);
    }
}

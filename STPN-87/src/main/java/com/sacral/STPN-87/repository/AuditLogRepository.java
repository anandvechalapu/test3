package com.sacral.STPN-87.repository;

import com.sacral.STPN-87.model.AuditLogDto;

public interface AuditLogRepository {

    AuditLogDto saveAuditLog(AuditLogDto auditLogDto);
    AuditLogDto getAuditLogById(Long id);
    void deleteAuditLogById(Long id);
    void updateAuditLog(AuditLogDto auditLogDto);
}
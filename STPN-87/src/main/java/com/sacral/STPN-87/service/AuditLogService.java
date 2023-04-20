package com.sacral.STPN-87.service;

import com.sacral.STPN-87.model.AuditLogDto;
import com.sacral.STPN-87.repository.AuditLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLogDto saveAuditLog(AuditLogDto auditLogDto) {
        return auditLogRepository.saveAuditLog(auditLogDto);
    }

    public AuditLogDto getAuditLogById(Long id) {
        return auditLogRepository.getAuditLogById(id);
    }

    public void deleteAuditLogById(Long id) {
        auditLogRepository.deleteAuditLogById(id);
    }

    public void updateAuditLog(AuditLogDto auditLogDto) {
        auditLogRepository.updateAuditLog(auditLogDto);
    }
}
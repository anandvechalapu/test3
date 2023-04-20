-------------------------------------------------------------------------------------------------------------------------

package com.sacral.STPN-87.controller;

import com.sacral.STPN-87.model.AuditLogDto;
import com.sacral.STPN-87.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auditlogs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @PostMapping
    public ResponseEntity<AuditLogDto> saveAuditLog(@RequestBody AuditLogDto auditLogDto) {
        return new ResponseEntity<>(auditLogService.saveAuditLog(auditLogDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDto> getAuditLogById(@PathVariable Long id) {
        return new ResponseEntity<>(auditLogService.getAuditLogById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLogById(@PathVariable Long id) {
        auditLogService.deleteAuditLogById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AuditLogDto> updateAuditLog(@RequestBody AuditLogDto auditLogDto) {
        return new ResponseEntity<>(auditLogService.updateAuditLog(auditLogDto), HttpStatus.OK);
    }
}
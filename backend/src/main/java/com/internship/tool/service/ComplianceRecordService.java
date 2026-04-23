package com.internship.tool.service;

import com.internship.tool.entity.ComplianceRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface ComplianceRecordService {

    ComplianceRecord create(ComplianceRecord record);

    ComplianceRecord getById(Long id);

    List<ComplianceRecord> getAll();

    ComplianceRecord update(Long id, ComplianceRecord record);

    void delete(Long id);

    List<ComplianceRecord> search(String keyword);

    List<ComplianceRecord> filterByStatus(String status);

    List<ComplianceRecord> filterByDateRange(LocalDateTime start, LocalDateTime end);
}
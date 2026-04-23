package com.internship.tool.controller;

import com.internship.tool.entity.ComplianceRecord;
import com.internship.tool.service.ComplianceRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@RequiredArgsConstructor
public class ComplianceRecordController {

    private final ComplianceRecordService service;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<ComplianceRecord> create(@Valid @RequestBody ComplianceRecord record) {
        return ResponseEntity.ok(service.create(record));
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<ComplianceRecord>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ComplianceRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ComplianceRecord> update(@PathVariable Long id,
                                                   @RequestBody ComplianceRecord record) {
        return ResponseEntity.ok(service.update(id, record));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // ✅ SEARCH
    @GetMapping("/search")
    public ResponseEntity<List<ComplianceRecord>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }

    // ✅ FILTER BY STATUS
    @GetMapping("/status")
    public ResponseEntity<List<ComplianceRecord>> filterByStatus(@RequestParam String status) {
        return ResponseEntity.ok(service.filterByStatus(status));
    }

    // ✅ FILTER BY DATE RANGE
    @GetMapping("/date-range")
    public ResponseEntity<List<ComplianceRecord>> filterByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(service.filterByDateRange(start, end));
    }
}
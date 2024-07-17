package com.longrunningapi.longapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataProcessingController {

    @Autowired
    private DataProcessingService service;

    @Autowired
    private DataProcessingRepository repository;

    @PostMapping("/start")
    public ResponseEntity<Long> startProcessing() {
        DataProcessing dataProcessing = new DataProcessing();
        dataProcessing.setStatus("Pending");
        dataProcessing = repository.save(dataProcessing);
        service.processData(dataProcessing.getId());
        return ResponseEntity.ok(dataProcessing.getId());
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<DataProcessing> getStatus(@PathVariable Long id) {
        return ResponseEntity.of(repository.findById(id));
    }
}

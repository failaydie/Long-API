package com.longrunningapi.longapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DataProcessingService {

    @Autowired
    private DataProcessingRepository repository;

    @Async
    public CompletableFuture<DataProcessing> processData(Long id) {
        DataProcessing dataProcessing = repository.findById(id).orElseThrow();
        dataProcessing.setStatus("Processing");
        repository.save(dataProcessing);

        // Simulasi proses yang lama
        try {
            Thread.sleep(300000); // 5 menit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dataProcessing.setStatus("Completed");
        dataProcessing.setResult("Processed data result");
        repository.save(dataProcessing);

        return CompletableFuture.completedFuture(dataProcessing);
    }
}

package com.longrunningapi.longapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataProcessingRepository extends JpaRepository<DataProcessing, Long> {
}

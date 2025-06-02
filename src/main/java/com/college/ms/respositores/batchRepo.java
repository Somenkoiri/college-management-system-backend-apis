package com.college.ms.respositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.ms.entities.BatchName;

public interface batchRepo extends JpaRepository<BatchName, Long> {

}

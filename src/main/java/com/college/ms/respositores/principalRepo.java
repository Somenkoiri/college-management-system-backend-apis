package com.college.ms.respositores;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.ms.entities.Principal;

public interface principalRepo extends JpaRepository<Principal, Long> {

	List<Principal> findByStatus(int status);
}

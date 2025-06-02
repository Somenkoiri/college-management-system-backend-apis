package com.college.ms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batch_name_tbl")
@NoArgsConstructor
@Getter
@Setter
public class BatchName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id")
	private Long batchNameId;
	
	@Column(name = "batch_name" , length = 150)
	private String batchName;
	
	@OneToMany(mappedBy = "batchName")
	private List<Sir> sirs = new ArrayList<>();
	

}

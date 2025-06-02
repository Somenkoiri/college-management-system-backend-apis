package com.college.ms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sir_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sir {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sirId;
	
	private String sirName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "collage_name")
	private CollageName collageName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "batch_name")
	private BatchName batchName;

	private String sirEmail;
	
	private String sirPassword;
}

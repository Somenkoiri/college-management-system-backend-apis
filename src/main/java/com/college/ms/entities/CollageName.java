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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "collage_name_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CollageName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collage_id")
	private Long collageId;
	
	@Column(name = "collage_name" , length = 100)
	private String collageName;
	
	@OneToMany(mappedBy = "collageName")
	private List<Principal> principals = new ArrayList<>();
	
	@OneToMany(mappedBy = "collageName")
	private List<Sir> sirs = new ArrayList<>();
}

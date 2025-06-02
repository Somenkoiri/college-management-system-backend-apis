package com.college.ms.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "principal_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Principal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long principalId;
	
	@Column(name = "principal_name", length = 100)
	private String principalName;
	
	@Column(name = "principal_email", length = 250)
	private String principalEmail;
	
	@Column(name = "principal_password", length = 100)
	private String principalPassword;


	private int status = 1;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "collage_id")
	private CollageName collageName;

}

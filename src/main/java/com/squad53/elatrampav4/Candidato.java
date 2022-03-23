package com.squad53.elatrampav4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity


public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
		
	private String Nome;
	private String Cpf;
	private String Email;
	private String Telefone;
	
}

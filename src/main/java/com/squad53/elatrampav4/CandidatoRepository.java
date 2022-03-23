package com.squad53.elatrampav4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

	
}

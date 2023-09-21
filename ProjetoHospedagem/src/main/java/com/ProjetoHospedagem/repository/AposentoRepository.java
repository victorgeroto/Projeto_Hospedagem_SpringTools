package com.ProjetoHospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoHospedagem.entities.Aposento;

public interface AposentoRepository  extends JpaRepository<Aposento, Long>{
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}
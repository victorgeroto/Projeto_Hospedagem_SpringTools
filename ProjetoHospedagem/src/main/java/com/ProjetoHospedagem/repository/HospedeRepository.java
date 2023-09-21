package com.ProjetoHospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoHospedagem.entities.Hospede;

public interface HospedeRepository  extends JpaRepository<Hospede, Long>{
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}

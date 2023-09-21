package com.ProjetoHospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoHospedagem.entities.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long>{
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}

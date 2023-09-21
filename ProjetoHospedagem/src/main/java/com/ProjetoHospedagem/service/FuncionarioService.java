package com.ProjetoHospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoHospedagem.entities.Funcionario;
import com.ProjetoHospedagem.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    //construtor que recebe a dependencia
    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    
    public List<Funcionario> buscaTodosFuncionarios(){
    	return funcionarioRepository.findAll();
    }
    
    public Funcionario buscaFuncionarioCodigo(Long codigo) {
        Optional <Funcionario> funcionario = funcionarioRepository.findById(codigo);
        return funcionario.orElse(null);
    }
    //metodo salvar os produtos
    public Funcionario SalvaFuncionario(Funcionario funcionario) {
    	return funcionarioRepository.save(funcionario);
    }
    public Funcionario alterarFuncionario(Long codigo, Funcionario alterarFunc) {
    	Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
    	
    	if (existeFuncionario.isPresent()) {
    		alterarFunc.setCodigo(codigo);
    		return funcionarioRepository.save(alterarFunc);
    	}
    	return null;
    }
    public boolean apagarFuncionario(Long codigo) {
    	Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
    	if (existeFuncionario.isPresent()) {
    		funcionarioRepository.deleteById(codigo);
    		return true;
    	}
    	return false;
    }
}

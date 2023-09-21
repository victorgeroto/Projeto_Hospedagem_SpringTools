package com.ProjetoHospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoHospedagem.entities.Hospede;
import com.ProjetoHospedagem.repository.HospedeRepository;

@Service
public class HospedeService {
    private final HospedeRepository hospedeRepository;

    //construtor que recebe a dependencia
    @Autowired
    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }
    
    public List<Hospede> buscaTodosHospedes(){
    	return hospedeRepository.findAll();
    }
    
    public Hospede buscaHospedeCodigo(Long codigo) {
        Optional <Hospede> hospede = hospedeRepository.findById(codigo);
        return hospede.orElse(null);
    }
    //metodo salvar os produtos
    public Hospede SalvaHospede(Hospede hospede) {
    	return hospedeRepository.save(hospede);
    }
    public Hospede alterarHospede(Long codigo, Hospede alterarFunc) {
    	Optional <Hospede> existeHospede = hospedeRepository.findById(codigo);
    	
    	if (existeHospede.isPresent()) {
    		alterarFunc.setCodigo(codigo);
    		return hospedeRepository.save(alterarFunc);
    	}
    	return null;
    }
    public boolean apagarHospede(Long codigo) {
    	Optional <Hospede> existeHospede = hospedeRepository.findById(codigo);
    	if (existeHospede.isPresent()) {
    		hospedeRepository.deleteById(codigo);
    		return true;
    	}
    	return false;
    }
}
package com.ProjetoHospedagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoHospedagem.entities.Hospede;
import com.ProjetoHospedagem.service.HospedeService;

@RestController
@RequestMapping("/hospedes")

public class HospedeController {
    private final HospedeService hospedeService;

    @Autowired
    public HospedeController(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Hospede> buscaHospedeControlId(@PathVariable Long codigo){
    	Hospede hospede = hospedeService.buscaHospedeCodigo(codigo);
    	if (hospede != null) {
    		return ResponseEntity.ok(hospede);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
    public ResponseEntity<List<Hospede>> buscaTodosHospedesControl(){
    	List<Hospede> Hospedes = hospedeService.buscaTodosHospedes();
    	
    	return ResponseEntity.ok(Hospedes);
    }
    @PostMapping("/")
    public ResponseEntity<Hospede> salvaHospedesControl(@RequestBody Hospede hospede){
    	Hospede salvaHospede = hospedeService.SalvaHospede(hospede);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaHospede);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Hospede> alteraHospedeControl(@PathVariable Long codigo, @RequestBody Hospede hospede){
    	Hospede alteraHospede = hospedeService.alterarHospede(codigo, hospede);
    	if(alteraHospede != null) {
    		return ResponseEntity.ok(hospede);
    	}
    	else {
    		return ResponseEntity.notFound().build();   	
    		}
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaHospedeControl(@PathVariable Long codigo){
    	boolean apagar = hospedeService.apagarHospede(codigo);
    	if (apagar) {
    		return ResponseEntity.ok().body("O Hospede foi excluido com sucesso");
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
}

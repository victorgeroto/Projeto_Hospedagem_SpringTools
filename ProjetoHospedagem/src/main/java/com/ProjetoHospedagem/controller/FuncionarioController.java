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

import com.ProjetoHospedagem.entities.Funcionario;
import com.ProjetoHospedagem.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long codigo){
    	Funcionario funcionario = funcionarioService.buscaFuncionarioCodigo(codigo);
    	if (funcionario != null) {
    		return ResponseEntity.ok(funcionario);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl(){
    	List<Funcionario> Funcionarios = funcionarioService.buscaTodosFuncionarios();
    	
    	return ResponseEntity.ok(Funcionarios);
    }
    @PostMapping("/")
    public ResponseEntity<Funcionario> salvaFuncionariosControl(@RequestBody Funcionario funcionario){
    	Funcionario salvaFuncionario = funcionarioService.SalvaFuncionario(funcionario);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable Long codigo, @RequestBody Funcionario funcionario){
    	Funcionario alteraFuncionario = funcionarioService.alterarFuncionario(codigo, funcionario);
    	if(alteraFuncionario != null) {
    		return ResponseEntity.ok(funcionario);
    	}
    	else {
    		return ResponseEntity.notFound().build();   	
    		}
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaFuncionarioControl(@PathVariable Long codigo){
    	boolean apagar = funcionarioService.apagarFuncionario(codigo);
    	if (apagar) {
    		return ResponseEntity.ok().body("O Funcionario foi excluido com sucesso");
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    
}
package com.br.zup.controllers;

import javax.validation.Valid;

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

import com.br.zup.modells.Receita;
import com.br.zup.services.ReceitaService;

@RestController
@RequestMapping("/api")
public class ReceitaController {
	@Autowired
	private ReceitaService receitaService;
	@PostMapping
	public ResponseEntity<?> criarReceita (@Valid @RequestBody Receita receita) {
		try {
			receitaService.criarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping
	public ResponseEntity<?> verReceita (){
		return ResponseEntity.ok(receitaService.verReceita());
	}
	@GetMapping("{id}")
	public ResponseEntity<?> verReceitaPorId (@PathVariable int id) {
		try {
			Receita receita = receitaService.verReceitaPorId(id);
			return ResponseEntity.ok(receita);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<?> atualizarReceita (@PathVariable int id,@Valid @RequestBody Receita receita){
		receitaService.atualizarReceita(id, receita);
		return 	ResponseEntity.ok(receita);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletarReceita (@PathVariable int id) {
		receitaService.deletarReceita(id);
		return ResponseEntity.ok().build();
	}
	
}





















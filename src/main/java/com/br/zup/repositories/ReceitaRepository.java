package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.modells.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer> {

}

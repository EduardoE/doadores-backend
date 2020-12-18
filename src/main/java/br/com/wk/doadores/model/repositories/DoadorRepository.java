package br.com.wk.doadores.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entities.Doador;

public interface DoadorRepository extends CrudRepository <Doador, Integer> {
	
	
}

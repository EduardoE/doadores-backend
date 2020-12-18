package br.com.wk.doadores.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entities.Contato;

public interface ContatoRepository extends CrudRepository <Contato, Integer>{

}

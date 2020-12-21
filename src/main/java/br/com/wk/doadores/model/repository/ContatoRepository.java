package br.com.wk.doadores.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entity.Contato;

public interface ContatoRepository extends CrudRepository <Contato, Integer>{

}

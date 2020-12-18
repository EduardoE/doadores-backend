package br.com.wk.doadores.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entities.Endereco;

public interface EnderecoRepository extends CrudRepository <Endereco, Integer> {

}

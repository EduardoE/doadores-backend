package br.com.wk.doadores.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entity.Endereco;
import br.com.wk.doadores.model.service.DoadoresPorEstado;

public interface EnderecoRepository extends CrudRepository <Endereco, Integer> {
	
    @Query("SELECT " +
            " new br.com.wk.doadores.model.service.DoadoresPorEstado (e.estado, COUNT(e.id)) " +
            " FROM " +
            "  Endereco e " +
            "   GROUP BY " +
            "    e.estado")
     List<DoadoresPorEstado> getDoadoresPorEstado();
}

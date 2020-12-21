package br.com.wk.doadores.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.wk.doadores.model.entity.Doador;

public interface DoadorRepository extends CrudRepository <Doador, Integer> {
	
	@Query("SELECT d from Doador d where d.tipo_sanguineo = ?1")
     List<Doador> getDoadoresPorTipoSanguineo(String tipoSanguineo);
	
	@Query("SELECT d.tipo_sanguineo  FROM Doador d group by d.tipo_sanguineo")
    List<String> getTodosTiposSanguineos();
}

package br.com.wk.doadores.model.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClassificarDoadores {
	private EntityManager entityManager;
	
	@Query(value = "select count(v) as cnt, v.answer from Survey v group by v.answer")
	public List<?> getDoadoresPorEstado () {
		Query q = entityManager.createNativeQuery("select count(estado), estado from doadores.endereco group by estado;");
		
		List<Object[]> authors = q.getResultList();
		for (Object[] a : authors) {
		    System.out.println("Author "
		            + a[0]
		            + " "
		            + a[1]);
		}
	}
	
	public static void main(String[] args) {
		ClassificarDoadores cd = new ClassificarDoadores();
		cd.getDoadoresPorEstado();
	}
}

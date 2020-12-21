package br.com.wk.doadores.model.service;

import java.text.ParseException;
import java.util.List;
import br.com.wk.doadores.model.entity.Doador;

public class MediaIdadeDoadoresPorTipoSanguineoService {
	
	public double calcularMediaIdadePorTipoSanquineo(List<Doador> doadoresPortipoSanguineo) throws ParseException {
		
		int somaIdades = 0;

		for (Doador d: doadoresPortipoSanguineo) {
			System.out.println(d.getTipoSanguineo());

			System.out.println(d.getIdade());

			somaIdades += d.getIdade();
		}
		
		double mediaIdadesPorTipoSanguineo = Math.round((double) somaIdades / doadoresPortipoSanguineo.size());
		
		
		return mediaIdadesPorTipoSanguineo;
	
	}
}

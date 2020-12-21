package br.com.wk.doadores.model.service;

import br.com.wk.doadores.model.entity.Doador;

public class PercentualObesosHomemMulher {
		
	private final int LIMITE_NAO_OBESO = 30;
	
	public PercentualObesos calculaPercentualObesos(Iterable<Doador> doadores) {
		int countHomemsObesos = 0;
		int countMulheresObesas = 0;
				
		for (Doador d: doadores) {
			if(d.getImc() > LIMITE_NAO_OBESO) {
				if(d.getSexo().equals("Masculino")) {
					countHomemsObesos ++;
				} else {
					countMulheresObesas ++;
				}
			}
		}
		
		double totalObesos = countHomemsObesos + countMulheresObesas;

		if(totalObesos > 0) {
			double percentualHomem = Math.round((countHomemsObesos * 100) / totalObesos);
			double percentualMulher = Math.round((countMulheresObesas * 100) / totalObesos);
			
			return new PercentualObesos(percentualHomem, percentualMulher);
		}
		return null;
	}
	
}

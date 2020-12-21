package br.com.wk.doadores.model.service;

import java.text.ParseException;

import br.com.wk.doadores.model.entity.Doador;

public class IMCDoadoresFaixaEtariaService {
	
	// CONSTANTES PARA ACESSAR O ARRAY COM MÉDIAS DE IMCS DE ACORDO A FAIXA ETÁRIA
	final int DE_0_ANOS_A_10 = 0;
	final int DE_11_ANOS_A_20 = 1;
	final int DE_21_ANOS_A_30 = 2;
	final int DE_31_ANOS_A_40 = 3;
	final int DE_41_ANOS_A_50 = 4;
	final int DE_51_ANOS_A_60 = 5;
	final int DE_61_ANOS_A_70 = 6;
	final int DE_71_ANOS_A_80 = 7;

	private double [] somatorioIMCfaixasEtarias = {0,0,0,0,0,0,0,0};
	private int [] countIMCfaixasEtarias = {0,0,0,0,0,0,0,0};
	
	private IMCDoadoresFaixaEtaria [] colecaoIMCfaixasEtarias = {
			new IMCDoadoresFaixaEtaria("0-10 Anos"),
			new IMCDoadoresFaixaEtaria("11-20 Anos"),
			new IMCDoadoresFaixaEtaria("21-30 Anos"),
			new IMCDoadoresFaixaEtaria("31-40 Anos"),
			new IMCDoadoresFaixaEtaria("41-50 Anos"),
			new IMCDoadoresFaixaEtaria("50-60 Anos"),
			new IMCDoadoresFaixaEtaria("61-70 Anos"),
			new IMCDoadoresFaixaEtaria("71-80 Anos")};
	
	public IMCDoadoresFaixaEtaria[] getColecaoIMCDoadoresFaixaEtaria (Iterable<Doador> doadores) throws ParseException {
		
		for (Doador d: doadores) {

			somatorioIMCfaixasEtarias[getFaixaEtariaDoador(d.getIdade())] += d.getImc();
			countIMCfaixasEtarias[getFaixaEtariaDoador(d.getIdade())] += 1;
		}
		
		for (int i = 0; i < somatorioIMCfaixasEtarias.length; i++) {
			colecaoIMCfaixasEtarias[i].setMediaIMCporFaixaEtaria(somatorioIMCfaixasEtarias[i] / (double) countIMCfaixasEtarias[i]);
		}
		
		// Arredondamento e tratamento para o valor Double da média de IMC doadores por faixa etária
		for (IMCDoadoresFaixaEtaria imcDoadoresFaixaEtaria: colecaoIMCfaixasEtarias) {
			imcDoadoresFaixaEtaria.setMediaIMCporFaixaEtaria(Math.round(imcDoadoresFaixaEtaria.getMediaIMCporFaixaEtaria()));
		}
		
		return colecaoIMCfaixasEtarias;

	}
	
	private int getFaixaEtariaDoador(int idade) {
		
		if(idade >= 0 && idade <= 10) {
			
			return DE_0_ANOS_A_10;
		} else if (idade >= 11 && idade <= 20) {
			
			return DE_11_ANOS_A_20;
		} else if (idade >= 21 && idade <= 30) {
			
			return DE_21_ANOS_A_30;
		} else if (idade >= 31 && idade <= 40) {
			
			return DE_31_ANOS_A_40;
		} else if (idade >= 41 && idade <= 50) {
			
			return DE_41_ANOS_A_50;
		} else if (idade >= 51 && idade <= 60) {
			
			return DE_51_ANOS_A_60;
		}else if (idade >= 61 && idade <= 70) {
			
			return DE_61_ANOS_A_70;
		} else {
	
			return DE_71_ANOS_A_80;
		}	
	}
}

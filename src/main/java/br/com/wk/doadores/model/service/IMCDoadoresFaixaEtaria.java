package br.com.wk.doadores.model.service;

public class IMCDoadoresFaixaEtaria {
	private String faixaEtaria;
	private double mediaIMCporFaixaEtaria;
	
	public IMCDoadoresFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	public String getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public double getMediaIMCporFaixaEtaria() {
		return mediaIMCporFaixaEtaria;
	}
	public void setMediaIMCporFaixaEtaria(double mediaIMCporFaixaEtaria) {
		this.mediaIMCporFaixaEtaria = mediaIMCporFaixaEtaria;
	}

	@Override
	public String toString() {
		return "{ faixaEtaria :" + faixaEtaria + ", mediaIMCporFaixaEtaria: "
				+ String.format("%.2f", mediaIMCporFaixaEtaria) + "}";
	}
	
	
	
}

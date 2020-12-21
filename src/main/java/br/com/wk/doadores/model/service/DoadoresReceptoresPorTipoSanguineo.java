package br.com.wk.doadores.model.service;

public class DoadoresReceptoresPorTipoSanguineo {
	private String tipoSanguineo;
	private int countDoadores;
	private int countReceptores;
	
		
	public DoadoresReceptoresPorTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
		this.setCountDoadores(0);
		this.setCountReceptores(0);
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}


	public int getCountDoadores() {
		return countDoadores;
	}


	public void setCountDoadores(int countDoadores) {
		this.countDoadores = countDoadores;
	}


	public int getCountReceptores() {
		return countReceptores;
	}


	public void setCountReceptores(int countReceptores) {
		this.countReceptores = countReceptores;
	}
	
}

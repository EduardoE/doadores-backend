package br.com.wk.doadores.model.service;

public class MediaIdadeDoadoresPorTipoSanguineo {
	
	private String tipo_sanguineo;
	private double media;
		
	public MediaIdadeDoadoresPorTipoSanguineo(String tipo_sanguineo, double mediaIdade) {
		this.media = mediaIdade;
		this.tipo_sanguineo = tipo_sanguineo;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double mediaIdade) {
		this.media = mediaIdade;
	}
	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}
	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}
	
}

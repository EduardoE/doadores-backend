package br.com.wk.doadores.model.service;

public class PercentualObesos {
	private double percentualHomem;
	private double percentualMulher;
	
	public PercentualObesos(double percentualHomem, double percentualMulher) {
		this.percentualHomem = percentualHomem;
		this.percentualMulher = percentualMulher;
	}
	public double getPercentualHomem() {
		return percentualHomem;
	}
	public void setPercentualHomem(double percentualHomem) {
		this.percentualHomem = percentualHomem;
	}
	public double getPercentualMulher() {
		return percentualMulher;
	}
	public void setPercentualMulher(double percentualMulher) {
		this.percentualMulher = percentualMulher;
	}

}

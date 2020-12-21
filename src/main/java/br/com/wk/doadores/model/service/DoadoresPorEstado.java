package br.com.wk.doadores.model.service;

public class DoadoresPorEstado {
	private String estado;
	private Long count;

	public DoadoresPorEstado(String estado, Long count) {
		this.estado = estado;
		this.count = count;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}

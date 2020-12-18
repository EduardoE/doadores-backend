package br.com.wk.doadores.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String celular; 
	private String telefone_fixo; 
	private String email; 
	
	@JsonBackReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_doador" ,nullable=false)  
	private Doador doador;
	
	public Contato(String celular, String telefone_fixo, String email) {
		this.celular = celular;
		this.telefone_fixo = telefone_fixo;
		this.email = email;
	}
	
	public Contato() {}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	
	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
}

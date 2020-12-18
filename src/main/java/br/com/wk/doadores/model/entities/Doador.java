package br.com.wk.doadores.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String data_nasc;
	private String sexo;
	private String mae;
	private String pai;
	private double peso;
	private double altura;
	private String tipo_sanguineo;
	
	@JsonManagedReference
	@OneToOne(targetEntity=Endereco.class, mappedBy="doador",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@OneToOne(targetEntity=Contato.class, mappedBy="doador",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Contato contato;
	
	public Doador(String nome, String cpf, String rg, String data_nasc, String sexo, String mae, String pai,
			double peso, double altura, String tipo_sanguineo , Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
		this.mae = mae;
		this.pai = pai;
		this.peso = peso;
		this.altura = altura;
		this.tipo_sanguineo = tipo_sanguineo;
		this.endereco = endereco;
		this.contato = contato;
		
	}
	
	public Doador() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Doador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", data_nasc=" + data_nasc
				+ ", sexo=" + sexo + ", mae=" + mae + ", pai=" + pai + ", peso=" + peso + ", altura=" + altura
				+ ", tipo_sanguineo=" + tipo_sanguineo + ", endereco=" + endereco + ", contato=" + contato + "]";
	}



}

package br.com.wk.doadores.controllers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.wk.doadores.model.entities.Contato;
import br.com.wk.doadores.model.entities.Doador;
import br.com.wk.doadores.model.entities.Endereco;
import br.com.wk.doadores.model.repositories.ContatoRepository;
import br.com.wk.doadores.model.repositories.DoadorRepository;
import br.com.wk.doadores.model.repositories.EnderecoRepository;
import br.com.wk.doadores.services.ObterEntidadeDeJSONObjetc;


@RestController
@RequestMapping("/doador")
public class DoadorController {
	
	@Autowired
	public DoadorRepository doadorRepository;
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	@Autowired
	public ContatoRepository contatoRepository;
	
	@GetMapping
	public Iterable<Doador> getDoadores() {
		Iterable<Doador> doadores = doadorRepository.findAll();

		return doadores;
	}
	
	@PostMapping
	public String newDoadores(@RequestParam MultipartFile json) throws IOException {
		
		byte[] bytes = json.getBytes();
		String data = new String(bytes);
		
		JSONArray jsonarr = new JSONArray(data);
		ObterEntidadeDeJSONObjetc obterEntidade = new ObterEntidadeDeJSONObjetc();
		
		for (int i = 0; i < jsonarr.length(); i++) {
			JSONObject jsonObject = jsonarr.getJSONObject(i);
			
			Doador d = obterEntidade.obterDoadorDeJSONObject(jsonObject);
			Endereco e = obterEntidade.obterEnderecoDeJSONObject(jsonObject);
			Contato c = obterEntidade.obterContatoDeJSONObject(jsonObject);
			
			doadorRepository.save(d);

			e.setDoador(d);
			c.setDoador(d);
			
			enderecoRepository.save(e);
			contatoRepository.save(c);
		}
		
		return "Cadastro realizado com Sucesso!!";

	}
	

}

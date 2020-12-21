package br.com.wk.doadores.controller;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.wk.doadores.model.entity.Contato;
import br.com.wk.doadores.model.entity.Doador;
import br.com.wk.doadores.model.entity.Endereco;
import br.com.wk.doadores.model.repository.ContatoRepository;
import br.com.wk.doadores.model.repository.DoadorRepository;
import br.com.wk.doadores.model.repository.EnderecoRepository;
import br.com.wk.doadores.model.service.IMCDoadoresFaixaEtariaService;
import br.com.wk.doadores.model.service.MediaIdadeDoadoresPorTipoSanguineo;
import br.com.wk.doadores.model.service.MediaIdadeDoadoresPorTipoSanguineoService;
import br.com.wk.doadores.model.service.DoadoresPorEstado;
import br.com.wk.doadores.model.service.IMCDoadoresFaixaEtaria;
import br.com.wk.doadores.model.service.ObterEntidadeDeJSONObjetc;
import br.com.wk.doadores.model.service.PercentualObesos;
import br.com.wk.doadores.model.service.PercentualObesosHomemMulher;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/doador")
public class DoadorController {
	
	@Autowired
	public DoadorRepository doadorRepository;
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	@Autowired
	public ContatoRepository contatoRepository;
	
	@GetMapping("/imc")
	public IMCDoadoresFaixaEtaria [] getDoadoresIMCPorFaixa() throws ParseException {
		Iterable<Doador> doadores = doadorRepository.findAll();
		
		IMCDoadoresFaixaEtariaService imcDoadoresFaixaEtaria = new IMCDoadoresFaixaEtariaService();
		
		return imcDoadoresFaixaEtaria.getColecaoIMCDoadoresFaixaEtaria(doadores);
	}
	
	@GetMapping
	public List<DoadoresPorEstado> getQtdDoadoresPorEstado() {
		return enderecoRepository.getDoadoresPorEstado();
	
	}

	
	@GetMapping("/obesos")
	public PercentualObesos getPercentualObesos() throws ParseException {
		Iterable<Doador> doadores = doadorRepository.findAll();
		
		PercentualObesosHomemMulher percentualObesos = new PercentualObesosHomemMulher();
		
		return percentualObesos.calculaPercentualObesos(doadores);
	}
	
	@GetMapping("/media-idade-tiposanguineo")
	public List<MediaIdadeDoadoresPorTipoSanguineo> getMediaIdatePorTipoSanguineo() throws ParseException {
		
		List<MediaIdadeDoadoresPorTipoSanguineo> mediasIdadePorTipoSanguineo = new ArrayList<MediaIdadeDoadoresPorTipoSanguineo>();

		MediaIdadeDoadoresPorTipoSanguineoService service = new MediaIdadeDoadoresPorTipoSanguineoService();
		
		List<String> tiposSanguineos = doadorRepository.getTodosTiposSanguineos();
		
		for(String tipoSanguineo: tiposSanguineos) {
			List<Doador> doadores = doadorRepository.getDoadoresPorTipoSanguineo(tipoSanguineo);
			
			mediasIdadePorTipoSanguineo.add(
					new MediaIdadeDoadoresPorTipoSanguineo(tipoSanguineo, service.calcularMediaIdadePorTipoSanquineo(doadores)));
			
		}
		return mediasIdadePorTipoSanguineo;
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

package br.com.wk.doadores.services;

import org.json.JSONObject;

import br.com.wk.doadores.model.entities.Contato;
import br.com.wk.doadores.model.entities.Doador;
import br.com.wk.doadores.model.entities.Endereco;

public class ObterEntidadeDeJSONObjetc {
	public Doador obterDoadorDeJSONObject(JSONObject jsonObject) {
		try {
			Doador d = new Doador();
			
			d.setNome(jsonObject.getString("nome"));
			d.setCpf(jsonObject.getString("cpf"));
			d.setRg(jsonObject.getString("rg"));
			d.setData_nasc(jsonObject.getString("data_nasc"));
			d.setSexo(jsonObject.getString("sexo"));
			d.setMae(jsonObject.getString("mae"));
			d.setPai(jsonObject.getString("pai"));
			d.setAltura(jsonObject.getDouble("altura"));
			d.setPeso(jsonObject.getDouble("peso"));
			d.setTipo_sanguineo(jsonObject.getString("tipo_sanguineo"));
			
			return d;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return null;
	}
	
	public Endereco obterEnderecoDeJSONObject (JSONObject jsonObject) {
		try {	
			Endereco e = new Endereco();
			
			e.setRua(jsonObject.getString("endereco"));
			e.setNumero(jsonObject.getInt("numero"));
			e.setBairro(jsonObject.getString("bairro"));
			e.setCidade(jsonObject.getString("cidade"));;
			e.setEstado(jsonObject.getString("estado"));;
			e.setCep(jsonObject.getString("cep"));
			
			return e;
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		return null;
	}
	
	public Contato obterContatoDeJSONObject(JSONObject jsonObject) {
		try {
			Contato c = new Contato();
			
			c.setCelular(jsonObject.getString("celular"));
			c.setEmail(jsonObject.getString("email"));
			c.setTelefone_fixo(jsonObject.getString("telefone_fixo"));
			
			return c; 
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return null;
	}
	
}

package test;

import static org.hamcrest.Matchers.*;

import java.util.Calendar;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import comuns.JsonUsuario;

/**
 * @author Luiz Salvador
 * 
 *Classe de teste que valida o cadastro, edição e exclusão de um usuário
 */

public class UsuarioTest {
	

	//Gerador de nomes aleatórios
	public static int numero = gerarNumerosAleatorios(0, 99999);
	static String nomeCadastro = "Luiz"+numero+" da Silva";
	static String emailCadastro = "LuizDaSilva"+numero+"@qa.com"; 
	static String senhaCadastro = "S"+numero; 
	
	static String nomeEditar = "Ricardo"+numero+" De Ramo";
	static String emailEditar = "RicardoDeRamos"+numero+"@qa.com"; 
	static String senhaEditar = "R"+numero; 


	@Test
	@DisplayName("Cadastrar usuário")
	public void test001() {
		JsonUsuario json = new JsonUsuario(nomeCadastro, emailCadastro, senhaCadastro, "false");		
		given()
			.contentType("application/json")
			.body(json)
		.when()
			.post(BASE_URL)	
		.then()
			.statusCode(201);
		System.out.println("Usuário cadastrado: " + nomeCadastro);	
	}
	
	@Test
	@DisplayName("Validar usuário cadastrado")
	public void test002() {	
		String idUsuario = localizarIdUsuario(nomeCadastro); 
		
		 given()
		.when()
			.get(URL_USUARIO + idUsuario)

		.then()
			.body("nome", is(nomeCadastro))
			.body("email", is(emailCadastro))
			.body("password", is(senhaCadastro))
			.body("administrador", is("false"))
			.statusCode(200);
		System.out.println("Usuário cadastrado com sucesso: " + nomeCadastro);	
	}

	@Test
	@DisplayName("Editar usuário")
	public void test003() {
		String idUsuario = localizarIdUsuario(nomeCadastro); 
		JsonUsuario json = new JsonUsuario(nomeEditar, emailEditar, senhaEditar, "true");
		
		given()
			.contentType("application/json")
			.body(json)
		.when()
			.put(URL_USUARIO + idUsuario)
			
		.then()
			.statusCode(200);
		System.out.println("Usuário editado: " +nomeEditar);	
		
		}
	
	@Test
	@DisplayName("Validar usuário editado")
	public void test004() {
		//Validar na lista geral de usuários, se foi editado o usuário
		String idUsuario = localizarIdUsuario(nomeEditar); 
		
		 given()
		.when()
			.get(BASE_URL)

		.then()
			.body("usuarios.nome", not(hasItem(nomeCadastro)))
			.body("usuarios.nome", hasItem(nomeEditar))
			.body("usuarios.email", hasItem(emailEditar))
			.body("usuarios.password", hasItem(senhaEditar))
			.body("usuarios.administrador", hasItem("true"))
			.body("usuarios._id", hasItem(idUsuario))
			.statusCode(200);
		 System.out.println("Usuário editado com sucesso: " + nomeEditar);
	}

	@Test
	@DisplayName("Excluir usuário")
	public void test005() {
		String idUsuario = localizarIdUsuario(nomeEditar); 
		
		 given()
		.when()
			.delete(URL_USUARIO + idUsuario)

		.then()
			.statusCode(200);
		 System.out.println("Usuário excluido: " +nomeEditar);
	}
	
	@Test
	@DisplayName("Validar usuário excluido")
	public void test006() {		
		 given()
		.when()
			.get(BASE_URL)

		.then()
			.body("usuarios.nome", not(hasItem(nomeEditar)))
			.statusCode(200);
		 System.out.println("Usuário excluido com sucesso: " + nomeEditar);
	}
	
	
	private static final String BASE_URL = "https://serverest.dev/usuarios";
	private static final String URL_USUARIO = "https://serverest.dev/usuarios/";
	
	private String localizarIdUsuario(String nome){
		String param = "usuarios.findAll{it.nome.contains('"+nome+"')}[0]._id";
		Response response = RestAssured.request(Method.GET, "https://serverest.dev/usuarios");
		JsonPath info = response.jsonPath();
		String idUsuario = info.get(param).toString();
		return idUsuario;
		}
	
	
	private static int gerarNumerosAleatorios(int minimo, int maximo) {
		 Calendar lCDateTime = Calendar.getInstance();
	        return (int)(lCDateTime.getTimeInMillis() % (maximo - minimo + 1) + minimo);
	}
}






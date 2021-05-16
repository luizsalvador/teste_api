package comuns;

import java.util.Calendar;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author Luiz Salvador
 * 
 *Classe utilizada para agrupar os metodos utilizados nos testes
 */

public class AuxiliaryMethods {

	/**
	 * Método que localiza e retorna o id de um usuário específico
	 * 
	 * @param nome - nome do usuário a ser localizado
	 * @return - id do usuário
	 */
	public String localizarIdUsuario(String nome) {
		String param = "usuarios.findAll{it.nome.contains('" + nome + "')}[0]._id";
		Response response = RestAssured.request(Method.GET, "https://serverest.dev/usuarios");
		JsonPath info = response.jsonPath();
		String idUsuario = info.get(param).toString();
		return idUsuario;
	}

	/**
	 * Método que retorna uma sequência de numero aleatório
	 * 
	 * @param minimo - valor minimo do intervalo a ser gerado, ex: 99
	 * @param maximo - valor máximo do intervalo a ser gerado, ex: 99999
	 * @return - número gerado
	 */
	public int gerarNumerosAleatorios(int minimo, int maximo) {
		Calendar lCDateTime = Calendar.getInstance();
		return (int) (lCDateTime.getTimeInMillis() % (maximo - minimo + 1) + minimo);
	}
}

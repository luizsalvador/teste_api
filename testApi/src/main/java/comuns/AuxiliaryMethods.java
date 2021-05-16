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
	 * M�todo que localiza e retorna o id de um usu�rio espec�fico
	 * 
	 * @param nome - nome do usu�rio a ser localizado
	 * @return - id do usu�rio
	 */
	public String localizarIdUsuario(String nome) {
		String param = "usuarios.findAll{it.nome.contains('" + nome + "')}[0]._id";
		Response response = RestAssured.request(Method.GET, "https://serverest.dev/usuarios");
		JsonPath info = response.jsonPath();
		String idUsuario = info.get(param).toString();
		return idUsuario;
	}

	/**
	 * M�todo que retorna uma sequ�ncia de numero aleat�rio
	 * 
	 * @param minimo - valor minimo do intervalo a ser gerado, ex: 99
	 * @param maximo - valor m�ximo do intervalo a ser gerado, ex: 99999
	 * @return - n�mero gerado
	 */
	public int gerarNumerosAleatorios(int minimo, int maximo) {
		Calendar lCDateTime = Calendar.getInstance();
		return (int) (lCDateTime.getTimeInMillis() % (maximo - minimo + 1) + minimo);
	}
}

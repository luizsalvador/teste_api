package comuns;

/**
 * @author Luiz Salvador
 * 
 *Classe que gera o json para cadastrar ou editar um usuário
 */

public class JsonUsuario {

	private String nome;
	private String email;
	private String password;
	private String administrador;

	public JsonUsuario(String nome, String email, String password, String administrador) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

}

package saviourFood.usuario;

public class Doador extends Usuario{
	
	private int idDoador;

	public Doador(String nome, String email, String usuario, String senha, String cpf, String telefone, int idDoador) {
		super(nome, email, usuario, senha, cpf, telefone);
		
		this.idDoador = idDoador;
	}

	public int getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(int idDoador) {
		this.idDoador = idDoador;
	}

	
}

package saviourFood.usuario;

public class Recebedor extends Usuario {
	
	private int idRecebedor;

	public Recebedor(String nome, String email, String usuario, String senha, String cpf, String telefone, int idRecebedor) {
		super(nome, email, usuario, senha, cpf, telefone);
		
		
		this.idRecebedor = idRecebedor;
	}

	public int getIdRecebedor() {
		return idRecebedor;
	}

	public void setIdRecebedor(int idRecebedor) {
		this.idRecebedor = idRecebedor;
	}
	
	

}

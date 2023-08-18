package saviourFood.repository;

import saviourFood.usuario.Doador;
import saviourFood.usuario.Recebedor;
import saviourFood.usuario.Usuario;

public interface Repository {

	public void listarItens();
	public void cadastrarDoador(Doador doador);
	public void cadastrarRecebedor(Recebedor recebedor);
	public void atualizar(Usuario usuario);
	public void deletar(int numero);
}

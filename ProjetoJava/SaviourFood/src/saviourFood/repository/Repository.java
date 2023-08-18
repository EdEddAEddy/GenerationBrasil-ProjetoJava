package saviourFood.repository;

import saviourFood.usuario.Doador;
import saviourFood.usuario.Item;
import saviourFood.usuario.Recebedor;

public interface Repository {
	public void adicionarAoCarrinho(int idRecebedor, Item item);

	public void cadastrarDoador(Doador doador);

	public void cadastrarRecebedor(Recebedor recebedor);

	public void atualizarQuantidadeItem(int idDoador, String nomeProduto, int novaQuantidade);

	public void adicionarItem(int id, String nomeProduto, int quantidade);

}

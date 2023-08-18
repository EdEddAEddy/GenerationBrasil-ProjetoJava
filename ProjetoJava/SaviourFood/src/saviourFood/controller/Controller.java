package saviourFood.controller;

import java.util.ArrayList;
import java.util.HashMap;

import saviourFood.repository.Repository;
import saviourFood.usuario.Doador;
import saviourFood.usuario.Item;
import saviourFood.usuario.Recebedor;
import saviourFood.usuario.Usuario;

public class Controller implements Repository {

	private ArrayList<Usuario> listaDoadores = new ArrayList<Usuario>();
	private ArrayList<Usuario> listaRecebedor = new ArrayList<Usuario>();
	private HashMap<Integer, ArrayList<Item>> itensDoador = new HashMap<>();
	private HashMap<Integer, ArrayList<Item>> carrinhoRecebedor = new HashMap<>();

	int idDoador = 0, idRecebedor = 0;

	public void adicionarAoCarrinho(int idRecebedor, Item item) {
	    ArrayList<Item> carrinho = carrinhoRecebedor.getOrDefault(idRecebedor, new ArrayList<>());
	    Item itemDisponivel = encontrarItemDisponivel(item.getNomeProduto(), idRecebedor);

	    if (itemDisponivel != null && itemDisponivel.getQuantidade() >= item.getQuantidade()) {
	        Item itemParaCarrinho = new Item(itemDisponivel.getNomeProduto(), item.getQuantidade());
	        carrinho.add(itemParaCarrinho);
	        carrinhoRecebedor.put(idRecebedor, carrinho);
	        System.out.println("Item adicionado ao carrinho com sucesso");
	    } else {
	        System.out.println("Item não disponível ou quantidade insuficiente.");
	    }
	}
	
	private Item encontrarItemDisponivel(String nomeProduto, int quantidadeDesejada) {
	    ArrayList<Item> itensDisponiveis = getItensDisponiveis();
	    for (Item item : itensDisponiveis) {
	        if (item.getNomeProduto().equals(nomeProduto) && item.getQuantidade() >= quantidadeDesejada) {
	            item.setQuantidade(item.getQuantidade() - quantidadeDesejada);
	            return item;
	        }
	    }
	    return null;
	}

	public void removerDoEstoque(Item item, int quantidade) {
		for (int idDoador : itensDoador.keySet()) {
			ArrayList<Item> itensDoador = this.itensDoador.get(idDoador);
			for (Item i : itensDoador) {
				if (i.getNomeProduto().equals(item.getNomeProduto())) {
					i.setQuantidade(i.getQuantidade() - quantidade);
					break;
				}
			}
		}
	}
	
    public void removerDoCarrinho(int idRecebedor, int indiceItem) {
        ArrayList<Item> carrinho = carrinhoRecebedor.get(idRecebedor);
        
        if (carrinho != null && indiceItem >= 0 && indiceItem < carrinho.size()) {
            Item itemRemovido = carrinho.remove(indiceItem);
            carrinhoRecebedor.put(idRecebedor, carrinho);
            System.out.println("Item removido do carrinho: " + itemRemovido.getNomeProduto());
        } else {
            System.out.println("Índice inválido ou carrinho vazio.");
        }
    }

	@Override
	public void cadastrarDoador(Doador doador) {
		listaDoadores.add(doador);
		System.out.println("\nO Doador número: " + doador.getIdDoador() + " foi criada com sucesso");

	}

	@Override
	public void cadastrarRecebedor(Recebedor recebedor) {
		listaRecebedor.add(recebedor);
		System.out.println("\nO Recebedor número: " + recebedor.getIdRecebedor() + " foi criada com sucesso");

	}

	public void adicionarItem(int id, String nomeProduto, int quantidade) {
		ArrayList<Item> itens = itensDoador.getOrDefault(id, new ArrayList<>());
		itens.add(new Item(nomeProduto, quantidade));
		itensDoador.put(id, itens);
	}

	@Override
	public void atualizarQuantidadeItem(int idDoador, String nomeProduto, int novaQuantidade) {
		ArrayList<Item> itens = itensDoador.getOrDefault(idDoador, new ArrayList<>());
		for (Item item : itens) {
			if (item.getNomeProduto().equals(nomeProduto)) {
				item.setQuantidade(novaQuantidade);
				break;
			}
		}
		itensDoador.put(idDoador, itens);
	}

	public int gerarIdDoador() {
		return ++idDoador;
	}

	public int gerarIdRecebedor() {
		return ++idRecebedor;
	}
	
	 public ArrayList<Item> getItensNoCarrinho(int idRecebedor) {
	        return carrinhoRecebedor.getOrDefault(idRecebedor, new ArrayList<>());
	    }

	public ArrayList<Item> getItensDisponiveis() {
		ArrayList<Item> itensDisponiveis = new ArrayList<>();

		for (ArrayList<Item> itens : itensDoador.values()) {
			itensDisponiveis.addAll(itens);
		}
		return itensDisponiveis;
	}

	public ArrayList<Item> getItensPorDoador(int idDoador) {
		return itensDoador.getOrDefault(idDoador, new ArrayList<>());
	}

	public ArrayList<Usuario> getListaDoadores() {
		return listaDoadores;
	}

	public ArrayList<Usuario> getListaRecebedores() {
		return listaRecebedor;
	}

}

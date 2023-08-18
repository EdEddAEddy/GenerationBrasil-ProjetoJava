package saviourFood;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import saviourFood.controller.Controller;
import saviourFood.usuario.Doador;
import saviourFood.usuario.Item;
import saviourFood.usuario.Recebedor;
import saviourFood.usuario.Usuario;
import saviourFood.util.Cores;

public class MenuLogin {

	public static void main(String[] args) {

		Controller usuarios = new Controller();
		Scanner sc = new Scanner(System.in);
		String menuAtivo = "principal";

		while (true) {
			if (menuAtivo.equals("principal")) {
				menuAtivo = menuPrincipal(sc, usuarios);
			} else if (menuAtivo.equals("doador")) {
				menuAtivo = menuDoador(sc, usuarios);
			} else if (menuAtivo.equals("recebedor")) {
				menuAtivo = menuRecebedor(sc, usuarios);
			}
		}
	}

	private static int IdDoadorAutenticado = -1;

	private static int IdRecebedorAutenticado = -1;

	public static String menuPrincipal(Scanner sc, Controller usuarios) {

		String nome, email, usuario, senha, cpf, telefone, usuarioLogin, senhaLogin;

		int opcao;

		System.out.println(
				Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "**************************************************");
		System.out.println("                                                  ");
		System.out.println("          Bem vindo - Sav(i)our Food              ");
		System.out.println("          Sua ajuda pode mudar vidas              ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("                                                  ");
		System.out.println("          1 - Login doador                        ");
		System.out.println("          2 - Login recebedor                     ");
		System.out.println("          3 - Cadastrar doador                    ");
		System.out.println("          4 - Cadastrar usuario                   ");
		System.out.println("          0 - Sair                                ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("          Entre com a opção desejada:             ");
		System.out.println("                                                  " + Cores.TEXT_RESET);

		try {
			opcao = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores interios!");
			sc.nextLine();
			opcao = 0;
		}

		if (opcao == 0) {
			System.out.println(Cores.TEXT_WHITE_BOLD + "\nComidas que salvam. Comidas saborosas!");
			sc.close();
			System.exit(0);
		}

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "LOGIN DOADOR");

			System.out.println("Digite o seu usuario: ");
			sc.skip("\\R?");
			usuarioLogin = sc.nextLine();
			System.out.println("Digite sua senha: ");
			senhaLogin = sc.nextLine();

			Doador doadorEncontrado = null;

			for (Usuario doador : usuarios.getListaDoadores()) {
				if (doador instanceof Doador && doador.getUsuario().equals(usuarioLogin)
						&& doador.getSenha().equals(senhaLogin)) {
					doadorEncontrado = (Doador) doador;
					System.out.println(Cores.TEXT_GREEN_BOLD + "Login realizado com sucesso");
					break;
				}
			}

			if (doadorEncontrado != null) {
				IdDoadorAutenticado = doadorEncontrado.getIdDoador();
				return "doador";
			}

			keyPress();

		case 2:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "LOGIN RECEBEDOR");

			System.out.println("Digite o seu usuario: ");
			sc.skip("\\R?");
			usuarioLogin = sc.nextLine();
			System.out.println("Digite sua senha: ");
			senhaLogin = sc.nextLine();

			Recebedor recebedorEncontrado = null;

			for (Usuario recebedor : usuarios.getListaRecebedores()) {
				if (recebedor instanceof Recebedor && recebedor.getUsuario().equals(usuarioLogin)
						&& recebedor.getSenha().equals(senhaLogin)) {
					recebedorEncontrado = (Recebedor) recebedor;
					System.out.println(Cores.TEXT_GREEN_BOLD + "Login realizado com sucesso");
					break;
				}
			}

			if (recebedorEncontrado != null) {
				IdRecebedorAutenticado = recebedorEncontrado.getIdRecebedor();
				return "recebedor";
			} else {
				System.out.println(Cores.TEXT_RED_BOLD + "Usuário ou senha incorretos");
			}

			keyPress();
			break;
		case 3:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "CADASTRO DOADOR");

			System.out.println("Digite seu Nome: ");
			sc.skip("\\R?");
			nome = sc.nextLine();
			System.out.println("Digite seu Email: ");
			email = sc.nextLine();
			System.out.println("Digite seu Usuario: ");
			usuario = sc.nextLine();
			System.out.println("Digite sua Senha: ");
			senha = sc.nextLine();
			System.out.println("Digite seu CPF: ");
			cpf = sc.nextLine();
			System.out.println("Digite seu telefone: ");
			telefone = sc.nextLine();

			usuarios.cadastrarDoador(new Doador(nome, email, usuario, senha, cpf, telefone, usuarios.gerarIdDoador()));

			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "CADASTRO USUARIO");

			System.out.println("Digite seu Nome: ");
			sc.skip("\\R?");
			nome = sc.nextLine();
			System.out.println("Digite seu Email: ");
			email = sc.nextLine();
			System.out.println("Digite seu Usuario: ");
			usuario = sc.nextLine();
			System.out.println("Digite sua Senha: ");
			senha = sc.nextLine();
			System.out.println("Digite seu CPF: ");
			cpf = sc.nextLine();
			System.out.println("Digite seu telefone: ");
			telefone = sc.nextLine();

			usuarios.cadastrarRecebedor(
					new Recebedor(nome, email, usuario, senha, cpf, telefone, usuarios.gerarIdRecebedor()));

			keyPress();

			break;
		default:
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOPÇÃO INVÁLIDA!\n");
			break;
		}
		return "principal";

	}

	private static String menuDoador(Scanner sc, Controller usuarios) {

		int opcao;

		System.out.println(
				Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "**************************************************");
		System.out.println("                                                  ");
		System.out.println("          Doador - Sav(i)our Food                 ");
		System.out.println("          Sua ajuda pode mudar vidas              ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("                                                  ");
		System.out.println("          1 - Ver itens adicionado                ");
		System.out.println("          2 - Adicionar item                      ");
		System.out.println("          3 - Remover item                        ");
		System.out.println("          4 - Atualizar item                      ");
		System.out.println("          0 - Voltar                              ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("          Entre com a opção desejada:             ");
		System.out.println("                                                  " + Cores.TEXT_RESET);

		try {
			opcao = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores interios!");
			sc.nextLine();
			opcao = 0;
		}

		if (opcao == 0) {
			return "principal";
		}

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "ITENS ADICIONADO POR VOCÊ");

			if (IdDoadorAutenticado != -1) {
				ArrayList<Item> itensAdicionados = usuarios.getItensPorDoador(IdDoadorAutenticado);
				if (itensAdicionados.isEmpty()) {
					System.out.println("Você ainda não adicionou nenhum item");
				} else {
					for (Item item : itensAdicionados) {
						System.out
								.println("Produto: " + item.getNomeProduto() + ", Quantidade: " + item.getQuantidade());
					}
				}
			}

			keyPress();
			break;
		case 2:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "ADICIONAR ITEM");

			if (IdDoadorAutenticado != -1) {
				System.out.println("Digite o nome do produto: ");
				sc.skip("\\R?");
				String nomeProduto = sc.nextLine();
				System.out.println("Digite a quantidade: ");
				int quantidade = sc.nextInt();

				usuarios.adicionarItem(IdDoadorAutenticado, nomeProduto, quantidade);

				System.out.println(Cores.TEXT_GREEN_BOLD + "Produto adicionado com sucesso");

			} else {
				System.out.println("Precisa fazer login como doador primeiro.");
			}

			keyPress();
			break;

		case 3:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "REMOVER ITEM");

			if (IdDoadorAutenticado != -1) {
				ArrayList<Item> itensAdicionados = usuarios.getItensPorDoador(IdDoadorAutenticado);

				if (!itensAdicionados.isEmpty()) {
					System.out.println("Selecione o item que deseja remover: ");

					for (int i = 0; i < itensAdicionados.size(); i++) {
						Item item = itensAdicionados.get(i);
						System.out.println(i + 1 + ". " + item.getNomeProduto());
					}

					int indiceItemParaRemover = sc.nextInt();
					if (indiceItemParaRemover >= 1 && indiceItemParaRemover <= itensAdicionados.size()) {
						Item itemRemovido = itensAdicionados.remove(indiceItemParaRemover - 1);
						System.out.println(
								Cores.TEXT_GREEN_BOLD + "Item removido com sucesso: " + itemRemovido.getNomeProduto());
					} else {
						System.out.println("Indice invalido");
					}
				} else {
					System.out.println(Cores.TEXT_YELLOW_BOLD + "Nenhum item adicionado pelo doador");
				}

			} else {
				System.out.println("Precisa fazer login como doador primeiro.");
			}

			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "ATUALIZAR ITEM");

			if (IdDoadorAutenticado != -1) {
				ArrayList<Item> itensAdicionados = usuarios.getItensPorDoador(IdDoadorAutenticado);

				if (!itensAdicionados.isEmpty()) {
					System.out.println("Selecione o item que deseja atualizar: ");

					for (int i = 0; i < itensAdicionados.size(); i++) {
						Item item = itensAdicionados.get(i);
						System.out.println(
								i + 1 + ". " + item.getNomeProduto() + ", Quantidade: " + item.getQuantidade());
					}

					int indiceItemParaAtualizar = sc.nextInt();
					if (indiceItemParaAtualizar >= 1 && indiceItemParaAtualizar <= itensAdicionados.size()) {
						Item item = itensAdicionados.get(indiceItemParaAtualizar - 1);
						System.out.println("Digite a nova quantidade: ");
						int novaQuantidade = sc.nextInt();
						usuarios.atualizarQuantidadeItem(IdDoadorAutenticado, item.getNomeProduto(), novaQuantidade);

						System.out.println(Cores.TEXT_GREEN_BOLD + "Quantidade do item atualizada com sucesso");

					} else {
						System.out.println("Indice invalido");

					}
				} else {
					System.out.println(Cores.TEXT_YELLOW_BOLD + "Nenhum item adicionado pelo doador");
				}

			} else {
				System.out.println("Precisa fazer login como doador primeiro.");
			}
		}

		keyPress();
		return "doador";
	}

	private static String menuRecebedor(Scanner sc, Controller usuarios) {

		int opcao;

		System.out.println(
				Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "**************************************************");
		System.out.println("                                                  ");
		System.out.println("          Recebedor - Sav(i)our Food              ");
		System.out.println("          Sua ajuda pode mudar vidas              ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("                                                  ");
		System.out.println("          1 - Ver itens disponiveis               ");
		System.out.println("          2 - Adicionar ao carinho                ");
		System.out.println("          3 - Remover do carrinho                 ");
		System.out.println("          4 - Visualizar carrinho                 ");
		System.out.println("          0 - Voltar                              ");
		System.out.println("                                                  ");
		System.out.println("**************************************************");
		System.out.println("          Entre com a opção desejada:             ");
		System.out.println("                                                  " + Cores.TEXT_RESET);

		try {
			opcao = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores interios!");
			sc.nextLine();
			opcao = 0;
		}

		if (opcao == 0) {
			return "principal";
		}

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "ITENS DISPONÍVEIS");

			ArrayList<Item> itensDisponiveis = usuarios.getItensDisponiveis();

			if (itensDisponiveis.isEmpty()) {
				System.out.println("Nenhum item disponível no momento.");
			} else {
				for (Item item : itensDisponiveis) {
					System.out.println("Produto: " + item.getNomeProduto() + ", Quantidade: " + item.getQuantidade());
				}
			}

			keyPress();
			break;
		case 2:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "ADICIONAR AO CARRINHO");

			if (IdRecebedorAutenticado != -1) {
				System.out.println("Digite o nome do produto que deseja adicionar ao carrinho: ");
				sc.skip("\\R?");
				String nomeProduto = sc.nextLine();
				System.out.println("Digite a quantidade: ");
				int quantidade = sc.nextInt();

				Item itemSelecionado = null;
				ArrayList<Item> itensDisponiveis1 = usuarios.getItensDisponiveis();

				for (Item item : itensDisponiveis1) {
					if (item.getNomeProduto().equals(nomeProduto) && item.getQuantidade() >= quantidade) {
						itemSelecionado = item;
						break;
					}
				}

				if (itemSelecionado != null) {
					usuarios.adicionarAoCarrinho(IdRecebedorAutenticado, itemSelecionado);
					usuarios.removerDoEstoque(itemSelecionado, quantidade);
					System.out.println(Cores.TEXT_GREEN_BOLD + "Item adicionado ao carrinho com sucesso");
				} else {
					System.out.println(Cores.TEXT_RED_BOLD + "Item não disponível ou quantidade insuficiente.");
				}
			} else {
				System.out.println("Precisa fazer login como recebedor primeiro.");
			}

			keyPress();
			break;
		case 3:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "REMOVER DO CARRINHO");

			if (IdRecebedorAutenticado != -1) {
				ArrayList<Item> carrinho = usuarios.getItensNoCarrinho(IdRecebedorAutenticado);

				if (!carrinho.isEmpty()) {
					System.out.println("Itens no Carrinho:");

					for (int i = 0; i < carrinho.size(); i++) {
						Item item = carrinho.get(i);
						System.out.println(i + 1 + ". Produto: " + item.getNomeProduto() + ", Quantidade: "
								+ item.getQuantidade());
					}

					System.out.println("Digite o número do item que deseja remover:");
					int indiceItemParaRemover = sc.nextInt();

					usuarios.removerDoCarrinho(IdRecebedorAutenticado, indiceItemParaRemover - 1);
				} else {
					System.out.println(Cores.TEXT_YELLOW_BOLD + "Carrinho vazio.");
				}
			} else {
				System.out.println("Precisa fazer login como recebedor primeiro.");
			}
			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "VISUALIZAR CARRINHO");

			ArrayList<Item> carrinho = usuarios.getItensNoCarrinho(IdRecebedorAutenticado);

			if (carrinho.isEmpty()) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "Carrinho vazio.");
			} else {
				System.out.println("Itens no Carrinho:");
				for (int i = 0; i < carrinho.size(); i++) {
					Item item = carrinho.get(i);
					System.out.println(
							i + 1 + ". Produto: " + item.getNomeProduto() + ", Quantidade: " + item.getQuantidade());
				}
			}
			keyPress();
			break;
		default:
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOPÇÃO INVÁLIDA!\n");
			break;
		}
		return "recebedor";
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}

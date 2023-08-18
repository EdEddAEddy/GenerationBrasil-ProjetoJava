package saviourFood;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import saviourFood.controller.Controller;
import saviourFood.usuario.Doador;
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

	public static String menuPrincipal(Scanner sc, Controller usuarios) {

		String nome, email, usuario, senha, cpf, telefone, usuarioLogin, senhaLogin;

		boolean doadorEncontrado = false, recebedorEncontrado = false;

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

			for (Usuario doador : usuarios.getListaDoadores()) {
				if (doador instanceof Doador && doador.getUsuario().equals(usuarioLogin)
						&& doador.getSenha().equals(senhaLogin)) {
					doadorEncontrado = true;
					System.out.println(Cores.TEXT_GREEN_BOLD + "Login realizado com sucesso");

					return "doador";

				}

			}

			if (!doadorEncontrado) {
				System.out.println(Cores.TEXT_RED_BOLD + "Usuario ou senha incorreto");
			}

			keyPress();

			break;
		case 2:
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "LOGIN USUARIO");

			System.out.println("Digite o seu usuario: ");
			sc.skip("\\R?");
			usuarioLogin = sc.nextLine();
			System.out.println("Digite sua senha: ");
			senhaLogin = sc.nextLine();

			for (Usuario recebedor : usuarios.getListaRecebedores()) {
				if (recebedor instanceof Recebedor && recebedor.getUsuario().equals(usuarioLogin)
						&& recebedor.getSenha().equals(senhaLogin)) {
					recebedorEncontrado = true;
					System.out.println(Cores.TEXT_GREEN_BOLD + "Login realizado com sucesso");

					return "recebedor";
				}
			}

			if (!recebedorEncontrado) {
				System.out.println(Cores.TEXT_RED_BOLD + "Usuario ou senha incorreto");
			}
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

		keyPress();

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

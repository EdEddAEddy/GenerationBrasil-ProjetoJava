package saviourFood.controller;


import java.util.ArrayList;

import saviourFood.repository.Repository;
import saviourFood.usuario.Doador;
import saviourFood.usuario.Recebedor;
import saviourFood.usuario.Usuario;

public class Controller implements Repository {

	private ArrayList<Usuario> listaDoadores = new ArrayList<Usuario>();
	private ArrayList<Usuario> listaRecebedor = new ArrayList<Usuario>();

	int idDoador = 0, idRecebedor = 0;

	@Override
	public void listarItens() {

	}

	@Override
	public void cadastrarDoador(Doador doador) {
		listaDoadores.add(doador);
		System.out.println("\nO Doador número: " + doador.getIdDoador() + " foi criada com sucesso" );
		
	}
	
	@Override
	public void cadastrarRecebedor(Recebedor recebedor) {
		listaRecebedor.add(recebedor);
		System.out.println("\nO Recebedor número: " + recebedor.getIdRecebedor() + " foi criada com sucesso" );
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarIdDoador() {
		return ++ idDoador;
	}
	
	public int gerarIdRecebedor() {
		return ++ idRecebedor;
	}
	
    public ArrayList<Usuario> getListaDoadores() {
        return listaDoadores;
    }
    
    public ArrayList<Usuario> getListaRecebedores() {
        return listaRecebedor;
    }

}


package aplicacaobrasileirabibliotecaacademica;

import java.util.ArrayList;


public class Cliente implements Operador {
	private int id;
	private String nome;
	private boolean estaAtivo;
	private ArrayList<Emprestimo> historicoEmprestimos;

	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.estaAtivo = true;
	}
	

	
	
	

	@Override
	public void criar() {
		
		
		
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void editar() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void excluir() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
}

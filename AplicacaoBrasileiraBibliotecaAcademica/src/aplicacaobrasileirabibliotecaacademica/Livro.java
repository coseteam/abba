/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacaobrasileirabibliotecaacademica;

import java.util.ArrayList;


public class Livro implements Operador {
	private String titulo;
	private String genero;
	private String editora;
	private String isbn;
	private int qtdPaginas;
	private boolean estaDisponivel;
	private ArrayList<Cliente> historicoClientes;

	public Livro(String titulo, String genero, String editora, String isbn, int qtdPaginas) {
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.isbn = isbn;
		this.qtdPaginas = qtdPaginas;
		this.estaDisponivel = false;
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

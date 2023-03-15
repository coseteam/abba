/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacaobrasileirabibliotecaacademica;

/**
 *
 * @author abner
 */
public class Funcionario implements Operador {
	private int id;
	private String nome;
	private int nivel;
	private String cargo;
	private boolean estaAtivo;

	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.nivel = 9;
		this.estaAtivo = false;
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

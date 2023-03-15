/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacaobrasileirabibliotecaacademica;

import java.util.Date;

/**
 *
 * @author abner
 */
public class Emprestimo implements Operador {
	private int codigo;
	private Cliente clienteSolicitante;
	private Livro livroSolicitado;
	private Date dataRetirada;
	private Date dataDevolucao;
	private boolean estaCorrente;

	public Emprestimo(int codigo, Cliente clienteSolicitante, Livro livroSolicitado, Date dataRetirada) {
		this.codigo = codigo;
		this.clienteSolicitante = clienteSolicitante;
		this.livroSolicitado = livroSolicitado;
		this.dataRetirada = dataRetirada;
		this.estaCorrente = true;
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

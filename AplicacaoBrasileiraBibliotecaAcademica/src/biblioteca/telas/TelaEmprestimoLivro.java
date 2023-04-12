package biblioteca.telas;

import biblioteca.validations.Validador;

import javax.swing.*;



public class TelaEmprestimoLivro{
	public String data;
	public String dataDevolucao;
	public String aluno;
	public String livro;


	public TelaEmprestimoLivro() {
		registrarNovoEmprestimo();
	}


	private void registrarNovoEmprestimo() {
		Validador validador = new Validador();


		this.data = JOptionPane.showInputDialog("Digite a data de hoje ", "DD/MM/YYYY");
		this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução ", "DD/MM/YYYY");

		do {
			this.livro = JOptionPane.showInputDialog("ISBN do livro: ");
		} while (!validador.validarInputISBN(this.livro));

			this.aluno = JOptionPane.showInputDialog("CPF do aluno:");
		}


	}

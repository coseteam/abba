package biblioteca.telas;

import biblioteca.validations.ValidaData;
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
		ValidaData validata = new ValidaData();


		do {
			this.data = JOptionPane.showInputDialog("Digite a data de hoje ", "DD/MM/YYYY");
		} while (!validata.validarInputFormatoDatas(this.data));


		do {
			this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução ", "DD/MM/YYYY");
		} while (!validata.validarInputFormatoDatas(this.dataDevolucao));


		do {
			this.livro = JOptionPane.showInputDialog("ISBN do livro: ");
		} while (!validador.validarInputISBN(this.livro));


		do {
			this.aluno = JOptionPane.showInputDialog("CPF do aluno:");
		} while (!validador.validarInputCPF(this.aluno));

	}


}

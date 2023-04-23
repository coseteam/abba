package biblioteca.telas;

import biblioteca.validations.ValidaData;
import biblioteca.validations.Validador;

import javax.swing.*;



public class TelaEmprestimoLivro{
	public String data;
	public String dataDevolucao;
	public String aluno;
	public String livro;

	private MenuEmprestimos menuEmprestimos = new MenuEmprestimos();


	public TelaEmprestimoLivro() {
		registrarNovoEmprestimo();
	}


	private void registrarNovoEmprestimo() {
		Validador validador = new Validador();
		ValidaData validata = new ValidaData();


		do {
			this.data = JOptionPane.showInputDialog("Digite a data de hoje ", "DD/MM/YYYY");
			if (this.data == null) {
				menuEmprestimos.menuEmprestimos();
			}
		} while (!validata.validarInputFormatoDatas(this.data));


		do {
			this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução ", "DD/MM/YYYY");
			if (this.dataDevolucao == null) {
				menuEmprestimos.menuEmprestimos();
			}
		} while (!validata.validarInputFormatoDatas(this.dataDevolucao));


		do {
			this.livro = JOptionPane.showInputDialog("ISBN do livro: ");
			if (this.livro == null) {
				menuEmprestimos.menuEmprestimos();
			}
		} while (!validador.validarInputISBN(this.livro));


		do {
			this.aluno = JOptionPane.showInputDialog("CPF do aluno:");
			if (this.aluno == null) {
				menuEmprestimos.menuEmprestimos();
			}
		} while (!validador.validarInputCPF(this.aluno));

	}


}

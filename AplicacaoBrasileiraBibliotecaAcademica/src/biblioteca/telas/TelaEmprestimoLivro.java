package biblioteca.telas;

import biblioteca.validations.Validador;

import javax.swing.*;



public class TelaEmprestimoLivro{
	public String data;
	public String dataDevolucao;
	public String aluno;
	public String livro;

	// Renba >>>
	public Integer[] dataRetiradaDMA = new Integer[3]; // Pegando data como Lista de Inteiros
	public String[] dataDevolucaoDMA = new String[3]; // PAUSEPLAY 13/04


	public TelaEmprestimoLivro() {
		registrarNovoEmprestimo();
	}


	private void registrarNovoEmprestimo() {
		Validador validador = new Validador();

		// RENBA : PAUSEPLAY 13/04/2023
		SpinnerModel spinnerDia = new SpinnerNumberModel(1, 1, 31, 1); // Parâmetros para DIA
		JSpinner dataDia = new JSpinner(spinnerDia);
		SpinnerModel spinnerMes = new SpinnerNumberModel(1, 1, 12, 1); // Parâmetros para o MES
		JSpinner dataMes = new JSpinner(spinnerMes);
		SpinnerModel spinnerAno = new SpinnerNumberModel(2023, 2022, 2024, 1); // Parâmetros para o ANO
		JSpinner dataAno = new JSpinner(spinnerAno);



		JPanel panelDMA = new JPanel();
		panelDMA.add(new JLabel("Data de Retirada ::: "));
		panelDMA.add(new JLabel("Dia:"));
		panelDMA.add(dataDia);
		panelDMA.add(new JLabel("Mês:"));
		panelDMA.add(dataMes);
		panelDMA.add(new JLabel("Ano: "));
		panelDMA.add(dataAno);

		int result = JOptionPane.showConfirmDialog(null, panelDMA, "Novo Empréstimo", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			this.dataRetiradaDMA[0] = (Integer) dataDia.getValue();
			System.out.println(dataRetiradaDMA[0]);
			this.dataRetiradaDMA[1] = (Integer) dataMes.getValue();
			System.out.println(dataRetiradaDMA[1]);
			this.dataRetiradaDMA[2] = (Integer) dataAno.getValue();
			System.out.println(dataRetiradaDMA[2]);
		}

		// =============

		this.data = JOptionPane.showInputDialog("Digite a data de hoje ", "DD/MM/YYYY");
		this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução ", "DD/MM/YYYY");

		do {
			this.livro = JOptionPane.showInputDialog("ISBN do livro: ");
		} while (!validador.validarInputISBN(this.livro));

		do {
			this.aluno = JOptionPane.showInputDialog("CPF do aluno:");
		} while (validador.validarInputCPF(this.aluno));

	}


}

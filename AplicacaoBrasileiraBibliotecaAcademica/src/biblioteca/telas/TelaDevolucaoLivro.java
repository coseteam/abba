package biblioteca.telas;

import biblioteca.model.Emprestimo;
import biblioteca.services.EmprestimoService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class TelaDevolucaoLivro {
//    public Emprestimo currentEmprestimo;
//    public String aluno;
//    public String livro;
    public int codigo;

//    public Aluno aluno;
//    public Livro livro;
//    public int codigo;

//    public TelaDevolucaoLivro() {
//        this.livro = JOptionPane.showInputDialog("Digite o codigo do livro: ");
//        this.aluno = JOptionPane.showInputDialog("Digite o CPF do aluno:");
//        this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do emprestimo:"));
//    }

    public TelaDevolucaoLivro() {
        Validador validador = new Validador();
        EmprestimoService emprestimoService = new EmprestimoService();

        do {
            try {
                this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Empréstimo "));
            } catch (Exception err) {
                this.codigo = 0;
            }
        } while (!validador.validarInputInteger(this.codigo));


        System.out.println("+++ Tela Devolucao 39 +++");
//        int codEmp = this.codigo;
//        currentEmprestimo = emprestimoService.buscarEmprestimo(codEmp);
//
//        return currentEmprestimo;

//        System.out.println(currentEmprestimo.getLivro());
//        System.out.println(currentEmprestimo.getAluno());
//        this.livro = currentEmprestimo.getLivro().getISBN();
//        this.aluno = currentEmprestimo.getAluno().getCpf();

    }

}

package biblioteca.telas;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.services.EmprestimoService;
import biblioteca.validations.Validador;
import com.sun.security.jgss.GSSUtil;

import javax.swing.*;

public class TelaDevolucaoLivro {
    public String aluno;
    public String livro;
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
        int codEmp = this.codigo;
        Emprestimo currentEmprestimo = emprestimoService.buscarEmprestimo(codEmp);
        System.out.println(currentEmprestimo.getLivro());
        System.out.println(currentEmprestimo.getAluno());
//        this.livro = currentEmprestimo.getLivro().getISBN();
//        this.aluno = currentEmprestimo.getAluno().getCpf();

    }

}

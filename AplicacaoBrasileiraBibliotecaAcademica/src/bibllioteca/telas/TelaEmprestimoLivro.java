package bibllioteca.telas;

import javax.swing.*;

public class TelaEmprestimoLivro {
    public String data;
    public String dataDevolucao;
    public String aluno;
    public String livro;


    public TelaEmprestimoLivro() {
        this.data = JOptionPane.showInputDialog("Digite a data de hoje: DD/MM/YYYY");
        this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução: DD/MM/YYYY");
        this.livro = JOptionPane.showInputDialog("Digite o titulo do livro: ");
        this.aluno = JOptionPane.showInputDialog("Digite o CPF do aluno:");
    }

}

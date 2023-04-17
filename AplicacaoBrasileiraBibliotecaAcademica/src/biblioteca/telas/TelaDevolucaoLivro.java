package biblioteca.telas;

import javax.swing.*;

public class TelaDevolucaoLivro {
    public String aluno;
    public String livro;
    public int codigo;

    public TelaDevolucaoLivro() {
        this.livro = JOptionPane.showInputDialog("Digite o codigo do livro: ");
        this.aluno = JOptionPane.showInputDialog("Digite o CPF do aluno:");
        this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do emprestimo:"));
    }

}

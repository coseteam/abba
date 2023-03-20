package biblioteca.telas;

import javax.swing.*;

public class TelaDevolucaoLivro {
    public int aluno;
    public int livro;
    public int codigo;

    public TelaDevolucaoLivro() {
        this.livro = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro: "));
        this.aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:"));
        this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do emprestimo:"));
    }

}

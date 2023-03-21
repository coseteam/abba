package biblioteca.telas;

import javax.swing.*;

public class TelaEmprestimoLivro{
    public String data;
    public String dataDevolucao;
    public int aluno;
    public int livro;


    public TelaEmprestimoLivro() {
        this.data = JOptionPane.showInputDialog("Digite a data de hoje: DD/MM/YYYY");
        this.dataDevolucao = JOptionPane.showInputDialog("Digite a data da devolução: DD/MM/YYYY");
        this.livro = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro: "));
        this.aluno = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:"));
    }

}

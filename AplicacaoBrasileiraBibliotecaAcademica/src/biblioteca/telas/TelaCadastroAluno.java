package biblioteca.telas;

import javax.swing.*;

public class TelaCadastroAluno {
    public String nome;
    public String cpf;
    public String matricula;


    public TelaCadastroAluno() {
        this.nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
        this.cpf = JOptionPane.showInputDialog("Digite o cpf do aluno:");
        this.matricula = JOptionPane.showInputDialog("Digite a matricula do aluno:");
    }

}

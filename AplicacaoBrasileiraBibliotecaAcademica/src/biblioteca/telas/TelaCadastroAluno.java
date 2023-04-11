package biblioteca.telas;

import biblioteca.validations.Validador;
import javax.swing.*;

public class TelaCadastroAluno {
    public String nome;
    public String cpf;
    public String matricula;


    public TelaCadastroAluno() {
        Validador validador = new Validador();

        do {
            this.nome = JOptionPane.showInputDialog("Informe o nome completo do aluno");
        } while(!validador.validarInputString(this.nome));


        do {
            this.cpf = JOptionPane.showInputDialog("Digite o CPF\nApenas Números. 11 dígitos.");
        } while (!validador.validarInputCPF(this.cpf));


        do {
            this.matricula = JOptionPane.showInputDialog("Matrícula do aluno\nApenas números.");
        } while (!validador.validarInputStringNumerica(this.matricula));
    }

}

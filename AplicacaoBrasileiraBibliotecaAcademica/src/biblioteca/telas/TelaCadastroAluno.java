package biblioteca.telas;

import biblioteca.validations.Validador;
import javax.swing.*;

public class TelaCadastroAluno {
    public String nome;
    public String cpf;
    public String matricula;

    private MenuAluno menuAluno = new MenuAluno();


    public TelaCadastroAluno() {
        Validador validador = new Validador();

        do {
            this.nome = JOptionPane.showInputDialog("Informe o nome completo do aluno");
            if (this.nome == null) {
                menuAluno.menuAluno();
            }
        } while(!validador.validarInputString(this.nome));


        do {
            this.cpf = JOptionPane.showInputDialog("Digite o CPF\nApenas Números. 11 dígitos.");
            if (this.cpf == null) {
                menuAluno.menuAluno();
            }
        } while (!validador.validarNovoCPF(this.cpf));


        do {
            this.matricula = JOptionPane.showInputDialog("Matrícula do aluno\nApenas números.");
            if (this.matricula == null) {
                menuAluno.menuAluno();
            }
        } while (!validador.validarInputStringNumerica(this.matricula));
    }

}

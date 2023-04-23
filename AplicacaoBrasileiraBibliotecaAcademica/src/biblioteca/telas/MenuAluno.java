package biblioteca.telas;

import biblioteca.services.AlunoService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuAluno extends MenuPrincipal {

    private AlunoService alunoService = new AlunoService();
    private String msg = "Escolha uma opção:\n \n 1 - Cadastrar Novo Aluno\n 2 - Excluir um Aluno\n" +
            " 3 - Editar Cadastro de Aluno\n 4 - Ver todos os Alunos\n 5 - Excluir todos os Alunos do Cadastro\n " +
            "\n 0 - Voltar ao menu principal";



    public void menuAluno() {
        Validador validador = new Validador();
        Integer input;

        do {
            String inputString = JOptionPane.showInputDialog(null, msg, "Diretório de Usuários", 3);
                if(inputString == null) { // Handle cancel button
                    menuPrincipal();
                    return;
                }
            try {
                input = Integer.parseInt(inputString);
            } catch (Exception e) {
                input = 9;
            }

        } while (!validador.validarInputMenu(input));


        int caminho = input;
        switch (caminho) {
            case 1 -> {
                TelaCadastroAluno ca = new TelaCadastroAluno();
                alunoService.cadastrarAluno(ca.nome, ca.cpf, ca.matricula);
                menuAluno();
            }
            case 2 -> {
                String cpf;
                do {
                    cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
                    if (cpf == null) {
                        menuAluno();
                    }
                } while (!validador.validarInputCPF(cpf));
                alunoService.removerAluno(cpf);
                menuAluno();
            }
            case 3 -> {
                String cpf;
                do {
                    cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
                    if (cpf == null) {
                        menuAluno();
                    }
                } while (!validador.validarInputCPF(cpf));
                alunoService.atualizarAluno(cpf);
                menuAluno();
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, alunoService.listarAlunos());
                menuAluno();
            }
            case 5 -> {
                alunoService.apagarListaAlunos();
                menuAluno();
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                menuAluno();
            }
        }

    }
}
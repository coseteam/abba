package biblioteca.telas;

import biblioteca.services.AlunoService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuCadastro extends MenuPrincipal {

    private AlunoService alunoService = new AlunoService();
    private String msg = "Menu Biblioteca\n Escolha uma opção: \n 1 - Cadastrar Novo Aluno\n 2 - Excluir um Aluno\n" +
            " 3 - Editar Cadastro de Aluno\n 4 - Ver todos os Alunos\n 5 - Excluir todos os Alunos do Cadastro\n " +
            "0 - Voltar ao menu principal";



    public void menuCadastro() {
        Validador validador = new Validador();
        Integer input;

        do {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                input = 9;
            }


        } while (!validador.validarInputMenu(input));


        int caminho = input;

        switch (caminho) {
            case 1 -> {
                TelaCadastroAluno ca = new TelaCadastroAluno();
                alunoService.cadastrarAluno(ca.nome, ca.cpf, ca.matricula);
                menuCadastro();
            }
            case 2 -> {
                //Validador validador = new Validador();
                String cpf;
                do {
                    cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
                } while (!validador.validarInputCPF(cpf));
                alunoService.removerAluno(cpf);
                menuCadastro();
            }
            case 3 -> {
                //Validador validador = new Validador();
                String cpf;
                do {
                    cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
                } while (!validador.validarInputCPF(cpf));
                alunoService.atualizarAluno(cpf);
                menuCadastro();
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, alunoService.listarAlunos());
                menuCadastro();
            }
            case 5 -> {
                alunoService.apagarListaAlunos();
                menuCadastro();
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                menuCadastro();
            }
        }

    }
}
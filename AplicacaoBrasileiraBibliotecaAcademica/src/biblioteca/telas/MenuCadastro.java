package biblioteca.telas;

import biblioteca.services.AlunoService;

import javax.swing.*;

public class MenuCadastro extends MenuPrincipal {

    private AlunoService alunoService = new AlunoService();

    private String msg = "Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Cadastrar um aluno\n 2 - Remover um aluno\n" +
            " 3 - Atualizar um cadastro de aluno\n 4 -Listar todos os alunos\n 5 - Apagar todos os alunos da lista\n " +
            "6 - Voltar ao menu principal";


    public void menuCadastro() {

        String input = JOptionPane.showInputDialog(msg);
        validaMenu(input);

        int caminho = Integer.parseInt(input);

        switch (caminho) {
            case 1 -> {
                TelaCadastroAluno ca = new TelaCadastroAluno();
                alunoService.cadastrarAluno(ca.nome, ca.cpf, ca.matricula);
                menuCadastro();
            }
            case 2 -> {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno"));
                alunoService.removerAluno(id);
                menuCadastro();
            }
            case 3 -> {
                alunoService.atualizarAluno(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:")));
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
            case 6 -> menuPrincipal();
            default -> {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                menuCadastro();
            }
        }

    }
}
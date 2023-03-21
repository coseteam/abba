package biblioteca.telas;

import biblioteca.services.AlunoService;

import javax.swing.*;

public class MenuCadastro extends MenuPrincipal {

    private AlunoService alunoService = new AlunoService();

    private String msg = "Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Cadastrar um aluno\n 2 - Remover um aluno\n" +
            " 3 - Atualizar um cadastro de aluno\n 4 -Listar todos os alunos\n 5 - Apagar todos os alunos da lista\n " +
            "6 - Voltar ao menu principal";


    public void menuCadastro() {


        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (caminho){
            case 1:
                TelaCadastroAluno ca = new TelaCadastroAluno();
                alunoService.cadastrarAluno(ca.nome, ca.cpf, ca.matricula);
                menuCadastro();
                break;
            case 2:
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno"));
                alunoService.removerAluno(id);
                menuCadastro();
                break;
            case 3:
                alunoService.atualizarAluno(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:")));
                menuCadastro();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, alunoService.listarAlunos());
                menuCadastro();
                break;
            case 5:
                alunoService.apagarListaAlunos();
                menuCadastro();
                break;
            case 6:
                menuPrincipal();
                break;
        }

    }
}
package biblioteca.telas;

import javax.swing.*;

public class MenuCadastro extends MenuPrincipal {




    private String msg = "Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Cadastrar um aluno\n 2 - Remover um aluno\n" +
            " 3 - Atualizar um cadastro de aluno\n 4 -Listar todos os alunos\n 5 - Apagar todos os alunos da lista\n " +
            "6 - Voltar ao menu principal";


    public void menuCadastro() {


        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (caminho){
            case 1:
                TelaCadastroAluno ca = new TelaCadastroAluno();
                biblioteca.cadastrarAluno(ca.nome, ca.cpf, ca.matricula);
                menuCadastro();
                break;
            case 2:
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno"));
                biblioteca.removerAluno(id);
                menuCadastro();
                break;
            case 3:
                biblioteca.atualizarAluno(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:")));
                menuCadastro();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, biblioteca.listarAlunos());
                menuCadastro();
                break;
            case 5:
                biblioteca.apagarListaAlunos();
                menuCadastro();
                break;
            case 6:
                menuPrincipal();
                break;
        }

    }
}
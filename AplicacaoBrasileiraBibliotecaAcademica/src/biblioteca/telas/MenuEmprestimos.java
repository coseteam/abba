package biblioteca.telas;

import biblioteca.model.Aluno;
import biblioteca.model.Livro;

import javax.swing.*;

public class MenuEmprestimos extends MenuPrincipal {




    private String msg = "Menu Emprestimos\n Escolha uma das opções abaixo: \n 1 - Fazer um emprestimo\n 2 - fazer devolução\n" +
            " 3 - Mostrar todos os emprestimos\n 4 - Voltar ao menu principal";


    public void menuEmprestimos() {


        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (caminho){
            case 1:
                TelaEmprestimoLivro el = new TelaEmprestimoLivro();
                Livro livroE = biblioteca.buscarLivro(el.livro);
                Aluno alunoE = biblioteca.buscarAluno(el.aluno);
                biblioteca.emprestar(el.data,el.dataDevolucao, alunoE, livroE);
                menuEmprestimos();
                break;
            case 2:
                TelaDevolucaoLivro dl = new TelaDevolucaoLivro();
                Livro livroD = biblioteca.buscarLivro(dl.livro);
                Aluno alunoD = biblioteca.buscarAluno(dl.aluno);
                biblioteca.devolver(alunoD, livroD, dl.codigo);
                menuEmprestimos();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, biblioteca.getEmprestimos());
                menuEmprestimos();
                break;
            case 4:
                menuPrincipal();
                break;
        }

    }
}
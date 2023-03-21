package biblioteca.telas;

import biblioteca.model.Aluno;
import biblioteca.model.Livro;
import biblioteca.services.AlunoService;
import biblioteca.services.EmprestimoService;
import biblioteca.services.LivroService;

import javax.swing.*;

public class MenuEmprestimos extends MenuPrincipal {

    private EmprestimoService emprestimoService = new EmprestimoService();
    private LivroService livroService = new LivroService();
    private AlunoService alunoService = new AlunoService();

    private String msg = "Menu Emprestimos\n Escolha uma das opções abaixo: \n 1 - Fazer um emprestimo\n 2 - fazer devolução\n" +
            " 3 - Mostrar todos os emprestimos\n 4 - Voltar ao menu principal";


    public void menuEmprestimos() {


        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (caminho){
            case 1:
                TelaEmprestimoLivro el = new TelaEmprestimoLivro();
                Livro livroE = livroService.buscarLivro(el.livro);
                Aluno alunoE = alunoService.buscarAluno(el.aluno);
                emprestimoService.emprestar(el.data,el.dataDevolucao, alunoE, livroE);
                menuEmprestimos();
                break;
            case 2:
                TelaDevolucaoLivro dl = new TelaDevolucaoLivro();
                Livro livroD = livroService.buscarLivro(dl.livro);
                Aluno alunoD = alunoService.buscarAluno(dl.aluno);
                emprestimoService.devolver(alunoD, livroD, dl.codigo);
                menuEmprestimos();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, emprestimoService.getEmprestimos());
                menuEmprestimos();
                break;
            case 4:
                menuPrincipal();
                break;
        }

    }
}
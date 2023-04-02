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

    private String msg = "Menu Empréstimos\n Escolha uma opção: \n 1 - Registrar Novo Empréstimo\n 2 - Registrar Devolução\n" +
            " 3 - Ver todos os Empréstimos\n 0 - Voltar ao menu principal";


    public void menuEmprestimos() {

        String input = JOptionPane.showInputDialog(msg);
        validaMenu(input);

        int caminho = Integer.parseInt(input);

        switch (caminho) {
            case 1 -> {
                TelaEmprestimoLivro el = new TelaEmprestimoLivro();
                Livro livroE = livroService.buscarLivro(el.livro);
                Aluno alunoE = alunoService.buscarAluno(el.aluno);
                emprestimoService.emprestar(el.data, el.dataDevolucao, alunoE, livroE);
                menuEmprestimos();
            }
            case 2 -> {
                TelaDevolucaoLivro dl = new TelaDevolucaoLivro();
                Livro livroD = livroService.buscarLivro(dl.livro);
                Aluno alunoD = alunoService.buscarAluno(dl.aluno);
                emprestimoService.devolver(alunoD, livroD, dl.codigo);
                menuEmprestimos();
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, emprestimoService.listarEmprestimo());
                menuEmprestimos();
            }
            case 0 -> menuPrincipal();

            default -> {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                menuEmprestimos();
            }
        }

    }
}
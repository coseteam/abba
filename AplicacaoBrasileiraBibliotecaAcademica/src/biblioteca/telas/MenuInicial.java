package biblioteca.telas;

import biblioteca.model.Aluno;
import biblioteca.model.Biblioteca;
import biblioteca.model.Livro;

import javax.swing.*;

public class MenuInicial {
    private Biblioteca biblioteca = new Biblioteca();

    private String msg = "Biblioteca Exemplo\n Escolha uma das opções abaixo: \n 1 - Adcionar Livro\n 2 - Todos os livros\n" +
            " 3 - Cadastro de Aluno \n 4 - Emprestar Livro\n 5 - Devolver Livro";

    public void TelaInicial(){
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (caminho){
            case 1:
                TelaAdicionarLivro ad = new TelaAdicionarLivro();
                biblioteca.adionarNovoLivro(ad.titulo, ad.autor, ad.idioma, ad.genero, ad.totalPaginas);
                TelaInicial();
            case 2:
                JOptionPane.showMessageDialog(null, biblioteca.listarLivros());
                TelaInicial();
            case 3:
                TelaCadastroAluno ca = new TelaCadastroAluno();
                biblioteca.cadastrarAluno(ca.nome, ca.cpf, ca.login, ca.matricula);
                TelaInicial();
            case 4:
                TelaEmprestimoLivro el = new TelaEmprestimoLivro();
                Livro livro = biblioteca.buscarLivro(el.livro);
                Aluno aluno = biblioteca.buscarAluno(el.aluno);
                biblioteca.emprestar(el.data,el.dataDevolucao, aluno, livro);
                TelaInicial();
//            case 5:
//                biblioteca.devolver();
//                TelaInicial();
        }
    }

    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
        menu.TelaInicial();
    }
}

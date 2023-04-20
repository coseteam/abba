package biblioteca.telas;

import biblioteca.services.LivroService;
import biblioteca.validations.Validador;

import javax.swing.*;


public class MenuLivro extends MenuPrincipal {

    private LivroService livroService = new LivroService();
    private String msg = "Escolha uma opção:\n \n 1 - Cadastrar Novo Livro\n 2 - Excluir um Livro\n" +
            " 3 - Atualizar um Livro\n 4 - Listar todo o Acervo\n 5 - Apagar todos os Livros do Acervo\n " +
            "\n 0 - Voltar ao menu principal";


    public void menuLivro() {
        Validador validador = new Validador();
        Integer input;

        do {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(null, msg, "Catálogo e Acervo", 3));
            } catch (Exception e) {
                input = 9;
            }

        } while (!validador.validarInputMenu(input));


        int caminho = input;
        switch (caminho) {
            case 1 -> {
                TelaAdicionarLivro ad = new TelaAdicionarLivro();
                livroService.cadastrarLivro(ad.isbn, ad.titulo, ad.autor, ad.editora, ad.genero, ad.totalPaginas);
                menuLivro();
            }
            case 2 -> {
                String isbn;
                do {
                    isbn = JOptionPane.showInputDialog("Digite o ISBN do Livro: ");
                } while (!validador.validarInputISBN(isbn));
                livroService.removerLivro(isbn);
                menuLivro();
            }
            case 3 -> {
                String isbn;
                do {
                    isbn = JOptionPane.showInputDialog("Digite o ISBN do Livro:");
                } while (!validador.validarInputISBN(isbn));
                livroService.atualizarLivro(isbn);
                menuLivro();
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, livroService.listarLivros());
                menuLivro();
            }
            case 5 -> {
                livroService.apagarListaLivros();
                livroService.apagarTodosISBN();
                menuLivro();
            }
            case 0 -> {
                menuPrincipal();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                menuLivro();
            }
        }

    }
}
package biblioteca.telas;

import biblioteca.services.LivroService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuLivro extends MenuPrincipal {

    private LivroService livroService = new LivroService();

    private String msg = "Menu Biblioteca\n Escolha uma opção: \n 1 - Cadastrar Novo Livro\n 2 - Excluir um Livro\n" +
            " 3 - Atualizar um Livro\n 4 - Listar todo o Acervo\n 5 - Apagar todos os Livros do Acervo\n " +
            "0 - Voltar ao menu principal";


    public void menuLivro() {


        String input = JOptionPane.showInputDialog(msg);
        validaMenu(input);

        int caminho = Integer.parseInt(input);
        switch (caminho) {
            case 1 -> {
                TelaAdicionarLivro ad = new TelaAdicionarLivro(); // Renba Tela Adicionar Livro
                //int codigoAtual = livroService.capturarQuantidadeLivros();
                //System.out.println(codigoAtual);
                boolean checkValidadorTituloLivro = Validador.validarInputString(ad.titulo);
                boolean checkValidadorQuantidadePaginas = Validador.validarInputInteger(ad.totalPaginas);
                boolean checkValidadorNovoISBN = Validador.validarInputISBN(ad.isbn);
                livroService.cadastrarLivro(ad.isbn, ad.titulo, ad.autor, ad.editora, ad.genero, ad.totalPaginas);
                menuLivro();
            }
            case 2 -> {
                String isbn = JOptionPane.showInputDialog("Digite o ISBN do Livro: ");
                livroService.removerLivro(isbn);
                menuLivro();
            }
            case 3 -> {
                livroService.atualizarLivro(JOptionPane.showInputDialog("Digite o ISBN do Livro:"));
                menuLivro();
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, livroService.listarLivros());
                menuLivro();
            }
            case 5 -> {
                livroService.apagarListaLivros();
                menuLivro();
            }
            case 0 -> menuPrincipal();
            default -> {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                menuLivro();
            }
        }

    }
}
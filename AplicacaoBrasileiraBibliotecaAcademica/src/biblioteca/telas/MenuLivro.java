package biblioteca.telas;

import biblioteca.services.LivroService;

import javax.swing.*;

public class MenuLivro extends MenuPrincipal {

    private LivroService livroService = new LivroService();

    private String msg = "Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Cadastrar um livros\n 2 - Remover um livro\n" +
            " 3 - Atualizar um livro\n 4 -Listar todos os livros\n 5 - Apagar todos os livros da lista\n " +
            "6 - Voltar ao menu principal";


    public void menuLivro() {


        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (caminho){
            case 1:
                TelaAdicionarLivro ad = new TelaAdicionarLivro();
                livroService.adionarNovoLivro(ad.titulo, ad.autor, ad.editora, ad.genero, ad.totalPaginas);
                menuLivro();
                break;
            case 2:
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno:"));
                livroService.removerLivro(codigo);
                menuLivro();
                break;
            case 3:
                livroService.atualizarLivro(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro:")));
                menuLivro();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, livroService.listarLivros());
                menuLivro();
                break;
            case 5:
                livroService.apagarListaLivros();
                menuLivro();
                break;
            case 6:
                menuPrincipal();
                break;
        }

    }
}

//         case 6:
//                biblioteca.devolver();
//                TelaInicial();

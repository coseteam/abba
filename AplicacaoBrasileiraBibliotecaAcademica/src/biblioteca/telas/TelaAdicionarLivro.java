package biblioteca.telas;

import biblioteca.validations.Validador;

import javax.swing.*;

public class TelaAdicionarLivro{
    public String isbn;
    public String titulo;
    public String autor;
    public String editora;
    public String genero;
    public int totalPaginas;

    public TelaAdicionarLivro() {
        cadastrarLivroUsuario();
    }

    private void cadastrarLivroUsuario() {
        Validador validador = new Validador();

        do {
            this.isbn = JOptionPane.showInputDialog(("Informe o ISBN da Obra: ")); //Renba

        } while (!validador.validarInputISBN(this.isbn));


        this.titulo = JOptionPane.showInputDialog("Título:");
        this.autor = JOptionPane.showInputDialog("Pessoa Autora:");
        this.editora = JOptionPane.showInputDialog("Editora:");
        this.genero = JOptionPane.showInputDialog("Gênero Literário:");
        String s = JOptionPane.showInputDialog("Quantidade de Páginas:");
        if (s != null) {
            this.totalPaginas = Integer.parseInt(s);
        }
    }

}

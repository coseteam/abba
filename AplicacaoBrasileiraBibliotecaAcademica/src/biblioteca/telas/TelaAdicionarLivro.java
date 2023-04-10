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
            this.isbn = JOptionPane.showInputDialog(("Digite o ISBN da Obra\nApenas números. Mínimo 6 dígitos. ")); //Renba

        } while (!validador.validarInputISBN(this.isbn));


        do {
            this.titulo = JOptionPane.showInputDialog("Informe o Título da Obra");
        } while (!validador.validarInputString(this.titulo));


        do {
            this.autor = JOptionPane.showInputDialog("Pessoa Autora:");
        } while (!validador.validarInputString(this.autor));


        do {
            this.editora = JOptionPane.showInputDialog("Editora:");
        } while (!validador.validarInputString(this.editora));


        do {
            this.genero = JOptionPane.showInputDialog("Gênero Literário:");
        } while (!validador.validarInputString(this.genero));


        do {
            try {
                this.totalPaginas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Páginas:"));
            } catch (Exception err) {
                System.out.println(err);
            }
        } while (!validador.validarInputInteger(this.totalPaginas));


    }

}

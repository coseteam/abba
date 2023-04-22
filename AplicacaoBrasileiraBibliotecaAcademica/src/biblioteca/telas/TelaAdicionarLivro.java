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

    private MenuLivro menuLivro = new MenuLivro();

    public TelaAdicionarLivro() {
        cadastrarLivroUsuario();
    }

    private void cadastrarLivroUsuario() {
        Validador validador = new Validador();

        do {
            this.isbn = JOptionPane.showInputDialog(("Digite o ISBN da Obra\nApenas números. Mínimo 9 dígitos. ")); //Renba
            if (this.isbn == null) {
                menuLivro.menuLivro();
            }
        } while (!validador.validarNovoISBN(this.isbn));


        do {
            this.titulo = JOptionPane.showInputDialog("Informe o Título da Obra");
            if (this.titulo == null) {
                menuLivro.menuLivro();
            }
        } while (!validador.validarInputString(this.titulo));


        do {
            this.autor = JOptionPane.showInputDialog("Pessoa Autora:");
            if (this.autor == null) {
                menuLivro.menuLivro();
            }
        } while (!validador.validarInputString(this.autor));


        do {
            this.editora = JOptionPane.showInputDialog("Editora:");
            if (this.editora == null) {
                menuLivro.menuLivro();
            }
        } while (!validador.validarInputString(this.editora));


        do {
            this.genero = JOptionPane.showInputDialog("Gênero Literário:");
            if (this.genero == null) {
                menuLivro.menuLivro();
            }
        } while (!validador.validarInputString(this.genero));


        do {
            try {
                String s = JOptionPane.showInputDialog("Quantidade de Páginas:");
                this.totalPaginas = Integer.parseInt(s);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Digite apenas números");
            }
        } while (!validador.validarInputInteger(this.totalPaginas));


    }

}

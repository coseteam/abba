package biblioteca.telas;

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
        this.isbn = JOptionPane.showInputDialog(("Informe o ISBN: "));
        this.titulo = JOptionPane.showInputDialog("Digite o titulo:");
        this.autor = JOptionPane.showInputDialog("Digite o autor:");
        this.editora = JOptionPane.showInputDialog("Digite o editora:");
        this.genero = JOptionPane.showInputDialog("Digite o gênero:");
        String s = JOptionPane.showInputDialog("Digite o total de páginas:");
        if (s != null) {
            this.totalPaginas = Integer.parseInt(s);
        }
    }

}

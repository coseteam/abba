package biblioteca.telas;

import javax.swing.*;

public class TelaAdicionarLivro{
    public String titulo;
    public String autor;
    public String editora;
    public String genero;
    public int totalPaginas;

    public TelaAdicionarLivro() {
        cadastrarLivroUsuario();
    }

    private void cadastrarLivroUsuario() {
        this.titulo = JOptionPane.showInputDialog("Digite o titulo:");
        this.autor = JOptionPane.showInputDialog("Digite o autor:");
        this.editora = JOptionPane.showInputDialog("Digite o editora:");
        this.genero = JOptionPane.showInputDialog("Digite o genero:");
        String s = JOptionPane.showInputDialog("Digite o total de paginas:");
        if (s != null) {
            this.totalPaginas = Integer.parseInt(s);
        }
    }

}

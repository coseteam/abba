package biblioteca.telas;

import javax.swing.*;

public class TelaAdicionarLivro{
    public String titulo;
    public String autor;
    public String editora;
    public String genero;
    public int totalPaginas;

    public TelaAdicionarLivro() {
        this.titulo = JOptionPane.showInputDialog("Título da obra:");
        this.autor = JOptionPane.showInputDialog("Nome do(a) autor(a):");
        this.editora = JOptionPane.showInputDialog("Informe a editora:");
        this.genero = JOptionPane.showInputDialog("Informe o gênero:");
        this.totalPaginas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade páginas:"));
    }

}

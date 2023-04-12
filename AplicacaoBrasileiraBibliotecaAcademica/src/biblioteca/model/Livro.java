package biblioteca.model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;


public class Livro implements Serializable {

    //    Atributos da classe abstrata livro
    private int codigo;
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String genero;
    private int totalPaginas;
    private static int totalLivros; // contagem total de todos os livros instanciados
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private boolean emprestado; // se estiver emprestado = true

    public int qtdTotalLivrosPersistidos; // Renba: Atributo criado


    //    Construtores
    public Livro(String isbn, String titulo, String autor, String editora, String genero, int totalPaginas) { // Renba
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.setTotalPaginas(totalPaginas);
        totalLivros++; //contador geral de livros

        //this.setCodigo(getTotalLivros()); //codigo para busca, adiciona um toda vez que um livro for criado

        // ======== Renba: manipulando o atributo para incrementar
        this.qtdTotalLivrosPersistidos = capturarTotalLivrosPersistidos();

    }


//    Getters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTotalLivros() {
        return totalLivros;
    }


    // ============== ====================== Renba > Teste para persistir quantidade de Livros
    public int capturarTotalLivrosPersistidos() {
        int qtdLivrosPersistidos = 55;
        //qtdLivrosPersistidos = LivroService.capturarQuantidadeLivros();
        return qtdLivrosPersistidos;
    }

    public String getISBN() {
        return isbn;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEditora() {
        return editora;
    }


    //    SETTERS


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setTotalPaginas(int totalPaginas) { //condicao para criação do livro
        if (totalPaginas <= 0) {

            String msg = "Quantidade de páginas deve ser maior que 0!";
            JOptionPane.showMessageDialog(new JFrame(), msg, "Alerta", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(msg);

        } else {
            this.totalPaginas = totalPaginas;
        }
    }

    public void estaEmprestado(boolean estaEmprestado, Emprestimo emprestimo) {
        if (estaEmprestado) {
            this.getEmprestimos().add(emprestimo);
            this.setEmprestado(true);
        }
    }

    public void foiDevolvido(boolean devolveu, Livro livro) {
        if (devolveu) {
            livro.setEmprestado(false);
        }
    }

    @Override
    public String toString() {
        return  "ISBN: " + isbn + "\n" +
                "Título: " + titulo + "\n" +
                "Autoria: " + autor + "\n" +
                "Editora:  " + editora + "\n" +
                "Gênero Literário: " + genero + "\n" +
                "Quantidade de Páginas: " + totalPaginas + "\n" +
                "______________________________";
    }

}




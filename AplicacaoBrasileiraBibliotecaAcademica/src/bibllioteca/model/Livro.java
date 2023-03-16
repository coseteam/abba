package bibllioteca.model;

import javax.swing.*;
import java.util.ArrayList;

public class Livro {

//    Atributos da classe abstrata livro

    private String titulo;
    private String autor;
    private String idioma;
    private String genero;
    private int totalPaginas;
    private static int totalLivros;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private boolean emprestado = false;

//    Construtores
    public Livro(String titulo, String autor, String idioma, String genero, int totalPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.setTotalPaginas(totalPaginas);

        totalLivros++;
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;

        totalLivros++;
    }

//    Getters


    public static int getTotalLivros() {
        return totalLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getGenero() {
        return genero;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

//    Setters


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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

    public void setTotalPaginas(int totalPaginas) {
        if (totalPaginas <= 0) {

            String msg = "Quantidade de paginas não pode ser menor ou igual a 0";
            JOptionPane.showMessageDialog(new JFrame(),msg,"Alerta",JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(msg);

        }else {
            this.totalPaginas = totalPaginas;
        }
    }

    public void estaEmprestado(boolean estaEmprestado, Emprestimo emprestimo){
        if (estaEmprestado) {
            this.getEmprestimos().add(emprestimo);
            this.setEmprestado(true);
        }
    }

    public void foiDevolvido(boolean devolveu, Livro livro){
        if (devolveu){
            livro.setEmprestado(false);
        }
    }

    @Override
    public String toString() {
        return "\nTitulo = " + titulo + "\n" +
                "Autor = " + autor + "\n" +
                "Idioma = " + idioma + "\n" +
                "Genero = " + genero + "\n" +
                "Total de paginas = " + totalPaginas + "\n" +
                "-----------------------------------\n";
    }

    @Override
    public boolean equals(Object obj) {
        Livro livro  = (Livro) obj;

        if (livro.getTitulo() == this.getTitulo()){
            return true;
        }
        return false;
    }
}

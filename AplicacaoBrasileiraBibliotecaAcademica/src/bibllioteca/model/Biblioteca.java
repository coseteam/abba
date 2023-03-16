package bibllioteca.model;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Livro livro;
    private Aluno aluno;


    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Aluno> getUsuarios() {
        return alunos;
    }

    public void setUsuarios(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int emprestar(String data, String dataDevolucao,Aluno aluno, Livro livro){
        Emprestimo emprestar = new Emprestimo(data, dataDevolucao, aluno, livro);
        livro.estaEmprestado(true, emprestar);
        aluno.getEmprestimos().add(emprestar);
        return emprestar.setId(aluno.getEmprestimos().size() +1);
    }

    public void devolver(Aluno aluno, Livro livro, int id){
        livro.foiDevolvido(false, livro);
        aluno.getEmprestimos().remove(id - 1);
    }

    public void adionarNovoLivro(String titulo, String autor, String idioma, String genero, int totalPaginas){
        Livro livro = new Livro(titulo, autor, idioma, genero, totalPaginas);
        getLivros().add(livro);
    }

    public void cadastrarAluno(String nome, String cpf, String login, String matricula){
        Aluno aluno = new Aluno(nome, cpf, login, matricula);
        this.getUsuarios().add(aluno);
    }

    public String listarLivros(){
        return getLivros().toString();
    }

    public Livro buscarLivro(String titulo){
        for (Livro livro: this.getLivros()){
            if (titulo == livro.getTitulo()){
                //JOptionPane.showMessageDialog(null,livro);
                this.livro = livro;
                break;
            }
        }

        if (this.livro == null){
            JOptionPane.showMessageDialog(null,"Livro nao localizado");
        }
        return this.livro;
    }

    public Aluno buscarAluno(String cpf){
        for (Aluno aluno: this.getUsuarios()){
            if (cpf == aluno.getCpf()){
                //JOptionPane.showMessageDialog(null,aluno);
                this.aluno = aluno;
                break;
            }
        }

        if (this.aluno == null){
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
        return this.aluno;
    }

//    public static void main(String[] args) {
//        Biblioteca bb = new Biblioteca();
//        bb.adionarNovoLivro("teste", "teste", "teste","teste",100);
//        bb.adionarNovoLivro("teste2", "teste2", "teste2","teste2",100);
//        bb.cadastrarAluno("vinicius","100","vini","1234");
//        bb.cadastrarAluno("luiza","101","lulu","1235");
//        //System.out.println(bb.buscarLivro("teste1"));
//        System.out.println(bb.buscarAluno("101"));
//
//    }

}

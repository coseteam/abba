package biblioteca.model;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> acervoLivros = new ArrayList<>(); //todos os livros da biblioteca
    private ArrayList<Aluno> carteiraAlunos = new ArrayList<>(); //todos os cadastros dos alunos
    private Livro livro;
    private Aluno aluno;


    public ArrayList<Livro> getLivros() {
        return acervoLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.acervoLivros = livros;
    }

    public ArrayList<Aluno> getUsuarios() {
        return carteiraAlunos;
    }

    public void setUsuarios(ArrayList<Aluno> alunos) {
        this.carteiraAlunos = alunos;
    }

    public int emprestar(String data, String dataDevolucao, Aluno aluno, Livro livro){
        Emprestimo emprestar = new Emprestimo(data, dataDevolucao, aluno, livro);
        livro.estaEmprestado(true, emprestar);
        aluno.emprestimosDoAluno.add(emprestar);
        return emprestar.getCodigo();
    }

    public void devolver(Aluno aluno, Livro livro, int codigoEmprestimo){
        livro.foiDevolvido(false, livro);
        aluno.emprestimosDoAluno.remove(codigoEmprestimo);
    }

    public void adionarNovoLivro(String titulo, String autor, String editora, String genero, int totalPaginas){
        Livro livro = new Livro(titulo, autor, editora, genero, totalPaginas);
        getLivros().add(livro);
    }

    public void cadastrarAluno(String nome, String cpf, String matricula){
        Aluno aluno = new Aluno(nome, cpf, matricula);
        this.getUsuarios().add(aluno);
    }

    public String listarLivros(){
        return acervoLivros.toString();
    }

    public String listarAlunos(){ return carteiraAlunos.toString();}

    public Livro buscarLivro(int codigo){
        for (Livro livro: this.acervoLivros){
            if (codigo == livro.getCodigo()){
                JOptionPane.showMessageDialog(null,livro);
                this.livro = livro;
                break;
            }
        }

        if (this.livro == null){
            JOptionPane.showMessageDialog(null,"Livro nao localizado");
        }
        return this.livro;
    }

    public Aluno buscarAluno(int id){
        for (Aluno aluno: this.carteiraAlunos){
            if (id == aluno.getId()){
                JOptionPane.showMessageDialog(null,aluno);
                this.aluno = aluno;
                break;
            }
        }

        if (this.aluno == null){
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
        return this.aluno;
    }

}

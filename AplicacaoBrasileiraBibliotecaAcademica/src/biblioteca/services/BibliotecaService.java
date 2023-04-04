package biblioteca.services;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Funcionario;
import biblioteca.model.Livro;

import java.util.ArrayList;


public class BibliotecaService {
    public ArrayList<Livro> todosLivros = new ArrayList<>();
    public ArrayList<Aluno> todosAlunos = new ArrayList<>();
    public ArrayList<Funcionario> todosFuncionarios = new ArrayList<>();
    public ArrayList<Emprestimo> todosEmprestimos = new ArrayList<>();
    public static ArrayList<String> todosISBNCadastrados = new ArrayList<>();
    public static PersistenciaService persistenciaService = new PersistenciaService();


    public BibliotecaService() {
        this.todosLivros = persistenciaService.lerLivrosPersistidos();
//        this.todosAlunos = persistenciaService.lerAlunosPersistidos();
        //this.todosISBNCadastrados = PersistenciaService.lerISBNPersisitidos();
        this.todosISBNCadastrados.add("A0A0A0");
    }

    public static void setTodosISBNCadastrados(String newISBN) {
        todosISBNCadastrados.add(newISBN);
        persistenciaService.persistirEntidade(todosISBNCadastrados);
    }



}

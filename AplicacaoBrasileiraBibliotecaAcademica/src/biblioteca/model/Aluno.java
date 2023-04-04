package biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Usuario implements Serializable {
    private String matricula;
    private ArrayList<Emprestimo> emprestimosDoAluno = new ArrayList();
    private ArrayList<Livro> livrosComAluno = new ArrayList(); // ForJoyce: (4) Aqui pode não ser Array. Prevemos apenas 1 livro por empréstimo. E apenas 1 empréstimo por vez.

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Emprestimo> getEmprestimosDoAluno() {
        return emprestimosDoAluno;
    }

    public ArrayList<Livro> getLivrosComAluno() {
        return livrosComAluno;
    }



    @Override
    public String toString() {
        return  "id = " + this.getId() + "\n" +
                "Nome = " + this.getNome() + "\n" +
                "CPF = " + this.getCpf() + "\n" +
                "Matricula = " + matricula + '\n';
    }
}



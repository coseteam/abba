package biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Usuario implements Serializable {
    private String matricula;
    private ArrayList<Emprestimo> emprestimosDoAluno = new ArrayList();
    private ArrayList<Livro> livrosComAluno = new ArrayList();

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

//    public void setEmprestimosDoAluno(ArrayList<Emprestimo> atuaisEmprestimos) {
//        this.emprestimosDoAluno = atuaisEmprestimos;
//    }

    public ArrayList<Livro> getLivrosComAluno() {
        return livrosComAluno;
    }

//    public void setLivrosComAluno(ArrayList<Livro> atuaisLivros) {
//        this.livrosComAluno = atuaisLivros;
//    }




    @Override
    public String toString() {
        return  "Nome: " + this.getNome() + "\n" +
                "CPF: " + this.getCpf() + "\n" +
                "Matrícula: " + matricula + "\n" +
                "_____________________________";
    }
}



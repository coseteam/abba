package biblioteca.model;

import java.util.ArrayList;

public class Aluno extends Usuario {
    private String matricula;
    ArrayList<Emprestimo> emprestimosDoAluno = new ArrayList();

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

    @Override
    public String toString() {
        return  "id = " + this.getId() + "\n" +
                "Nome = " + this.getNome() + "\n" +
                "CPF = " + this.getCpf() + "\n" +
                "Matricula = " + matricula + '\n';
    }
}

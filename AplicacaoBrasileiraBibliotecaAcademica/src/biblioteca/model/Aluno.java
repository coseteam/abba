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

    public ArrayList<Emprestimo> getEmprestimosDoAluno() {
        return emprestimosDoAluno;
    }

//    public ArrayList<String> buscandoTitulosDoAluno() {
//        if (emprestimosDoAluno.isEmpty()){
//            for (Emprestimo emprestimo: emprestimosDoAluno) {
//                buscandoTitulosDoAluno().add(emprestimo.getLivro().getTitulo());
//            }
//        }else {
//            buscandoTitulosDoAluno().add("Nenhum livro emprestado neste momento");
//        }
//
//        return buscandoTitulosDoAluno();
//    }

    @Override
    public String toString() {
        return  "id = " + this.getId() + "\n" +
                "Nome = " + this.getNome() + "\n" +
                "CPF = " + this.getCpf() + "\n" +
                "Matricula = " + matricula + '\n' ;
//                "Livros em uso = " + buscandoTitulosDoAluno();
    }
}

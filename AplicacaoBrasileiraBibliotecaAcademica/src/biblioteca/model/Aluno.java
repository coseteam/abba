package biblioteca.model;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String cpf, String login, String matricula) {
        super(nome, cpf, login);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno aluno  = (Aluno) obj;

        if (aluno.getCpf() == this.getCpf()){
            return true;
        }
        return false;
    }
}

package biblioteca.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static int numOfAlunos;
    private String nome;
    private String cpf;


    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        setNumOfAlunos(getNumOfAlunos() + 1);
    }

    public static int getNumOfAlunos() {
        return numOfAlunos;
    }

    public static void setNumOfAlunos(int numOfAlunos) {
        Usuario.numOfAlunos = numOfAlunos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return  "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n";

    }
}

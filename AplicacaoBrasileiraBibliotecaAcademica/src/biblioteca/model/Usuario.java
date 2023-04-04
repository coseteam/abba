package biblioteca.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static int numOfAlunos; // ForJoyce: (3) Essa contagem realmente deve ficar em Usuario?
    private int id;
    private String nome;
    private String cpf;





    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        setNumOfAlunos(getNumOfAlunos() + 1);
        setId(getNumOfAlunos());
    }

    public static int getNumOfAlunos() {
        return numOfAlunos;
    }

    public static void setNumOfAlunos(int numOfAlunos) {
        Usuario.numOfAlunos = numOfAlunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID =" + id + "\n" +
                "Nome ='" + nome + "\n" +
                "CPF ='" + cpf + "\n";

    }
}

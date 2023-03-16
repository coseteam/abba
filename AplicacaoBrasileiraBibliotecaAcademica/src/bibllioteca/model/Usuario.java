package bibllioteca.model;

import java.util.ArrayList;

public abstract class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String login;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();



    public Usuario(String nome, String cpf, String login) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        setId(getId() + 1);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "id =" + id + "\n" +
                "nome='" + nome + "\n" +
                "cpf='" + cpf + "\n" +
                "login='" + login + "\n" +
                "emprestimos=" + emprestimos;
    }
}

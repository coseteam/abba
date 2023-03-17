package biblioteca.model;

public abstract class Usuario {
    private static int id;
    private String nome;
    private String cpf;




    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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


    @Override
    public String toString() {
        return "id =" + id + "\n" +
                "nome='" + nome + "\n" +
                "cpf='" + cpf + "\n";

    }
}

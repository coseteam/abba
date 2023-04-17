package biblioteca.model;

import java.util.Date;

public class Funcionario extends Usuario {
    private String login; // ForJoyce: (1) atributo consta no construtor, mas não estava aqui - Faltam Get&Set
    private double salario;
    private int nivelFuncao; // ForJoyce: (2) atributo função(String) é atribuído, conforme nívelFuncao(int) - Faltam Get&Set
    private String funcao; // ForJoyce: (2) Recomendo atribuir conforme atributo de nivelFuncao - S/ Set
    private Date dataAdmissao;


    public Funcionario( String nome, String cpf, String login, double salario, String funcao, Date dataAdmissao) {
        super( nome, cpf);
        this.login = login; // ForJoyce: (1) atributo consta no construtor, mas não estava aqui - Faltam Get&Set
        this.salario = salario;
        this.funcao = funcao;
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

}

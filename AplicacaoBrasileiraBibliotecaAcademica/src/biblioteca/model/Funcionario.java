package biblioteca.model;

import java.util.Date;

public class Funcionario extends Usuario {
    private double salario;
    private String funcao;
    private Date dataAdmissao;


    public Funcionario( String nome, String cpf, String login, double salario, String funcao, Date dataAdmissao) {
        super( nome, cpf, login);
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

package biblioteca.model;

import java.io.Serializable;

public class Emprestimo implements Serializable {
    private String dataInicioEmprestimo;
    private String dataDevolucaoEmprestimo;
    private Livro livro;
    private Aluno aluno;
    private int codigo;

    public Emprestimo(String dataInicioEmprestimo, String dataDevolucao, Aluno aluno, Livro livro) {
        this.dataInicioEmprestimo = dataInicioEmprestimo;
        this.dataDevolucaoEmprestimo = dataDevolucao;
        this.livro = livro;
        this.aluno = aluno;
        this.codigo = (int)(Math.random() * ((1000 - 1)+1)) + 1;;
    }

    public String getData() {
        return dataInicioEmprestimo;
    }

    public void setData(String data) {
        this.dataInicioEmprestimo = data;
    }

    public String getDataDevolucao() {
        return dataDevolucaoEmprestimo;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucaoEmprestimo = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivros(Livro livros) {
        this.livro = livros;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getCodigo() {
        return codigo;
    }


    @Override
    public String toString() {
        return  "\n" +
                "::: Empréstimo nº " + codigo + " :::\n" +
                "Data de Retirada: " + dataInicioEmprestimo + "  |  " +
                "Data da Devolução: " + dataDevolucaoEmprestimo + "\n" +
                "::: Livro ::: " + livro +
                "::: Aluno ::: " + aluno +
                "¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨";
    }
}

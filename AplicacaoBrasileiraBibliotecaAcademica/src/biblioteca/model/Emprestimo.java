package biblioteca.model;

public class Emprestimo{
    private String dataInicioEmprestimo;
    private String dataDevolucaoEmprestimo;
    private Livro livro;
    private Aluno aluno;
    private static int codigo;

    public Emprestimo(String dataInicioEmprestimo, String dataDevolucao, Aluno aluno, Livro livro) {
        this.dataInicioEmprestimo = dataInicioEmprestimo;
        this.dataDevolucaoEmprestimo = dataDevolucao;
        this.livro = livro;
        this.aluno = aluno;
        this.codigo++;
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
        return  "Código do Emprestimo = " + codigo + "\n" +
                "Data do Empréstimo = " + dataInicioEmprestimo + '\n' +
                "Data da Devolução = " + dataDevolucaoEmprestimo + '\'' +
                "Livro = " + livro + '\n' +
                "Aluno = " + aluno;
    }
}

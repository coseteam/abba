package bibllioteca.model;

public class Emprestimo {
    private String data;
    private String dataDevolucao;
    private Livro livro;
    private Aluno aluno;
    private int id;

    public Emprestimo(String data, String dataDevolucao, Aluno aluno, Livro livro) {
        this.data = data;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.aluno = aluno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }
}

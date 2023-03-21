package biblioteca.model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> acervoLivros = new ArrayList<>(); //todos os livros da biblioteca
    private ArrayList<Aluno> carteiraAlunos = new ArrayList<>(); //todos os cadastros dos alunos
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();//todos os emprestimos
    private Emprestimo emprestimo;
    private Livro livro;
    private Aluno aluno;

    public Biblioteca(){
        this.acervoLivros = lerLivrosPersistidos();
    }


    public ArrayList<Livro> getLivros() {
        return acervoLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.acervoLivros = livros;
    }

    public ArrayList<Aluno> getUsuarios() {
        return carteiraAlunos;
    }

    public void setUsuarios(ArrayList<Aluno> alunos) {
        this.carteiraAlunos = alunos;
    }

    public ArrayList<Emprestimo> getEmprestimos() {return emprestimos;}

    public int emprestar(String data, String dataDevolucao, Aluno aluno, Livro livro){
        Emprestimo emprestar = new Emprestimo(data, dataDevolucao, aluno, livro);
        livro.estaEmprestado(true, emprestar);
        aluno.getEmprestimosDoAluno().add(emprestar);
        aluno.getLivrosComAluno().add(livro);
        this.emprestimos.add(emprestar);
        return emprestar.getCodigo();
    }

    public void devolver(Aluno aluno, Livro livro, int codigoEmprestimo){
        livro.foiDevolvido(true, livro);
        aluno.getEmprestimosDoAluno().remove(codigoEmprestimo);
        aluno.getLivrosComAluno().remove(livro);
        Emprestimo emp = buscarEmprestimo(codigoEmprestimo);
        this.emprestimos.remove(emp);
    }

    public void adionarNovoLivro(String titulo, String autor, String editora, String genero, int totalPaginas){
        Livro livro = new Livro(titulo, autor, editora, genero, totalPaginas);
        getLivros().add(livro);
        persistirListaDeLivros(this.acervoLivros);
    }

    public void removerLivro(int codigo){
        Livro livroR = buscarLivro(codigo);
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover este livro?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().remove(livroR);
            persistirListaDeLivros(this.acervoLivros);
        }

    }

    public void apagarListaLivros(){
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja APAGAR a lista de livros?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().clear();
            persistirListaDeLivros(this.acervoLivros);
            JOptionPane.showMessageDialog(null, "Lista de livros apagada com sucesso!");
        }
    }

    public void atualizarLivro(int codigo){
        String msg = "Qual informação gostaria de atualizar:\n 1 - Titulo\n 2 - Autor\n 3 - Editora\n 4 - genero\n " +
                "5 - Total de paginas";
        Livro livro = buscarLivro(codigo);
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        if (caminho == 1) {
            livro.setTitulo(JOptionPane.showInputDialog("Digitar titulo:"));
            JOptionPane.showMessageDialog(null, "Titulo Atualizado!");
            persistirListaDeLivros(this.acervoLivros);
        }else if (caminho == 2) {
            livro.setAutor(JOptionPane.showInputDialog("Digitar autor:"));
            JOptionPane.showMessageDialog(null,"Autor Atualizado!");
            persistirListaDeLivros(this.acervoLivros);
        }else if (caminho == 3) {
            livro.setEditora(JOptionPane.showInputDialog("Digitar editora:"));
            JOptionPane.showMessageDialog(null,"Editora Atualizada!");
            persistirListaDeLivros(this.acervoLivros);
        }else if (caminho == 4) {
            livro.setGenero(JOptionPane.showInputDialog("Digitar genero:"));
            JOptionPane.showMessageDialog(null,"Genero Atualizado!");
            persistirListaDeLivros(this.acervoLivros);
        }else if (caminho == 5){
            livro.setTotalPaginas(Integer.parseInt(JOptionPane.showInputDialog("Digitar total de paginas:")));
            JOptionPane.showMessageDialog(null,"Total de paginas Atualizado!");
            persistirListaDeLivros(this.acervoLivros);
        }
    }

    public String listarLivros(){
        return acervoLivros.toString();
    }

    public void cadastrarAluno(String nome, String cpf, String matricula){
        Aluno aluno = new Aluno(nome, cpf, matricula);
        this.getUsuarios().add(aluno);
    }

    public void removerAluno(int id){
        Aluno aluno = buscarAluno(id);
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover este cadastro?");
        if (confirma == JOptionPane.YES_OPTION){
            getUsuarios().remove(aluno);
        }

    }

    public void apagarListaAlunos(){
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja APAGAR a lista de Alunos?");
        if (confirma == JOptionPane.YES_OPTION){
            getUsuarios().clear();
            JOptionPane.showMessageDialog(null, "Lista de alunos apagada com sucesso!");
        }
    }

    public void atualizarAluno(int id){
        String msg = "Qual informação gostaria de atualizar:\n 1 - Nome\n 2 - CPF\n 3 - Matricula";
        Aluno aluno = buscarAluno(id);
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        if (caminho == 1) {
            aluno.setNome(JOptionPane.showInputDialog("Digitar novo nome:"));
            JOptionPane.showMessageDialog(null, "Nome Atualizado!");
        }else if (caminho == 2) {
            aluno.setCpf(JOptionPane.showInputDialog("Digitar o CPF:"));
            JOptionPane.showMessageDialog(null,"CPF Atualizado!");
        }else if (caminho == 3) {
            aluno.setMatricula(JOptionPane.showInputDialog("Digitar a Matricula:"));
            JOptionPane.showMessageDialog(null,"Matricula Atualizada!");
        }
    }

    public String listarAlunos(){ return carteiraAlunos.toString();}

    public Livro buscarLivro(int codigo){
        for (Livro livro: this.acervoLivros){
            if (codigo == livro.getCodigo()){
                JOptionPane.showMessageDialog(null,livro);
                this.livro = livro;
                break;
            }
        }

        if (this.livro == null){
            JOptionPane.showMessageDialog(null,"Livro nao localizado");
        }
        return this.livro;
    }

    public Aluno buscarAluno(int id){
        for (Aluno aluno: this.carteiraAlunos){
            if (id == aluno.getId()){
                JOptionPane.showMessageDialog(null,aluno);
                this.aluno = aluno;
                break;
            }
        }

        if (this.aluno == null){
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
        return this.aluno;
    }

    public Emprestimo buscarEmprestimo(int codigo){
        for (Emprestimo emp: this.emprestimos){
            if (codigo == emp.getCodigo()){
                JOptionPane.showMessageDialog(null,aluno);
                this.emprestimo = emp;
                break;
            }
        }

        if (this.emprestimo == null){
            JOptionPane.showMessageDialog(null,"Emprestimo nao localizado");
        }
        return this.emprestimo;
    }

//========================================================================================================
//                              metodos para persistir objetos

    public static void persistirListaDeLivros(ArrayList<Livro> livros) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("livrosPersistidos.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(livros);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo");
                }
            }
        }
    }

    public static ArrayList<Livro> lerLivrosPersistidos() {
        ArrayList<Livro> livros = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("livrosPersistidos.dat");
            ois = new ObjectInputStream(fis);
            livros = (ArrayList<Livro>) ois.readObject();
            return livros;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Classe não encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo");
                }
            }
        }
        return livros;
    }

}

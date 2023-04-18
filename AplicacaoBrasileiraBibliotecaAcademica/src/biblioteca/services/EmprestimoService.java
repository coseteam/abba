package biblioteca.services;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import javax.swing.*;
import java.util.ArrayList;

public class EmprestimoService {
    private Emprestimo emprestimo;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>(); //todos os emprestimos
    private PersistenciaService persistenciaService = new PersistenciaService();



    public ArrayList<Emprestimo> getEmprestimos() {return emprestimos;}


    public int emprestar(String data, String dataDevolucao, Aluno aluno, Livro livro){
        Emprestimo emprestimo = new Emprestimo(data, dataDevolucao, aluno, livro);

        livro.estaEmprestado(true, emprestimo);
        aluno.getEmprestimosDoAluno().add(emprestimo);
        aluno.getLivrosComAluno().add(livro);
        this.emprestimos.add(emprestimo);

        emprestimos = persistenciaService.lerEmprestimosPersistidos();
        getEmprestimos().add(emprestimo);
        persistenciaService.persistirEntidade(this.emprestimos);
        return emprestimo.getCodigo();
    }


    public void devolver(Aluno aluno, Livro livro, int codigoEmprestimo){
        if (this.emprestimos.isEmpty()){
            emprestimos = persistenciaService.lerEmprestimosPersistidos();
        }

        livro.foiDevolvido(true, livro);

        ArrayList<Emprestimo> listaEmprestimosDesteAluno = aluno.getEmprestimosDoAluno();
        for (Emprestimo emp: listaEmprestimosDesteAluno) {
            if (emp.getCodigo() == codigoEmprestimo) {
                Integer indEmprestimo = listaEmprestimosDesteAluno.indexOf(emp);
                aluno.getEmprestimosDoAluno().remove(indEmprestimo);
                System.out.println(aluno.getEmprestimosDoAluno());
                break;
            }
        }

        ArrayList<Livro> listaLivrosComEsteAluno = aluno.getLivrosComAluno();
        for (Livro liv: listaLivrosComEsteAluno) {
            if (liv.equals(livro)) {
                Integer indLivro = listaLivrosComEsteAluno.indexOf(liv);
                aluno.getLivrosComAluno().remove(indLivro);
                System.out.println("Emprestimos do aluno");
                System.out.println(aluno.getEmprestimosDoAluno());
                break;
            }
        }

        for (Emprestimo emp: emprestimos){
            System.out.println("PERCORRENDO A LISTA DE EMPRESTIMOS " + emp);
            if (codigoEmprestimo == emp.getCodigo()){
                emprestimos.remove(emp);
                break;
            }
        }
        persistenciaService.persistirEntidade(this.emprestimos);
    }


    public Emprestimo buscarEmprestimo(int codigo){ //
        if (this.emprestimos.isEmpty()){
            emprestimos = persistenciaService.lerEmprestimosPersistidos();
        }

        System.out.println("EMPRÉSTIMO SERVICE 51: codigo recebido >>> " + codigo);
        for (Emprestimo emp: this.emprestimos){
            if (codigo == emp.getCodigo()){
                JOptionPane.showMessageDialog(null, emp.getAluno());
                this.emprestimo = emp;
                break;
            }
        }

        if (this.emprestimo == null){
            JOptionPane.showMessageDialog(null,"Desculpe, não localizamos este empréstimo.;");
        }

        return this.emprestimo;
    }


    public String listarEmprestimo(){
        if (this.emprestimos.isEmpty()){
            emprestimos = persistenciaService.lerEmprestimosPersistidos();
        }
        if (this.emprestimos.isEmpty() || this.emprestimos == null) {
            return "Realmente, não há nenhum registro de empréstimos anteriores.";
        }

        return emprestimos.toString().replaceAll("\\[|\\,|\\]|\\_", "");
    }

}

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

//    public int emprestar(String data, String dataDevolucao, Aluno aluno, Livro livro){ RENBA: COPIA DA VERSAO EMPRESTAR EM 11/04
//        Emprestimo emprestar = new Emprestimo(data, dataDevolucao, aluno, livro);
//        livro.estaEmprestado(true, emprestar);
//        aluno.getEmprestimosDoAluno().add(emprestar);
//        aluno.getLivrosComAluno().add(livro);
//        this.emprestimos.add(emprestar);
//        return emprestar.getCodigo();
//    }

    public void devolver(Aluno aluno, Livro livro, int codigoEmprestimo){
        livro.foiDevolvido(true, livro);
        aluno.getEmprestimosDoAluno().remove(codigoEmprestimo);
        aluno.getLivrosComAluno().remove(livro);
        Emprestimo emp = buscarEmprestimo(codigoEmprestimo);
        this.emprestimos.remove(emp);
    }

    public Emprestimo buscarEmprestimo(int codigo){ //
        System.out.println("EMPRÉSTIMO SERVICE 51: codigo recebido >>> " + codigo);
        for (Emprestimo emp: this.emprestimos){
            System.out.println("PERCORRENDO A LISTA DE EMPRESTIMOS " + emp);
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

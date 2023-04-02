package biblioteca.services;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;

import javax.swing.*;
import java.util.ArrayList;

public class EmprestimoService {

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();//todos os emprestimos
    private Emprestimo emprestimo;

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

    public Emprestimo buscarEmprestimo(int codigo){
        for (Emprestimo emp: this.emprestimos){
            if (codigo == emp.getCodigo()){
                JOptionPane.showMessageDialog(null, emp.getAluno());
                this.emprestimo = emp;
                break;
            }
        }

        if (this.emprestimo == null){
            JOptionPane.showMessageDialog(null,"Desculpe, não localizamos este empréstimo.");
        }
        return this.emprestimo;
    }

    public String listarEmprestimo(){
        if (this.emprestimos.isEmpty()){
            emprestimos = PersistenciaService.lerAlunosPersistidos();
        }
        return emprestimos.toString();
    }

}

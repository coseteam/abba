package biblioteca.services;

import biblioteca.model.Aluno;

import javax.swing.*;
import java.util.ArrayList;

public class AlunoService {

    private Aluno aluno;

    private ArrayList<Aluno> carteiraAlunos = new ArrayList<>(); //todos os cadastros dos alunos

    public ArrayList<Aluno> getUsuarios() {
        return carteiraAlunos;
    }

    public void setUsuarios(ArrayList<Aluno> alunos) {
        this.carteiraAlunos = alunos;
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
}

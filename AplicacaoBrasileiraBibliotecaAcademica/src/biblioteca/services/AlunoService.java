package biblioteca.services;

import biblioteca.model.Aluno;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class AlunoService {

    private Aluno aluno;
    private ArrayList<Aluno> carteiraAlunos = new ArrayList<>(); //todos os cadastros dos alunos

    private PersistenciaService persistenciaService = new PersistenciaService();
    public ArrayList<Aluno> getUsuarios() {
        return carteiraAlunos;
    }

    public void setUsuarios(ArrayList<Aluno> alunos) {
        this.carteiraAlunos = alunos;
    }

    public void cadastrarAluno(String nome, String cpf, String matricula){
        Aluno aluno = new Aluno(nome, cpf, matricula);
        carteiraAlunos = persistenciaService.lerAlunosPersistidos();
        this.getUsuarios().add(aluno);
        persistenciaService.persistirEntidade(this.carteiraAlunos);
    }

    public void removerAluno(int id){
        Aluno aluno = buscarAluno(id);
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cadastro deste aluno?");
        if (confirma == JOptionPane.YES_OPTION){
            getUsuarios().remove(aluno);
        }

    }

    public void apagarListaAlunos(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cadastro de todos os alunos?");
        if (confirma == JOptionPane.YES_OPTION){
            getUsuarios().clear();
            File file = new File("alunosPersistidos.dat");
            if (file.delete()) {
                System.out.println("Arquivo deletado com sucesso");
            }
            JOptionPane.showMessageDialog(null, "Operação finalizada. Não há alunos cadastrados.");
        }
    }

    public void atualizarAluno(int id){
        String msg = "Qual informação gostaria de atualizar:\n 1 - Nome\n 2 - CPF\n 3 - Matrícula";
        Aluno aluno = buscarAluno(id);
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        if (caminho == 1) {
            aluno.setNome(JOptionPane.showInputDialog("Digite o nome correto: "));
            JOptionPane.showMessageDialog(null, "Nome atualizado!");
        }else if (caminho == 2) {
            aluno.setCpf(JOptionPane.showInputDialog("Digite o CPF correto: "));
            JOptionPane.showMessageDialog(null,"CPF atualizado!");
        }else if (caminho == 3) {
            aluno.setMatricula(JOptionPane.showInputDialog("Digite a matrícula correta: "));
            JOptionPane.showMessageDialog(null,"A matrícula foi atualizada!");
        }
    }

    public String listarAlunos(){
        if (this.carteiraAlunos.isEmpty()){
            carteiraAlunos = persistenciaService.lerAlunosPersistidos();
        }
        if (this.carteiraAlunos.isEmpty() || this.carteiraAlunos == null){
            return "Não há alunos cadastrados.";
        }
        return carteiraAlunos.toString();
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
            JOptionPane.showMessageDialog(null,"Desculpe, não localizamos este aluno. ");
        }
        return this.aluno;
    }
}

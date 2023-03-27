package biblioteca.services;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersistenciaService {

    private ArrayList<Livro> livros;


    public static <T> void persistirEntidade(ArrayList<T> entidades) {
        FileOutputStream arquivoStream = null;
        ObjectOutputStream objetoStream = null;

        try {

            if (entidades.get(0) instanceof T) {
                arquivoStream = new FileOutputStream("livrosPersistidos.dat");
            } else if (entidades.get(0) instanceof Aluno) {
                arquivoStream = new FileOutputStream("alunosPersistidos.dat");
            } else if (entidades.get(0) instanceof Emprestimo) {
                arquivoStream = new FileOutputStream("emprestimosPersistidos.dat");
            }

            objetoStream = new ObjectOutputStream(arquivoStream);
            objetoStream.writeObject(entidades);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
        } finally {
            if (objetoStream != null) {
                try {
                    objetoStream.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo");
                }
            }
        }
    }

    public static <T> ArrayList<T> lerEntidadePersistida(FileInputStream fis) {
        ArrayList<T> entidade = null;
        ObjectInputStream ois = null;

        try {

            ois = new ObjectInputStream(fis);
            entidade = (ArrayList<T>) ois.readObject();

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
        return entidade;
    }

    public static <T> ArrayList<T> lerLivrosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("livrosPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
        return lerEntidadePersistida(fis);

    }

    public static <T> ArrayList<T> lerAlunosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("alunosPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
        return lerEntidadePersistida(fis);

    }

    public static <T> ArrayList<T> lerEmprestimosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("emprestimosPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
        return lerEntidadePersistida(fis);

    }


//    public static void persistirListaDeAlunos(ArrayList<Aluno> alunos) {
//        FileOutputStream arquivoStream = null;
//        ObjectOutputStream objetoStream = null;
//
//        try {
//            arquivoStream = new FileOutputStream("alunosPersistidos.dat");
//            objetoStream = new ObjectOutputStream(arquivoStream);
//            objetoStream.writeObject(alunos);
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
//        } finally {
//            if (objetoStream != null) {
//                try {
//                    objetoStream.close();
//                } catch (IOException e) {
//                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo");
//                }
//            }
//        }
//    }


}

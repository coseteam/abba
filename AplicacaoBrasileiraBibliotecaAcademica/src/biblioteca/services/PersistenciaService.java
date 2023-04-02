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
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo.");
        } finally {
            if (objetoStream != null) {
                try {
                    objetoStream.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo.");
                }
            }
        }
    }

    public static <T> ArrayList<T> lerEntidadePersistida(FileInputStream fis) {
        ArrayList<T> entidade = new ArrayList<T>();
        ObjectInputStream ois = null;

        try {
            if (fis.available() == 0){
                return new ArrayList<T>();}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ois = new ObjectInputStream(fis);
            entidade = (ArrayList<T>) ois.readObject();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo.");
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
            File file = new File("livrosPersistidos.dat");
            try {
                file.createNewFile();
                fis = new FileInputStream("alunosPersistidos.dat");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return lerEntidadePersistida(fis);

    }

    public static <T> ArrayList<T> lerAlunosPersistidos() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("alunosPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            File file = new File("alunosPersistidos.dat");
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                fis = new FileInputStream("alunosPersistidos.dat");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        return lerEntidadePersistida(fis);

    }

    public static <T> ArrayList<T> lerEmprestimosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("emprestimosPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
        }
        return lerEntidadePersistida(fis);

    }


    public static <T> ArrayList<T> lerISBNPersisitidos(){
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("isbnPersistidos.dat");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Nenhum ISBN encontrado.");
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

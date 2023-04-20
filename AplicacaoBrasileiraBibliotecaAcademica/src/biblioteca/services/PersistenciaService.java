package biblioteca.services;

import biblioteca.model.Aluno;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;



public class PersistenciaService {
    private ArrayList<Livro> livros;


    public <T> void persistirEntidade(ArrayList<T> entidades) {
        FileOutputStream arquivoStream = null;
        ObjectOutputStream objetoStream = null;

        try {

            if (entidades.get(0) instanceof Livro) {
                arquivoStream = new FileOutputStream("livrosPersistidos.dat");
            } else if (entidades.get(0) instanceof Aluno) {
                arquivoStream = new FileOutputStream("alunosPersistidos.dat");
            } else if (entidades.get(0) instanceof Emprestimo) {
                arquivoStream = new FileOutputStream("emprestimosPersistidos.dat");
            } else if (entidades.get(0) instanceof String) {
                arquivoStream = new FileOutputStream("isbnPersistidos.dat");
            }

            objetoStream = new ObjectOutputStream(arquivoStream);
            objetoStream.writeObject(entidades);
            arquivoStream.close();
            objetoStream.close();
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

    public <T> ArrayList<T> lerEntidadePersistida(FileInputStream fis) {
        ArrayList<T> entidade = new ArrayList<T>();
        ObjectInputStream ois = null;

        try {
            if (fis.available() == 0){
                fis.close();
                return new ArrayList<T>();}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ois = new ObjectInputStream(fis);
            entidade = (ArrayList<T>) ois.readObject();
            fis.close();
            ois.close();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar arquivo.");
                }
            }
        }
        return entidade;
    }

    public <T> ArrayList<T> lerLivrosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("livrosPersistidos.dat");
        } catch (FileNotFoundException e) {
            File file = new File("livrosPersistidos.dat");
            try {
                file.createNewFile();
                fis = new FileInputStream("livrosPersistidos.dat");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return lerEntidadePersistida(fis);

    }

    public <T> ArrayList<T> lerAlunosPersistidos() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("alunosPersistidos.dat");
        } catch (FileNotFoundException e) {
            File file = new File("alunosPersistidos.dat");
            try {
                if (file.createNewFile()) {
                    fis = new FileInputStream("alunosPersistidos.dat");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return lerEntidadePersistida(fis);

    }

    public <T> ArrayList<T> lerEmprestimosPersistidos(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("emprestimosPersistidos.dat");
        } catch (FileNotFoundException e) {
            File file = new File("emprestimosPersistidos.dat");

            try {
                if (file.createNewFile()) {
                    fis = new FileInputStream("emprestimosPersistidos.dat");

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não há registros de Empréstimos.");
            }

        }
        return lerEntidadePersistida(fis);

    }


    public <T> ArrayList<T> lerISBNPersisitidos(){
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("isbnPersistidos.dat");
        } catch (FileNotFoundException e) {
            File file = new File("isbnPersistidos.dat");

            try {
                if (file.createNewFile()) {
                    fis = new FileInputStream("isbnPersistidos.dat");

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nenhum ISBN encontrado.");
            }

        }

        return lerEntidadePersistida(fis);
    }


}

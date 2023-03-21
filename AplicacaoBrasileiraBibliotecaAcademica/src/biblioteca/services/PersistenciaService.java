package biblioteca.services;

import biblioteca.model.Livro;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersistenciaService {

    private ArrayList<Livro> livros = lerLivrosPersistidos();


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

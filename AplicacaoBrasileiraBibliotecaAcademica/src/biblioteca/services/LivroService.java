package biblioteca.services;

import biblioteca.model.Livro;

import javax.swing.*;
import java.util.ArrayList;

public class LivroService {

    private Livro livro;

    private ArrayList<Livro> acervoLivros = new ArrayList<>(); //todos os livros da biblioteca

    private PersistenciaService persistenciaService = new PersistenciaService();

    public ArrayList<Livro> getLivros() {
        return acervoLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.acervoLivros = livros;
    }

    public void adionarNovoLivro(String titulo, String autor, String editora, String genero, int totalPaginas){
        Livro livro = new Livro(titulo, autor, editora, genero, totalPaginas);
        getLivros().add(livro);
        persistenciaService.persistirEntidade(this.acervoLivros);
    }

    public void removerLivro(int codigo){
        Livro livroR = buscarLivro(codigo);
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover este livro?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().remove(livroR);
            persistenciaService.persistirEntidade(this.acervoLivros);
        }

    }

    public void apagarListaLivros(){
        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja APAGAR a lista de livros?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().clear();
            persistenciaService.persistirEntidade(this.acervoLivros);
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
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 2) {
            livro.setAutor(JOptionPane.showInputDialog("Digitar autor:"));
            JOptionPane.showMessageDialog(null,"Autor Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 3) {
            livro.setEditora(JOptionPane.showInputDialog("Digitar editora:"));
            JOptionPane.showMessageDialog(null,"Editora Atualizada!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 4) {
            livro.setGenero(JOptionPane.showInputDialog("Digitar genero:"));
            JOptionPane.showMessageDialog(null,"Genero Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 5){
            livro.setTotalPaginas(Integer.parseInt(JOptionPane.showInputDialog("Digitar total de paginas:")));
            JOptionPane.showMessageDialog(null,"Total de paginas Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }
    }

    public String listarLivros(){
        if (this.acervoLivros.isEmpty()){
            acervoLivros = persistenciaService.lerLivrosPersistidos();
        }
        return acervoLivros.toString();
    }

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


}

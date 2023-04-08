package biblioteca.services;

import biblioteca.model.Livro;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;


public class LivroService {
    private Livro livro;
    private ArrayList<Livro> acervoLivros = new ArrayList<>();
    private PersistenciaService persistenciaService = new PersistenciaService();


    public ArrayList<Livro> getLivros() {
        return acervoLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.acervoLivros = livros;
    }

    public void cadastrarLivro(String isbn, String titulo, String autor, String editora, String genero, int totalPaginas){
        Livro livro = new Livro(isbn, titulo, autor, editora, genero, totalPaginas);
        BibliotecaService.todosISBNCadastrados.add(isbn); // Renba
        System.out.println(BibliotecaService.todosISBNCadastrados);
        acervoLivros = persistenciaService.lerLivrosPersistidos();
        getLivros().add(livro);
        persistenciaService.persistirEntidade(this.acervoLivros);
    }

    public void removerLivro(String isbn){
        Livro livroR = buscarLivro(isbn);
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este livro?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().remove(livroR);
            persistenciaService.persistirEntidade(this.acervoLivros);
        }
    }

    public void apagarListaLivros(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir todos os livros do acervo?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().clear();
            File file = new File("livrosPersistidos.dat");
            if (file.delete()) {
                System.out.println("Arquivo deletado com sucesso");
            }

            JOptionPane.showMessageDialog(null, "Operação Finalizada. Não há nenhum livro no acervo.");
        }
    }

    public void atualizarLivro(String isbn){
        String msg = "Qual informação deseja atualizar? \n 1 - Título\n 2 - Autor\n 3 - Editora\n 4 - Gênero\n " +
                "5 - Quantidade de Páginas";
        Livro livro = buscarLivro(isbn);
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));

        if (caminho == 1) {
            livro.setTitulo(JOptionPane.showInputDialog("Digite o novo título: "));
            JOptionPane.showMessageDialog(null, "Título Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 2) {
            livro.setAutor(JOptionPane.showInputDialog("Informe o(a) autor(a): "));
            JOptionPane.showMessageDialog(null,"Autor(a) Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 3) {
            livro.setEditora(JOptionPane.showInputDialog("Digite a editora:"));
            JOptionPane.showMessageDialog(null,"Editora Atualizada!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 4) {
            livro.setGenero(JOptionPane.showInputDialog("Informe o gênero: "));
            JOptionPane.showMessageDialog(null,"Gênero Atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }else if (caminho == 5){
            livro.setTotalPaginas(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de páginas:")));
            JOptionPane.showMessageDialog(null,"Total de páginas atualizado!");
            persistenciaService.persistirEntidade(this.acervoLivros);
        }
    }

    public String listarLivros(){
        if (this.acervoLivros.isEmpty()){
            acervoLivros = persistenciaService.lerLivrosPersistidos();
        }
        if (this.acervoLivros.isEmpty() || this.acervoLivros == null){
            return "Não há livros cadastrados.";
        }
        return acervoLivros.toString();
    }



    public Livro buscarLivro(String isbn){
        for (Livro livro: this.acervoLivros){
            if (isbn.equals(livro.getISBN())){
                JOptionPane.showMessageDialog(null, livro);
                this.livro = livro;
                break;
            }
        }

        if (this.livro == null){
            JOptionPane.showMessageDialog(null,"Desculpe, não foi possível localizar este livro.");
        }
        return this.livro;
    }


    public int capturarQuantidadeLivros() { // ============== Renba: Service capturar quantidade para devolver a LIVRO
        int quantidadeLivros = 123;

        if (this.acervoLivros.isEmpty()) {
            acervoLivros = persistenciaService.lerLivrosPersistidos();
        }

        quantidadeLivros = acervoLivros.size();
        System.out.println("Size de Acervo Livros: " + quantidadeLivros);
        return quantidadeLivros;
    }


    public String listarLivrosRenba(){
        System.out.println("Entrou em Listar Livros");
        String retornoDeLista = String.valueOf(0); // Renba
        if (this.acervoLivros.isEmpty()){
            this.acervoLivros = persistenciaService.lerLivrosPersistidos();
            System.out.println("LivroService Linha 85");
            // Renba
            if (this.acervoLivros.isEmpty()) {
                retornoDeLista = "0";

            } else {
                retornoDeLista = this.acervoLivros.toString();
            }
        } else {
            retornoDeLista = this.acervoLivros.toString();
        }

        //return acervoLivros.toString(); // Renba: Exclui a implantação da Joyce
        System.out.println("Retorno da Lista" + retornoDeLista);
        return retornoDeLista;
    }


}

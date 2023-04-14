package biblioteca.services;

import biblioteca.model.Livro;
import biblioteca.validations.Validador;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;


public class LivroService {
    private PersistenciaService persistenciaService = new PersistenciaService();
    private Livro livro;
    private ArrayList<Livro> acervoLivros = new ArrayList<>();
    public ArrayList<String> todosISBN = persistenciaService.lerISBNPersisitidos();


    public ArrayList<Livro> getLivros() {
        return acervoLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.acervoLivros = livros;
    }

    public ArrayList<String> getTodosISBN() {
        System.out.println("GET TODOS ISBN LIVROSERVICE " + todosISBN);
        return todosISBN;
    }

    public void apagarTodosISBN() {
        getTodosISBN().clear();
        todosISBN = new ArrayList<>();

        File file = new File("isbnPersistidos.dat");
        if (file.delete()) {
            System.out.println("Arquivo deletado com sucesso");
        }
    }


    public void cadastrarLivro(String isbn, String titulo, String autor, String editora, String genero, int totalPaginas){
        Livro livro = new Livro(isbn, titulo, autor, editora, genero, totalPaginas);
        acervoLivros = persistenciaService.lerLivrosPersistidos();
        todosISBN = persistenciaService.lerISBNPersisitidos();
        getLivros().add(livro);
        getTodosISBN().add(isbn);
        persistenciaService.persistirEntidade(this.acervoLivros);
        persistenciaService.persistirEntidade(this.todosISBN);

        System.out.println(this.todosISBN);
    }


    public void removerLivro(String isbn){
        Livro livroR = buscarLivro(isbn);
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este livro?");
        if (confirma == JOptionPane.YES_OPTION){
            getTodosISBN().remove(isbn);
            getLivros().remove(livroR);
            persistenciaService.persistirEntidade(this.acervoLivros);
            persistenciaService.persistirEntidade(this.todosISBN);
        }
    }


    public void apagarListaLivros(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir todos os livros do acervo?");
        if (confirma == JOptionPane.YES_OPTION){
            getLivros().clear();
            apagarTodosISBN();

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

        Validador validador = new Validador();
        int caminho;

        do {
            try {
                caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                caminho = 9;
            }
        } while (!validador.validarInputInteger(caminho));


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
        } else {
            JOptionPane.showMessageDialog(null, "Opção não reconhecida.");
        }
    }


    public String listarLivros(){
        if (this.acervoLivros.isEmpty()){
            acervoLivros = persistenciaService.lerLivrosPersistidos();
        }
        if (this.acervoLivros.isEmpty() || this.acervoLivros == null){
            return "Não há livros cadastrados.";
        }
        return acervoLivros.toString().replaceAll("\\[|\\,|\\]", "\n");
    }


    public Livro buscarLivro(String isbn){
        acervoLivros = persistenciaService.lerLivrosPersistidos(); // Renba > Atent LS 102
        System.out.println("Recebendo ISBN: " + isbn);
        System.out.println("THIS.ACERVOLIVROS > " + this.acervoLivros); // Renba

        for (Livro livro: acervoLivros){ // Renba
        //for (Livro livro: this.acervoLivros){
            if (isbn.equals(livro.getISBN())){
                JOptionPane.showMessageDialog(null, livro);
                this.livro = livro;
                break;
            }
        }

        if (this.livro == null){
            JOptionPane.showMessageDialog(null,"Desculpe, não foi possível localizar este livro.");
        }
        System.out.println("Resultado de BuscarLivro " + this.livro);
        return this.livro;
    }



}

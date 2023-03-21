package biblioteca.telas;

import biblioteca.model.Biblioteca;

import javax.swing.*;

public class MenuPrincipal {

    protected Biblioteca biblioteca = new Biblioteca();

    private String msg ="Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Livros\n 2 - Cadastros\n" +
                " 3 - Emprestimos\n";

    public void menuPrincipal(){
        int caminho = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (caminho) {
            case 1: //Menu livros
                MenuLivro menuLivro = new MenuLivro();
                menuLivro.menuLivro();
                break;
            case 2: // Menu cadastros
                MenuCadastro menuCadastro = new MenuCadastro();
                menuCadastro.menuCadastro();
                break;
            case 3: // menu emprestimos
                MenuEmprestimos menuEmprestimos = new MenuEmprestimos();
                menuEmprestimos.menuEmprestimos();
                break;
        }
    }
}

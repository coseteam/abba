package biblioteca.telas;

import javax.swing.*;

public class MenuPrincipal {


    private String msg ="Menu Biblioteca\n Escolha uma das opções abaixo: \n 1 - Livros\n 2 - Cadastros\n" +
                " 3 - Emprestimos\n";

    public void menuPrincipal(){

        String input = JOptionPane.showInputDialog(msg);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Saindo do sistema");
            System.exit(0);
        }
        int caminho = Integer.parseInt(input);
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

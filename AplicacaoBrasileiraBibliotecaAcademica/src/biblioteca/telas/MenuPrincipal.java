package biblioteca.telas;


import biblioteca.services.BibliotecaService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuPrincipal {
    public BibliotecaService todaBiblioteca = new BibliotecaService(); // Renba
    public Validador validacao = new Validador();


    private String msg ="Menu Biblioteca\n Escolha uma opção: \n 1 - Livros\n 2 - Alunos\n" +
                " 3 - Empréstimos\n";

    public void menuPrincipal(){

        String input = JOptionPane.showInputDialog(msg);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Encerrando Aplicação...");
            System.exit(0);
        }

        int caminho = Integer.parseInt(input);

        switch (caminho) {
            case 1 -> { //Menu livros
                MenuLivro menuLivro = new MenuLivro();
                menuLivro.menuLivro();
            }
            case 2 -> { // Menu cadastros
                MenuCadastro menuCadastro = new MenuCadastro();
                menuCadastro.menuCadastro();
            }
            case 3 -> { // Menu emprestimos
                MenuEmprestimos menuEmprestimos = new MenuEmprestimos();
                menuEmprestimos.menuEmprestimos();
            }
        }
    }

    public static void validaMenu(String input) {
        if (input == null) {
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.menuPrincipal();
        }

    }
}

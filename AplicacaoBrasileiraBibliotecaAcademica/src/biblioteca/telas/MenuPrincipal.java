package biblioteca.telas;


import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuPrincipal {
    //BibliotecaService todaBilioteca = new BibliotecaService(); Renba > Att HERE 12/04


    private String msg ="Menu Biblioteca\n Escolha uma opção: \n 1 - Livros\n 2 - Alunos\n" +
                " 3 - Empréstimos\n\n 9 - Encerrar\n";

    public void menuPrincipal(){
        Validador validador = new Validador();
        Integer input;

        do {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                input = 0;
            }
        } while (!validador.validarInputInteger(input));


//        if (input == 0) {
//            JOptionPane.showMessageDialog(null, "Encerrando Aplicação...");
//            System.exit(0);
//        }

        int caminho = input;

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
            case 9 -> {
                JOptionPane.showMessageDialog(null, "Encerrando Aplicação...");
                System.exit(0);
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção não reconhecida.");
                menuPrincipal();
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

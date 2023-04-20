package biblioteca.telas;


import biblioteca.validations.Validador;

import javax.swing.*;

public class MenuPrincipal {


    private String msg ="Escolha uma opção\n \n 1 - Livros\n 2 - Alunos\n" +
                " 3 - Empréstimos\n\n 0 - Encerrar\n";

    public void menuPrincipal(){
        Validador validador = new Validador();
        Integer input;


        do {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(null, msg, "ABBA", 3));
            } catch (Exception e) {
                input = 9;
            }
        } while (!validador.validarInputMenu(input));



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
            case 0 -> {
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


}

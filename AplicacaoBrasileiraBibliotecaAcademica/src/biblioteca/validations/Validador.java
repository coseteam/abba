package biblioteca.validations;

import biblioteca.services.LivroService;
import biblioteca.services.PersistenciaService;

import javax.swing.*;
import java.util.ArrayList;

public class Validador {

    // ================== Atributos
    Object input;
    public static String inputString = "Strings";
    public static Integer inputInteger = 1;
    public static ArrayList<String> allISBN;
    public static ArrayList<String> copiaISBN;
    private PersistenciaService persistenciaService = new PersistenciaService();


    // ================== Construtor
    public Validador() {
        LivroService livroService = new LivroService();

        inputString = "Strings";
        allISBN = (ArrayList<String>) livroService.getTodosISBN();
        copiaISBN = (ArrayList<String>) livroService.todosISBN.clone();
        if (allISBN == null || allISBN.isEmpty()) {
            allISBN = livroService.getTodosISBN();
        }
    }


    // ================== Métodos
    public static boolean validarInputString(Object currentInput) { // VALIDAR STRING
        boolean checkString = true;

        if (inputString.getClass() == currentInput.getClass()) {
            if(currentInput == "" || ((String) currentInput).isBlank() || ((String) currentInput).length() < 3) {
                checkString = false;
            }
        } else {
            checkString = false;
        }

        //System.out.println("Check String >>> " + checkString);
        return checkString;
    }


    public static boolean validarInputInteger(Object currentInput) { // VALIDAR INTEIROS
        boolean checkInteger = true;

        if (inputInteger.getClass() == currentInput.getClass()) {
            //System.out.println("INTEGER MESMA CLASSE");
            if (((Integer) currentInput).equals(0) || currentInput == null) {
                checkInteger = false;
            }
        } else {
            checkInteger = false;
        }

        //System.out.println("VALIDADOR: check int " + checkInteger);
        return checkInteger;
    }


    public static boolean validarInputStringNumerica(String currentInput) {
        boolean checkStrNum = true;

        if (currentInput.trim().isBlank() || !currentInput.matches("[0-9]+") ) {
            checkStrNum = false;
        }

        return checkStrNum;
    }


    public static boolean validarInputCPF(String currentCPF) {
        boolean checkCPF = true;

        if (currentCPF.isBlank()) {
            checkCPF = false;
        } else {
            //System.out.println("CPF not is blank: " + checkCPF);
            if (currentCPF.length() != 11 || !currentCPF.matches("[0-9]+")) {
                checkCPF = false;
                //System.out.println("matches and length: " + checkCPF);
            }

        }
        return checkCPF;
    }


    public static boolean validarInputISBN(String currentISBN) { // VALIDAR ISBN
        boolean checkISBN = true;
        //System.out.println("Passando por validação de input ISBN");

        if (currentISBN.isBlank()) {
            checkISBN = false;
        } else {
            //System.out.println("Não is blank: " + checkISBN);
            if (currentISBN.length() < 9 || !currentISBN.matches("[0-9]+")) {
                currentISBN.length();
                checkISBN = false;
                //System.out.println("matches and length: " + checkISBN);
            }

        }

        //System.out.println("valida ISBN >>> " + checkISBN);
        return checkISBN;
    }


    public static boolean validarNovoISBN(String currentISBN) { // VALIDAR ISBN
        boolean checkNovoISBN = true;

        if (currentISBN.isBlank()) {
            checkNovoISBN = false;
        } else {
            //System.out.println("Não is blank: " + checkNovoISBN);
            if (currentISBN.length() < 9 || !currentISBN.matches("[0-9]+")) {
                currentISBN.length();
                checkNovoISBN = false;
                //System.out.println("VALIDADOR: Novo ISBN matches and length: " + checkNovoISBN);
            } else {

                System.out.println("Lista ALLISBN: " + allISBN);
                if (allISBN.isEmpty()) {
                    checkNovoISBN = true;
                } else {
                    for (String isbn : allISBN) {
                        if (isbn.equals(currentISBN)) {
                            checkNovoISBN = false;
//                            System.out.println("Dentro do FOR: " + checkNovoISBN);
//                            System.out.println("Esse ISBN já existe");
                            JOptionPane.showMessageDialog(null, "Esse ISBN já Existe.");
                        }
                    }
                }

            }

        }

        //System.out.println("valida Novo ISBN >>> " + checkNovoISBN);
        return checkNovoISBN;
    }


    public static boolean validarNovoCPF(String currentCPF) {
        boolean checkCPF = true;

        if (currentCPF.isBlank()) {
            checkCPF = false;
        } else {
            //System.out.println("CPF not is blank: " + checkCPF);
            if (currentCPF.length() != 11 || !currentCPF.matches("[0-9]+")) {
                checkCPF = false;
                //System.out.println("matches and length: " + checkCPF);
            }

        }
        return checkCPF;
    }



    public static boolean validarInputMenu(Integer currentInput) {
        boolean checkOptionMenu = true;

        if (inputInteger.getClass() == currentInput.getClass()) {
            //System.out.println("INTEGER MESMA CLASSE");
            if ( currentInput == null) {
                checkOptionMenu = false;
            }
        } else {
            checkOptionMenu = false;
        }

        // System.out.println("VALIDADOR: check int " + checkOptionMenu);
        return checkOptionMenu;

    }

}

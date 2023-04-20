package biblioteca.validations;

import biblioteca.services.LivroService;
import biblioteca.services.PersistenciaService;

import javax.swing.*;
import java.util.ArrayList;

public class Validador {
    Object input;
    public static String inputString = "Strings";
    public static Integer inputInteger = 1;
    public static ArrayList<String> allISBN;
    public static ArrayList<String> copiaISBN;
    private PersistenciaService persistenciaService = new PersistenciaService();


    public Validador() {
        LivroService livroService = new LivroService();

        inputString = "Strings";
        allISBN = (ArrayList<String>) livroService.getTodosISBN();
        copiaISBN = (ArrayList<String>) livroService.todosISBN.clone();
        if (allISBN == null || allISBN.isEmpty()) {
            allISBN = livroService.getTodosISBN();
        }
    }


    public static boolean validarInputString(Object currentInput) {
        boolean checkString = true;

        if (inputString.getClass() == currentInput.getClass()) {
            if(currentInput == "" || ((String) currentInput).isBlank() || ((String) currentInput).length() < 3) {
                checkString = false;
            }
        } else {
            checkString = false;
        }


        return checkString;
    }


    public static boolean validarInputInteger(Object currentInput) {
        boolean checkInteger = true;

        if (inputInteger.getClass() == currentInput.getClass()) {
            if (((Integer) currentInput).equals(0) || currentInput == null) {
                checkInteger = false;
            }
        } else {
            checkInteger = false;
        }

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
            if (currentCPF.length() != 11 || !currentCPF.matches("[0-9]+")) {
                checkCPF = false;
                //System.out.println("matches and length: " + checkCPF);
            }

        }
        return checkCPF;
    }


    public static boolean validarInputISBN(String currentISBN) {
        boolean checkISBN = true;

        if (currentISBN.isBlank()) {
            checkISBN = false;
        } else {
            if (currentISBN.length() < 9 || !currentISBN.matches("[0-9]+")) {
                currentISBN.length();
                checkISBN = false;
            }

        }

        return checkISBN;
    }


    public static boolean validarNovoISBN(String currentISBN) {
        boolean checkNovoISBN = true;

        if (currentISBN.isBlank()) {
            checkNovoISBN = false;
        } else {
            if (currentISBN.length() < 9 || !currentISBN.matches("[0-9]+")) {
                currentISBN.length();
                checkNovoISBN = false;
            } else {

                System.out.println("Lista ALLISBN: " + allISBN);
                if (allISBN.isEmpty()) {
                    checkNovoISBN = true;
                } else {
                    for (String isbn : allISBN) {
                        if (isbn.equals(currentISBN)) {
                            checkNovoISBN = false;
                            JOptionPane.showMessageDialog(null, "Esse ISBN já Existe.");
                        }
                    }
                }

            }

        }

        return checkNovoISBN;
    }


    public static boolean validarNovoCPF(String currentCPF) {
        boolean checkCPF = true;

        if (currentCPF.isBlank()) {
            checkCPF = false;
        } else {
            if (currentCPF.length() != 11 || !currentCPF.matches("[0-9]+")) {
                checkCPF = false;
            }

        }
        return checkCPF;
    }



    public static boolean validarInputMenu(Integer currentInput) {
        boolean checkOptionMenu = true;

        if (inputInteger.getClass() == currentInput.getClass()) {
            if ( currentInput == null) {
                checkOptionMenu = false;
            }
        } else {
            checkOptionMenu = false;
        }

        return checkOptionMenu;

    }

}

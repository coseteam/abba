package biblioteca.validations;

import biblioteca.services.BibliotecaService;
import biblioteca.services.PersistenciaService;

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

        inputString = "Strings";
        allISBN = (ArrayList<String>) (BibliotecaService.todosISBNCadastrados);
        if (allISBN == null || allISBN.isEmpty()) {
            allISBN.add("010101");
        }
    }


    // ================== Métodos
    public static boolean validarInputString(Object currentInput) { // VALIDAR STRING
        boolean checkString = true;

        if (inputString.getClass() == currentInput.getClass()) {
            if(currentInput == "" || ((String) currentInput).isBlank()) {
                checkString = false;
            }
        } else {
            checkString = false;
        }

        System.out.println(checkString);
        return checkString;
    }


    public static boolean validarInputInteger(Object currentInput) { // VALIDAR INTEIROS
        boolean checkInteger = true;

        /*System.out.println(currentInput.getClass());
        System.out.println(inputInteger.getClass());*/

        if (inputInteger.getClass() == currentInput.getClass()) {
            if (((Integer) currentInput).equals(0)) {
                checkInteger = false;
            }
        } else {
            checkInteger = false;
        }

        System.out.println("check int " + checkInteger);
        return checkInteger;
    }


    public static boolean validarInputISBN(String inputISBN) { // VALIDAR ISBN
        boolean checkISBN = true;

        if (inputISBN.isBlank()) {
            checkISBN = false;
        } else {
            System.out.println("Não is blank: " + checkISBN);
            if (inputISBN.length() < 7) {
                inputISBN.length();
                checkISBN = false;
                System.out.println("matches and length: " + checkISBN);
            } else {

                if (allISBN.isEmpty()) {
                    checkISBN = true;
                } else {
                    for (String isbn : allISBN) {
                        if (isbn.equals(inputISBN)) {
                            checkISBN = false;
                            System.out.println("Dentro do FOR: " + checkISBN);
                        }
                    }
                }

            }

        }

        System.out.println("valida ISBN >>> " + checkISBN);
        return checkISBN;
    }








}

package biblioteca.validations;

public class Validador {

    // ================== Atributos
    Object input;
    static String inputString = "Strings";
    static Integer inputInteger = 1;


    // ================== Métodos
    public static boolean validarInputString(Object currentInput) { // VALIDAR STRING
        boolean checkString = true;

        /*System.out.println(currentInput.getClass());
        System.out.println(inputString.getClass());*/
        //System.out.println("Só tem espaços? >> " + ((String) currentIput).isBlank());

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










}

package biblioteca.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class ValidaData {

    public ValidaData() {

    }


    public boolean validarInputFormatoDatas(String currentData) {
        boolean checkFormatoData = true;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(currentData);
            checkFormatoData = true;

        } catch (ParseException ex) {
            checkFormatoData = false;
        }

        System.out.println("VALIDAÇÃO DE DATA =>  " + checkFormatoData);
        return checkFormatoData;
    }

}

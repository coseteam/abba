package biblioteca.telas;

import biblioteca.model.Emprestimo;
import biblioteca.services.EmprestimoService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class TelaDevolucaoLivro {
    public int codigo;


    public TelaDevolucaoLivro() {
        Validador validador = new Validador();
        EmprestimoService emprestimoService = new EmprestimoService();

        do {
            try {
                this.codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Empréstimo "));
            } catch (Exception err) {
                this.codigo = 0;
            }
        } while (!validador.validarInputInteger(this.codigo));


        //System.out.println("+++ Tela Devolucao 39 +++");

    }

}

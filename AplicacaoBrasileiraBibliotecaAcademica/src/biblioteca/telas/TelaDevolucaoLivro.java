package biblioteca.telas;

import biblioteca.model.Emprestimo;
import biblioteca.services.EmprestimoService;
import biblioteca.validations.Validador;

import javax.swing.*;

public class TelaDevolucaoLivro {
    public int codigo;

    private MenuEmprestimos menuEmprestimos = new MenuEmprestimos();


    public TelaDevolucaoLivro() {
        Validador validador = new Validador();
        EmprestimoService emprestimoService = new EmprestimoService();

        do {
            try {
                String s = JOptionPane.showInputDialog("Informe o Código do Empréstimo ");
                if (s != null) {
                    this.codigo = Integer.parseInt(s);
                } else {
                    menuEmprestimos.menuEmprestimos();
                }
            } catch (Exception err) {
                this.codigo = 0;
            }
        } while (!validador.validarInputInteger(this.codigo));


        //System.out.println("+++ Tela Devolucao 39 +++");

    }

}

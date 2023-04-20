package biblioteca.telas;

import javax.swing.*;
import java.awt.*;

public class TelaBoasVindas extends JDialog {

    public TelaBoasVindas() {
        setPreferredSize(new Dimension(500, 500));
        setTitle("Aplicação Brasileira para Bibliotecas Acadêmicas");
        pack();
        setModal(true);
        setLocationRelativeTo(null);

        // cria o painel e coloca texto
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Aplicação Brasileira para Bibliotecas Acadêmicas\n");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // add painel na janela
        add(panel);

        // temporizador para fechar a janela após 2 secs
        Timer timer = new Timer(3000, e -> dispose());
        timer.setRepeats(false);
        timer.start();

        // Exibe a janela
        setVisible(true);
    }
}

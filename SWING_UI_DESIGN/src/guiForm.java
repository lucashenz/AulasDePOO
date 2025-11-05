import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiForm {
    private JPanel tela;
    private JButton botaoOk;
    private JTextArea campoTexto;
    private JTextField campoDigita;


    // é preciso programar um get para receber o painel em outros metodos.
    public JPanel getPainel() {
        return tela;
    }

    public guiForm() { //lambda
        botaoOk.addActionListener(e -> campoTexto.append(campoDigita.getText()+"\n"));
    }
   /* public guiForm() {
        botaoOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String texto = campoDigita.getText();
                campoTexto.append(texto + "\n");
            }
        });
    } */

}





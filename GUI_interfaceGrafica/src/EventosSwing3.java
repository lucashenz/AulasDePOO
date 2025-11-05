import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosSwing3 extends JFrame {

    // Componentes principais
    private JTextField campoTexto;
    private JButton botaoOK, botaoLimpa;
    private JLabel mensagem;

    public EventosSwing3() {
        super();
        campoTexto = new JTextField(30);
        botaoOK = new JButton("OK");
        botaoLimpa = new JButton("Limpa");
        mensagem = new JLabel();
        FlowLayout layout = new FlowLayout();
        JPanel painel = new JPanel();
        painel.setLayout(layout);
        painel.add(campoTexto);
        painel.add(botaoOK);
        painel.add(botaoLimpa);
        painel.add(mensagem);
        this.add(painel);
        this.setSize(800,600);
        this.setTitle("Tratamento de eventos - Swing - 3");

        // Tratamento de eventos
        // Anonymous inner class para tratar cada evento
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        botaoOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText();
                mensagem.setForeground(Color.BLUE);
                mensagem.setText("Texto digitado: "+texto);
            }
        });
        botaoLimpa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventosSwing3 janela = new EventosSwing3();
    }

}

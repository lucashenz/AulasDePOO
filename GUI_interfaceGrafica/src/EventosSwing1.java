import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosSwing1 extends JFrame {

    // Componentes principais
    private JTextField campoTexto;
    private JButton botaoOK, botaoLimpa;
    private JLabel mensagem;

    public EventosSwing1() {
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
        this.setTitle("Tratamento de eventos - Swing - 1");

        // Tratamento de eventos
        // Inner class para tratar eventos
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        TratadorEventos tratadorEventos = new TratadorEventos();
        botaoOK.addActionListener(tratadorEventos);
        botaoLimpa.addActionListener(tratadorEventos);

        this.setVisible(true);
    }

    // Inner class - classe interna para tratar eventos
    class TratadorEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == botaoOK) {
                String texto = campoTexto.getText();
                mensagem.setForeground(Color.BLUE);
                mensagem.setText("Texto digitado: "+texto);
            }
            else if(e.getSource() == botaoLimpa) {
                campoTexto.setText("");
            }
        }

    }

    public static void main(String[] args) {
        EventosSwing1 janela = new EventosSwing1();
    }

}


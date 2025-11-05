import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A propria aplicacao trata eventos
public class EventosSwing2 extends JFrame implements ActionListener {

    // Componentes principais
    private JTextField campoTexto;
    private JButton botaoOK, botaoLimpa;
    private JLabel mensagem;

    public EventosSwing2() {
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
        this.setTitle("Tratamento de eventos - Swing - 2");

        // Tratamento de eventos
        // A propria aplicacao trata eventos
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        botaoOK.addActionListener(this);
        botaoLimpa.addActionListener(this);

        this.setVisible(true);
    }

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

    public static void main(String[] args) {
        EventosSwing2 janela = new EventosSwing2();
    }

}

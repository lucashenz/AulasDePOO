import javax.swing.*;
import java.awt.*;

public class EventosSwing4 extends JFrame {

    // Componentes principais
    private JTextField campoTexto;
    private JButton botaoOK, botaoLimpa;
    private JLabel mensagem;

    public EventosSwing4() {
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
        this.setTitle("Tratamento de eventos - Swing - 4");

        // Tratamento de eventos
        // Expressao Lambda para tratar cada evento
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        botaoOK.addActionListener(e -> {
                String texto = campoTexto.getText();
                mensagem.setForeground(Color.BLUE);
                mensagem.setText("Texto digitado: "+texto);
        });
        botaoLimpa.addActionListener(e -> campoTexto.setText(""));

        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventosSwing4 janela = new EventosSwing4();
    }

}

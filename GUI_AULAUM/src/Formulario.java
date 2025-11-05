import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame implements ActionListener {
    // Componentes que serao usados na aplicacao
    private JTextField campoTexto;
    private JButton botaoEnviar, botaoTerminar;
    private JTextArea areaTexto;

    public Formulario() {
        super();
        setTitle("Formulario de mensagens");
        setSize(900,900);

        // Painel principal da janela
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        // Painel intermediario para o texto inicial
        JPanel painelRotulo = new JPanel();
        FlowLayout layoutRotulo = new FlowLayout(FlowLayout.LEFT);
        painelRotulo.setLayout(layoutRotulo);
        JLabel rotulo = new JLabel("Envie a sua mensagem");
        painelRotulo.add(rotulo);

        // Painel intermediario para o campo de texto
        JPanel painelCampoTexto = new JPanel();
        FlowLayout layoutCampoTexto = new FlowLayout(FlowLayout.LEFT);
        painelCampoTexto.setLayout(layoutCampoTexto);
        JLabel labelMensagem = new JLabel("Mensagem");
        campoTexto = new JTextField(40);
        painelCampoTexto.add(labelMensagem);
        painelCampoTexto.add(campoTexto);

        // Painel intermediario para os botoes
        JPanel painelBotoes = new JPanel();
        FlowLayout layoutBotoes = new FlowLayout(FlowLayout.RIGHT);
        painelBotoes.setLayout(layoutBotoes);
        botaoEnviar = new JButton("Enviar");
        botaoTerminar = new JButton("Terminar");
        painelBotoes.add(botaoEnviar);
        painelBotoes.add(botaoTerminar);

        // Painel intermediario para mensagem
        JPanel painelRotuloMensagens = new JPanel();
        FlowLayout layoutMensagens = new FlowLayout(FlowLayout.LEFT);
        painelRotuloMensagens.setLayout(layoutMensagens);
        JLabel labelMensagens = new JLabel("Mensagens");
        painelRotuloMensagens.add(labelMensagens);

        // Painel intermediario para a area de texto (com scroll)
        areaTexto = new JTextArea(5,47);
        JScrollPane painelAreaTexto = new JScrollPane(areaTexto);

        // Montagem do painel principal
        painelPrincipal.add(painelRotulo);
        painelPrincipal.add(painelCampoTexto);
        painelPrincipal.add(painelBotoes);
        painelPrincipal.add(painelRotuloMensagens);
        painelPrincipal.add(painelAreaTexto);

        // Adicao do painel principal na janela
//        getContentPane().add(painelPrincipal);
        this.add(painelPrincipal);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botaoEnviar.addActionListener(this);
        botaoTerminar.addActionListener(this);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoEnviar) {
            String txt = campoTexto.getText();
            this.setTitle(txt);

            this.areaTexto.append(txt);
        } else if(e.getSource() == botaoTerminar) {
            this.setVisible(false);
        }
    }
}


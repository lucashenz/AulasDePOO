import javax.swing.*;

public class minhaJanela extends JFrame {

    private guiForm form;

    public minhaJanela() {
        super();
        setSize(800, 400);
        setVisible(true);
        setTitle("Minha Janela");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new guiForm();
        add(form.getPainel());
    }

}

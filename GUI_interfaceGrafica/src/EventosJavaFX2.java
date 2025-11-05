import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// A propria aplicacao trata eventos
public class EventosJavaFX2 extends Application implements EventHandler<ActionEvent> {

    // Componentes principais
    private TextField campoTexto;
    private Button botaoOK;
    private Button botaoLimpa;
    private Text mensagem;

    @Override
    public void start(Stage containerPrincipal) {
        campoTexto = new TextField();
        campoTexto.setPrefColumnCount(30);
        botaoOK = new Button("OK");
        botaoLimpa = new Button("Limpa");
        mensagem = new Text();
        FlowPane layout = new FlowPane();
        layout.getChildren().add(campoTexto);
        layout.getChildren().add(botaoOK);
        layout.getChildren().add(botaoLimpa);
        layout.getChildren().add(mensagem);
        Scene painel = new Scene(layout, 800, 600);
        containerPrincipal.setScene(painel);
        containerPrincipal.setTitle("Eventos - JavaFX - 2");

        // Tratamento de eventos
        botaoOK.setOnAction(this);
        botaoLimpa.setOnAction(this);

        containerPrincipal.show();
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == botaoOK) {
            String texto = campoTexto.getText();
            mensagem.setFill(Color.BLUE);
            mensagem.setText("Texto digitado: " + texto);
        } else if (e.getSource() == botaoLimpa) {
            campoTexto.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

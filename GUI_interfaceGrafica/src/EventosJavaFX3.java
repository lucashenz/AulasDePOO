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

public class EventosJavaFX3 extends Application {

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
        containerPrincipal.setTitle("Eventos - JavaFX - 3");

        // Tratamento de eventos
        // Anonymous inner class para tratar cada evento
        botaoOK.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String texto = campoTexto.getText();
                mensagem.setFill(Color.BLUE);
                mensagem.setText("Texto digitado: " + texto);
            }
        });
        botaoLimpa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                campoTexto.setText("");
            }
        });

        containerPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

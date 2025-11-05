import eventos.swing.EventosSwing1;
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

public class EventosJavaFX1 extends Application {

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
        containerPrincipal.setTitle("Eventos - JavaFX - 1");

        // Tratamento de eventos
        // Inner class para tratar eventos
        TratadorEventos tratadorEventos = new TratadorEventos();
        botaoOK.setOnAction(tratadorEventos);
        botaoLimpa.setOnAction(tratadorEventos);

        containerPrincipal.show();
    }

    // Inner class - classe interna para tratar eventos
    class TratadorEventos implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if(e.getSource() == botaoOK) {
                String texto = campoTexto.getText();
                mensagem.setFill(Color.BLUE);
                mensagem.setText("Texto digitado: "+texto);
            }
            else if(e.getSource() == botaoLimpa) {
                campoTexto.setText("");
            }
        }
    }

        public static void main(String[] args) {
        launch(args);
    }

}

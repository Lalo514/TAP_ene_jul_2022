package  sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventoLoteria;


public class Loteria extends Stage implements EventHandler {
    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente, btnJugar;
    private Label lblTiempo;
    private GridPane gdPlantilla;
    private Image imgCarta;
    private Scene escena;

    private String[] arImagenes = {"barril.jpeg", "botella.jpeg", "catrin.jpeg", "chavorruco.jpeg", "concha.jpeg"};
    private Button[][] arBtnPlantilla = new Button[4][2];
    private Image imgCartaP;
    private ImageView imv;

    public Loteria() {
        CrearUI();
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAtras = new Button("Atras");
        btnAtras.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoLoteria());
        btnAtras.setPrefWidth(100);
        btnSiguiente = new Button("Siguiente");
        btnSiguiente.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hola desde un objecto anonnimo");
            }
        });
        btnSiguiente.setPrefWidth(100);
        lblTiempo = new Label("00:00");
        hBox1 = new HBox();
        hBox1.setSpacing(5);
        hBox1.getChildren().addAll(btnAtras, btnSiguiente, lblTiempo);

        gdPlantilla = new GridPane();
        crearPlantilla();
        //imgCarta = new Image("");
        hBox2 = new HBox();
        hBox2.getChildren().addAll(gdPlantilla);

        btnJugar = new Button("Jugar");
        btnJugar.addEventFilter(MouseEvent.MOUSE_CLICKED,this);
        btnJugar.setPrefWidth(250);

        vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox1, hBox2, btnJugar);
        escena = new Scene(vBox, 250, 430);

    }

    private void crearPlantilla() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                arBtnPlantilla[j][i] = new Button();
                imgCartaP = new Image("sample/images/" + arImagenes[0]);
                imv = new ImageView(imgCartaP);
                imv.setFitHeight(120);
                imv.setFitWidth(70);
                arBtnPlantilla[j][i].setGraphic(imv);
                gdPlantilla.add(arBtnPlantilla[j][i], i, j);


            }
        }
    }

    @Override
    public void handle(Event event) {
        System.out.println("H :)");
    }
}

























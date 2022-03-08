package sample.views;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Parseador extends Stage {

    private VBox vBox;
    private ToolBar tlbMenu;
    private TextArea txtEntrada, txtSalida;
    private Button btnAbrir;
    private FileChooser flcArchivo;
    private Scene escena;
    private Image imgAbrir;
    private ImageView imvAbrir;


    public Parseador() {
        CrearUI();
        this.setTitle("Traductor de codigo Morse");
        this.setScene(escena);
        this.show();

    }

    public void CrearUI() {
        vBox = new VBox();
        tlbMenu = new ToolBar();
        imgAbrir = new Image("sample/images/pngwing.png");
        imvAbrir = new ImageView(imgAbrir);
        imvAbrir.setFitWidth(25);
        imvAbrir.setFitHeight(25);
        btnAbrir = new Button();
        btnAbrir.setGraphic(imvAbrir);
        btnAbrir.setOnAction(event -> {
            //AQUI VA EL CCODIGO
            flcArchivo = new FileChooser();
            flcArchivo.setTitle("Buscar Archivos...");
            File archivo = flcArchivo.showOpenDialog(this);

        });
        tlbMenu.getItems().addAll(btnAbrir);
        //...
        txtEntrada = new TextArea();
        txtEntrada.setPromptText("Introduce el texto a parsear");
        txtSalida = new TextArea();
        txtSalida.setEditable(false);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(5));
        vBox.getChildren().addAll(tlbMenu,txtEntrada,txtSalida);
        escena = new Scene(vBox,500,300);
    }
}


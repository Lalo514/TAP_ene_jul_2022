package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.views.Loteria;
import sample.views.Parseador;

import java.io.IOException;

public class Main extends Application {

    private VBox vBox;
    private MenuBar mnbPrincpalMenu;
    private Menu menuCompetencia1, menuCompetencia2;
    private MenuItem mitLoteria, mitParseador;

    @Override
    public void start(Stage primaryStage) throws IOException {

        vBox = new VBox();
        mnbPrincpalMenu = new MenuBar();
        menuCompetencia1= new Menu("Competencia 1");
        menuCompetencia2= new Menu("Competencia 2");
        mnbPrincpalMenu.getMenus().addAll(menuCompetencia1,menuCompetencia2);


        mitLoteria = new MenuItem("Loteria ");
        mitLoteria.setOnAction(event ->EventoLoteria(1));
        mitParseador = new MenuItem("Codigo Morse");
        mitParseador.setOnAction(event -> EventoLoteria(2));

        menuCompetencia1.getItems().addAll(mitLoteria,mitParseador);

        vBox.getChildren().addAll(mnbPrincpalMenu);
        primaryStage.setTitle("H");
        primaryStage.setScene(new Scene(vBox,300, 275));
        primaryStage.show();
        primaryStage.setMaximized(true);

    }

    private void EventoLoteria(int i ) {
        switch (i){
            case 1: new Loteria(); break;
            case 2: new Parseador();break;
        }
    }

    public static void main(String[] args) {

        launch();

    }
}


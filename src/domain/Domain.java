package domain;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.border.Border;

/**
 * Created by John on 12/10/2016.
 */
public class Domain {

    private static Stage primaryStage;
    private static Scene scene;
    private static BorderPane borderPane;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Domain.primaryStage = primaryStage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Domain.scene = scene;
    }

    public static BorderPane getBorderPane() {
        return borderPane;
    }

    public static void setBorderPane(BorderPane borderPane) {
        Domain.borderPane = borderPane;
    }
}

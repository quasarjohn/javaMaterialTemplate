package control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * Created by John on 12/11/2016.
 */
public class EmployeeListFactory {

    @FXML
    private Circle circle;
    private HBox hBox;
    public EmployeeListFactory() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/List_Item_Employee.fxml"));
        loader.setController(this);
        try {
            hBox = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(getClass().getResourceAsStream("/resources/images/face4.jpg"));
        ImagePattern pattern = new ImagePattern(image);
        circle.setFill(pattern);
    }

    public HBox getItem() {
        hBox.setStyle("-fx-border-color: gray;-fx-border-width:0 0 0.5 0 ;");
        return hBox;
    }
}

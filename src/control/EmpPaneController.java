package control;

import com.sun.org.apache.xml.internal.security.Init;
import domain.Domain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by John on 12/11/2016.
 */
public class EmpPaneController implements Initializable{

    @FXML
    private VBox empListContainer;

    @FXML private VBox vb;
    @FXML private ScrollPane sp;
    @FXML private ScrollPane sp2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sp.setFitToWidth(true);
        sp2.setFitToWidth(true);
    }

    void populateEmpList() {
        for(int i = 0; i < 10; i++) {
            EmployeeListFactory emp = new EmployeeListFactory();
            HBox hb = emp.getItem();
            empListContainer.getChildren().addAll(hb);
        }
    }
}

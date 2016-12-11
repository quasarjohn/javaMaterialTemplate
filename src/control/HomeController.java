package control;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import domain.Domain;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by John on 12/10/2016.
 */
public class HomeController implements Initializable{

   @FXML private JFXDrawer drawer;
   @FXML private JFXHamburger hamburger;
   @FXML private BorderPane borderpane, body;

   private FXMLLoader leftDrawerLoader;
    public HomeController() {
        inflateDrawer();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDrawer();
        loadListeners();
        inflatePanes();
    }

    private void inflateDrawer() {
        leftDrawerLoader = new FXMLLoader(getClass().getResource("/view/LeftDrawer.fxml"));
        leftDrawerLoader.setController(this);
    }

    @FXML private HBox drawerItem1;
    @FXML private HBox drawerItem2;
    @FXML private HBox drawerItem3;
    @FXML private HBox drawerItem4;
    private ArrayList<HBox> drawerItems = new ArrayList<>();

    private void loadDrawer() {
        try {
            VBox leftDrawer = leftDrawerLoader.load();
            drawer.setSidePane(leftDrawer);
        } catch (IOException e) {
        }

        drawerItems.add(drawerItem1);
        drawerItems.add(drawerItem2);
        drawerItems.add(drawerItem3);
        drawerItems.add(drawerItem4);
    }

    public void listenToItem1() {
        resetDrawerItemFocus();
        focusItem(drawerItem1);
    }

    public void listenToItem2() {
        resetDrawerItemFocus();
        focusItem(drawerItem2);
    }

    public void listenToItem3() {
        resetDrawerItemFocus();
        focusItem(drawerItem3);
        body.setCenter(empPane);
        Platform.runLater(()-> {
            empPaneController.populateEmpList();
        });

        Domain.setBorderPane(body);
    }

    public void listenToItem4() {
        resetDrawerItemFocus();
        focusItem(drawerItem4);
    }

    private void resetDrawerItemFocus() {
        for(HBox item : drawerItems) {
            item.setStyle("-fx-background-color:white");
        }
    }

    private void focusItem(HBox hBox) {
        hBox.setStyle("-fx-background-color:#c9a2dd");
    }

    private void loadListeners() {
        hamburger.setOnMouseClicked(e->{
            if(drawer.isShown()) {
                drawer.close();
            }
            else {
                drawer.open();
            }
        });

        borderpane.setOnMouseClicked(e -> {
            if(drawer.isShown()) {
                drawer.close();
            }
        });
    }

    private EmpPaneController empPaneController;
    private HBox empPane;
    private void inflatePanes() {
        FXMLLoader employeesPaneLoader = new FXMLLoader(getClass().getResource("/view/Employees.fxml"));
        empPaneController = new EmpPaneController();
        employeesPaneLoader.setController(empPaneController);
        try {
            empPane = employeesPaneLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

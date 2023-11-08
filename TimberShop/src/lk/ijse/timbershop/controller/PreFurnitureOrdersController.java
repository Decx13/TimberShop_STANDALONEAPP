package lk.ijse.timbershop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PreFurnitureOrdersController {
    public AnchorPane preOrderPane;
    public TableView tblLoadOrder;
    public TableColumn clmReqId;
    public TableColumn clmFurnitureId;
    public TableColumn clmCustomerId;
    public TableColumn clmReqDate;
    public TableColumn clmPrice;

    public void backtoFurniture(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) preOrderPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/FurnitureForm.fxml"))));

    }
}

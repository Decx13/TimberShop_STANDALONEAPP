package lk.ijse.timbershop.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.timbershop.view.tm.ItemTm;

import java.io.IOException;
import java.sql.SQLException;

public class MainWindowController {
    public AnchorPane mainPane;
    public AnchorPane tablePane;

    public AnchorPane furniturePane;
    private TableColumn clmCode;
    private TableColumn clmName;
    private TableColumn clmQty;
    private ChoiceBox<ItemTm> tblAvailableStock;


    public void signOut(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) mainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.setTitle("LOGIN HERE");

    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/CustomerForm.fxml"));
        tablePane.getChildren().clear();
        tablePane.getChildren().add(node);

    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/EmployeeForm.fxml"));
        tablePane.getChildren().clear();
        tablePane.getChildren().add(node);

    }

    public void supplierOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/SupplierForm.fxml"));
        tablePane.getChildren().clear();
        tablePane.getChildren().add(node);
    }

    public void itemOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/ItemForm.fxml"));
        tablePane.getChildren().clear();
        tablePane.getChildren().add(node);
    }

    public void orderFormOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage=(Stage) mainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderForm.fxml"))));
        stage.setTitle("ORDER HERE");



    }

    public void furnitureAction(ActionEvent actionEvent) throws IOException {
        //Navigation.navigate(Routes.furniture,furniturePane);
        Stage stage=(Stage) mainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/FurnitureForm.fxml"))));
        stage.setTitle("Furniture Site");

    }

    public void sellingDetailsAction(ActionEvent actionEvent) throws IOException {
       //Navigation.navigate(Routes.selling,furniturePane);
        Stage stage=(Stage) mainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SellingForm.fxml"))));
        stage.setTitle("Selling Details ");


    }


}

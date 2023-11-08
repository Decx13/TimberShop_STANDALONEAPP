package lk.ijse.timbershop.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import lk.ijse.timbershop.service.custom.OrderFormService;
import lk.ijse.timbershop.service.custom.impl.OrderFormServiceImpl;
import lk.ijse.timbershop.to.IncomeTM;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.view.tm.ItemTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderFormController{


    public AnchorPane orderPane;
    public AnchorPane tabPane;
    public TableColumn clmCode;
    public TableColumn clmName;
    public TableColumn clmQty;
    public TableView tblAvailableStock;
    private OrderFormService orderFormService;

    public void initialize(){

        orderFormService=new OrderFormServiceImpl();
        setTable();
    }
    public void backToMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) orderPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");

    }

    public void customerOrderAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("../view/CustomerOrder.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);
    }

    public void supplierOrderAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("../view/SupplierOrder.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);

    }

    public void setTable(){
        this.clmCode.setCellValueFactory(new PropertyValueFactory<ItemTm,String >("Itemode"));
        this.clmName.setCellValueFactory(new PropertyValueFactory<ItemTm,String>("Name"));
        this.clmQty.setCellValueFactory(new PropertyValueFactory<ItemTm,String>("Qty"));

        try {
            ObservableList<ItemTm> list = orderFormService.getItemDetails();
            tblAvailableStock.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
            /*for(ItemTm Ob : list) {
                tblAvailableStock.setItems(list);
            }*/

    }


}

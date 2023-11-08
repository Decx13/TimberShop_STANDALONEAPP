package lk.ijse.timbershop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.timbershop.service.custom.ReqFurnitureService;
import lk.ijse.timbershop.service.custom.impl.ReqFurnitureServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.ReqFurniture;
import lk.ijse.timbershop.to.Supplier;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;
import lk.ijse.timbershop.view.tm.ItemTm;
import lk.ijse.timbershop.view.tm.ReqFurnitureTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;



public class FurnitureFormController {
    public AnchorPane furniturePane;
    public AnchorPane tabPane;
    public TextField txtId;
    public TextField txtCustomerId;
    public TextField txtFurnitureId;
    public TextField txtPrice;
  
    public TextField reqDate;
    public JFXDatePicker txtDate;
    private ReqFurnitureService reqFurnitureService;

    public void initialize(){
        reqFurnitureService=new ReqFurnitureServiceImpl();
    }


    public void backtMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) furniturePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }

    public void preOrderAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/PreFurnitureOrders.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);
    }

    public void addSampleAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/AddSampleForm.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);
    }


    public void addReqFurnitureAction(ActionEvent actionEvent) {

        boolean b=Regex.isTextFieldValid(TextFields.ID,txtId.getText());
        if(!b){
            new Alert(Alert.AlertType.WARNING,"Invalid ReqID").show();
            return;
        }
        boolean c=Regex.isTextFieldValid(TextFields.DOUBLE,txtPrice.getText());
        if(!c){
            new Alert(Alert.AlertType.WARNING,"Invalid Price").show();
            return;
        }
        boolean d=Regex.isTextFieldValid(TextFields.ID,txtCustomerId.getText());
        if(!d){
            new Alert(Alert.AlertType.WARNING,"Invalid CustomerID").show();
            return;
        }
        String ReqId = this.txtId.getText();
        String FurnitureId = this.txtFurnitureId.getText();
        String CustomerId = this.txtCustomerId.getText();
        LocalDate Date=this.txtDate.getValue();
        LocalDate ReqDate= LocalDate.parse(this.reqDate.getText());
        double Price= Double.parseDouble(this.txtPrice.getText());

        ReqFurniture reqFurniture = new ReqFurniture(ReqId, FurnitureId, CustomerId, Date,ReqDate,Price);
        try {
            boolean isAdded = reqFurnitureService.add(reqFurniture);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Request Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }
    public void searchfromId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String ReqId=this.txtId.getText();
        System.out.println(ReqId);
        try{
            ReqFurniture reqFurniture=reqFurnitureService.search(ReqId);
            System.out.println(reqFurniture==null);
            if (reqFurniture!=null){
                this.fillData(reqFurniture);
            }
        } catch (ClassNotFoundException | SQLException var4){
            throw new RuntimeException(var4);
        }
    }
    private void fillData(ReqFurniture reqFurniture){
        System.out.println(reqFurniture.getFurnitureId());
        txtId.setText(reqFurniture.getReqId());
        txtFurnitureId.setText(reqFurniture.getFurnitureId());
        txtCustomerId.setText(reqFurniture.getCustomerId());
       txtDate.setValue(reqFurniture.getDate());
        reqDate.setText(String.valueOf(reqFurniture.getReqDate()));

    }
    /*public void setTable(){
        this.clm.setCellValueFactory(new PropertyValueFactory<ItemTm,String >("Itemode"));
        this.clmName.setCellValueFactory(new PropertyValueFactory<ItemTm,String>("Name"));
        this.clmQty.setCellValueFactory(new PropertyValueFactory<ItemTm,String>("Qty"));

        try {
            ObservableList<ReqFurnitureTm> list = ReqFurnitureModel.getReqetails();
            tblAvailableStock.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
            /*for(ItemTm Ob : list) {
                tblAvailableStock.setItems(list);
            }*/


    public void updateReqFurniture(ActionEvent actionEvent) {
        String ReqId=txtId.getText();
        String FurnitureId=txtFurnitureId.getText();
        String CustomerId=txtCustomerId.getText();
        LocalDate Date=txtDate.getValue();
        LocalDate ReqDate= LocalDate.parse(reqDate.getText());
        double Price= Double.parseDouble(txtPrice.getText());
        ReqFurniture reqFurniture=new ReqFurniture(ReqId,FurnitureId,CustomerId,Date,ReqDate,Price);
        try{
            boolean isUpdate= reqFurnitureService.updateRequest(reqFurniture);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Requested Furniture Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void deletereqfurniture(ActionEvent actionEvent) {
        try{
            boolean isDeleted=reqFurnitureService.deleteRequest(txtId.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Requested Furniture Deleted!", new ButtonType[0])).show();
            }else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch (ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void idRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ID,(JFXTextField) txtId);
    }

    public void fIdRelease(KeyEvent keyEvent) {
        //Regex.setTextColor(TextFields.ID,(JFXTextField)txtFurnitureId);
    }

    public void cIdRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ID,(JFXTextField) txtCustomerId);
    }

    public void priceRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.DOUBLE,(JFXTextField) txtPrice);
    }
}

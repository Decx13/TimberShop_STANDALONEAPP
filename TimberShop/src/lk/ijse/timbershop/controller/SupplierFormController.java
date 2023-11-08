package lk.ijse.timbershop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import lk.ijse.timbershop.service.custom.SupplierService;
import lk.ijse.timbershop.service.custom.impl.SupplierServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.Supplier;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class SupplierFormController {
    public AnchorPane supplierPane;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtNum;
    private SupplierService supplierService;

    public void initialize(){
        supplierService=new SupplierServiceImpl();
    }
    public void backtoMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) supplierPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }

    public void addSupplierAction(ActionEvent actionEvent) {
        boolean a=Regex.isTextFieldValid(TextFields.ADDRESS,txtAddress.getText());
        if(!a){
            new Alert(Alert.AlertType.WARNING,"Invalid Address").show();
            return;
        }
        boolean b=Regex.isTextFieldValid(TextFields.ID,txtId.getText());
        if(!b){
            new Alert(Alert.AlertType.WARNING,"Invalid Id").show();
            return;
        }
        boolean c=Regex.isTextFieldValid(TextFields.NAME,txtName.getText());
        if(!c){
            new Alert(Alert.AlertType.WARNING,"Invalid Name").show();
            return;
        }
        boolean d=Regex.isTextFieldValid(TextFields.PHONE,txtNum.getText());
        if(!d){
            new Alert(Alert.AlertType.WARNING,"Invalid Mobile Number").show();
            return;
        }
        String SupplierId = this.txtId.getText();
        String Name = this.txtName.getText();
        String Address = this.txtAddress.getText();
        String Number = this.txtNum.getText();
        Supplier supplier = new Supplier(SupplierId, Name, Address, Number);
        try {
            boolean isAdded = supplierService.add(supplier);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void searchfromId(ActionEvent actionEvent) {
        String SupplierId=this.txtId.getText();
        try{
            Supplier supplier=supplierService.search(SupplierId);
            if (supplier!=null){
                this.fillData(supplier);
            }
        } catch (ClassNotFoundException | SQLException var4){
            throw new RuntimeException(var4);
        }
    }


    private void fillData(Supplier supplier){
        this.txtId.setText(supplier.getSupplierId());
        this.txtName.setText(supplier.getName());
        this.txtAddress.setText(supplier.getAddress());
        this.txtNum.setText(supplier.getNumber());
    }

    public void updateSupplier(ActionEvent actionEvent) {
        String SupplierId=txtId.getText();
        String Name=txtName.getText();
        String Address=txtAddress.getText();
        String Number=txtNum.getText();
        Supplier supplier=new Supplier(SupplierId,Name,Address,Number);
        try{
            boolean isUpdate=supplierService.updateSupplier(supplier);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Supplier Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }

    }

    public void deleteSupplier(ActionEvent actionEvent) {
        try{
            boolean isDeleted= supplierService.deleteSupplier(txtId.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Supplier Deleted!", new ButtonType[0])).show();
            }else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch (ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void idRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ID,(JFXTextField)txtId);
    }

    public void nameRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,(JFXTextField) txtName);
    }

    public void addressRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ADDRESS,(JFXTextField) txtAddress);
    }

    public void numberRelese(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PHONE,(JFXTextField) txtNum);
    }
}

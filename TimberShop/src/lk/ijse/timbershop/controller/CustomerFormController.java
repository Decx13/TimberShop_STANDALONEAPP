package lk.ijse.timbershop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.timbershop.service.ServiceFactory;
import lk.ijse.timbershop.service.ServiceType;
import lk.ijse.timbershop.service.custom.CustomerService;
import lk.ijse.timbershop.service.custom.impl.CustomerServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerFormController {
    public AnchorPane customerPane;
    
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public JFXTextField txtNum;
    public JFXTextField txtId;
    private CustomerService customerService;

    public void initialize(){

        customerService = ServiceFactory.getInstance().getService(ServiceType.CUSTOMER);
    }

    public void backMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) customerPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }

    public void backtoMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) customerPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
    }

    public void btnAddCustomer(ActionEvent actionEvent) {
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
        String CustomerId = this.txtId.getText();
        String Name = this.txtName.getText();
        String Address = this.txtAddress.getText();
        String Number = this.txtNum.getText();
        Customer customer = new Customer(CustomerId, Name, Address, Number);
        try {
            boolean isAdded = customerService.add(customer);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void searchfromId(ActionEvent actionEvent) {
        String CustomerId=this.txtId.getText();
        try{
            Customer customer=customerService.search(CustomerId);
            if (customer!=null){
                this.fillData(customer);
            }
        } catch (ClassNotFoundException | SQLException var4){
            throw new RuntimeException(var4);
        }
    }
    private void fillData(Customer customer){
        this.txtId.setText(customer.getCustomerId());
        this.txtName.setText(customer.getName());
        this.txtAddress.setText(customer.getAddress());
        this.txtNum.setText(customer.getNumber());
    }


    public void updateCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String CustomerId=txtId.getText();
        String Name=txtName.getText();
        String Address=txtAddress.getText();
        String Number=txtNum.getText();
        Customer customer=new Customer(CustomerId,Name,Address,Number);
        try{
            boolean isUpdate=customerService.updateCustomer(customer);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void deleteCustomerAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try{
            boolean isDeleted=customerService.deleteCustomer(txtId.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted!", new ButtonType[0])).show();
            }else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch (ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }



    public void addressReleasedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ADDRESS,(JFXTextField) txtAddress);
    }

    public void nameReleaedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,(JFXTextField) txtName);
    }

    public void numberReleasedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PHONE,(JFXTextField) txtNum);
    }

    public void idReleaseAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ID,(JFXTextField) txtId);
    }
}
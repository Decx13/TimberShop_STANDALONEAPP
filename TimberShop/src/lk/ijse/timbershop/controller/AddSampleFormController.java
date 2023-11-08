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


import lk.ijse.timbershop.service.ServiceFactory;
import lk.ijse.timbershop.service.ServiceType;
import lk.ijse.timbershop.service.custom.AddSampleService;
import lk.ijse.timbershop.service.custom.impl.AddSampleServiceImpl;
import lk.ijse.timbershop.service.custom.impl.CustomerServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.Furniture;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class AddSampleFormController {


    public AnchorPane samplePane;
    public TextField txtId;
    public TextField txtStyle;
    public TextField txtName;
    public TextField txtPrice;

    private AddSampleService addSampleService;

    public void initialize(){

        addSampleService= ServiceFactory.getInstance().getService(ServiceType.ADDSAMPLE);
    }


    public void backtoFurniture(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) samplePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/FurnitureForm.fxml"))));
    }

    public void addSampleFurnitureAction(ActionEvent actionEvent) {
        boolean a=Regex.isTextFieldValid(TextFields.DOUBLE,txtPrice.getText());
        if(!a){
            new Alert(Alert.AlertType.WARNING,"Invalid Price").show();
            return;
        }
        boolean b=Regex.isTextFieldValid(TextFields.ID,txtId.getText());
        if(!b){
            new Alert(Alert.AlertType.WARNING,"Invalid FurnitureId").show();
            return;
        }
        boolean c=Regex.isTextFieldValid(TextFields.NAME,txtName.getText());
        if(!c){
            new Alert(Alert.AlertType.WARNING,"Invalid Name").show();
            return;
        }
        String FurnitureId = this.txtId.getText();
        String Name = this.txtName.getText();
        String Style = this.txtStyle.getText();
        double Price = Double.parseDouble(this.txtPrice.getText());
        Furniture furniture = new Furniture(FurnitureId, Name, Style, Price);
        try {
            boolean isAdded = addSampleService.add(furniture);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Furniture Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void searchfromId(ActionEvent actionEvent) {
        String FurnitureId=this.txtId.getText();
        try{
            Furniture furniture=addSampleService.search(FurnitureId);
            if (furniture!=null){
                this.fillData(furniture);
            }
        } catch (ClassNotFoundException | SQLException var4){
            throw new RuntimeException(var4);
        }
    }

    private void fillData(Furniture furniture){
        this.txtId.setText(furniture.getFurnitureId());
        this.txtName.setText(furniture.getName());
        this.txtStyle.setText(furniture.getStyle());
        this.txtPrice.setText(String.valueOf(furniture.getPrice()));
    }

    public void updateSampleFurniture(ActionEvent actionEvent) {
        String FurnitureId=txtId.getText();
        String Name=txtName.getText();
        String Style=txtStyle.getText();
        double Price= Double.parseDouble(txtPrice.getText());
        Furniture furniture=new Furniture(FurnitureId,Name,Style,Price);
        try{
            boolean isUpdate=addSampleService.updateFurniture(furniture);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Furniture Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void deleteFurniture(ActionEvent actionEvent) {
        try{
            boolean isDeleted=addSampleService.deleteFurniture(txtId.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Furniture Deleted!", new ButtonType[0])).show();
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

    public void nameRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,(JFXTextField)txtName);
    }

    public void priceRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.DOUBLE,(JFXTextField) txtPrice);
    }
}

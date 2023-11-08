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

import lk.ijse.timbershop.service.custom.ItemService;
import lk.ijse.timbershop.service.custom.impl.ItemServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class ItemFormController {
    public AnchorPane itemPane;
    public TextField txtCode;
    public TextField txtQty;
    public TextField txtName;
    public TextField txtPrice;
    private ItemService itemService;

    public void initialize(){

        itemService =new ItemServiceImpl();
    }

    public void backtoMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) itemPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }

    public void addItemAction(ActionEvent actionEvent) {
        boolean a=Regex.isTextFieldValid(TextFields.DOUBLE,txtPrice.getText());
        if(!a){
            new Alert(Alert.AlertType.WARNING,"Invalid Price").show();
            return;
        }
        boolean b=Regex.isTextFieldValid(TextFields.ID,txtCode.getText());
        if(!b){
            new Alert(Alert.AlertType.WARNING,"Invalid ItemCode").show();
            return;
        }
        boolean c=Regex.isTextFieldValid(TextFields.NAME,txtName.getText());
        if(!c){
            new Alert(Alert.AlertType.WARNING,"Invalid Name").show();
            return;
        }
        boolean d=Regex.isTextFieldValid(TextFields.INTEGER,txtQty.getText());
        if(!d){
            new Alert(Alert.AlertType.WARNING,"Invalid Qty").show();
            return;
        }
        String ItemCode = this.txtCode.getText();
        String Name = this.txtName.getText();
        int Qty = Integer.parseInt(this.txtQty.getText());
        double UnitPrice = Double.parseDouble(this.txtPrice.getText());
        Item item = new Item(ItemCode, Name, Qty, UnitPrice);
        try {
            boolean isAdded = itemService.add(item);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void searchfromId(ActionEvent actionEvent) {
        String ItemCode = this.txtCode.getText();

        try {
            Item item = itemService.search(ItemCode);
            if (item != null) {
                this.fillData(item);
            }

        } catch (ClassNotFoundException | SQLException var4) {
            throw new RuntimeException(var4);
        }
    }
    private void fillData(Item item) {
        this.txtCode.setText(item.getItemcode());
        this.txtName.setText(item.getName());
        this.txtQty.setText(String.valueOf(item.getQty()));
        this.txtPrice.setText(String.valueOf(item.getUnitprice()));
    }

    public void updateItem(ActionEvent actionEvent) {
        String Itemcode=txtCode.getText();
        String Name=txtName.getText();
        int Qty= Integer.parseInt(txtQty.getText());
        double Price= Double.parseDouble(txtPrice.getText());
        Item item=new Item(Itemcode,Name,Qty,Price);
        try{
            boolean isUpdate= itemService.updateItem(item);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void deleteItem(ActionEvent actionEvent) {
        try{
            boolean isDeleted=itemService.deleteItem(txtCode.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Deleted!", new ButtonType[0])).show();
            }else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch (ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void idRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ID,(JFXTextField) txtCode);
    }

    public void nameRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,(JFXTextField) txtName);
    }

    public void qtyRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.INTEGER,(JFXTextField) txtQty);
    }

    public void priceRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.DOUBLE,(JFXTextField) txtPrice);
    }
}

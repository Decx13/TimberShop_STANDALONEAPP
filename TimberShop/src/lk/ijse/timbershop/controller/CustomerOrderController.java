package lk.ijse.timbershop.controller;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.timbershop.service.custom.CustomerOrderPlaceService;
import lk.ijse.timbershop.service.custom.CustomerOrderService;
import lk.ijse.timbershop.service.custom.impl.CustomerOrderPlaceServiceImpl;
import lk.ijse.timbershop.service.custom.impl.CustomerOrderServiceImpl;
import lk.ijse.timbershop.to.CusCartDetails;
import lk.ijse.timbershop.to.CustomerOrderPlace;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.view.tm.CustomerPlaceOrderTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class CustomerOrderController implements Initializable {

    public AnchorPane cusOrderPane;
    public TextField txtStock;
    public TextField txtUnitPrice;
    public JFXComboBox cmbItemCode;
    public JFXComboBox cmbCustomerId;
    public TableColumn clmOrderId;
    public TableColumn clmItemCode;
    public TableColumn clmCustomerId;
    public TableColumn clmQty;
    public TableColumn clmPrice;
    public TableColumn clmAction;
    public Label orderIdLbl;
    public Label dateLbl;

    public TableView tblOrderCart;
    public TextField txtQty;
    public TextField txtName;
    private ObservableList<CustomerPlaceOrderTm> obList = FXCollections.observableArrayList();
    private CustomerOrderService customerOrderService;
    private CustomerOrderPlaceService customerOrderPlaceService;



    public CustomerOrderController() {

    }

    public void backtoOrderForm(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) cusOrderPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderForm.fxml"))));
        stage.setTitle("ORDER HERE");
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        stockUpdate();
        /*boolean b=stockUpdate();
        if(b){
            (new Alert(Alert.AlertType.WARNING,"Out Of Stock!",new ButtonType[0])).show();
            return;
        }*/
      String CorderId =this.orderIdLbl.getText();
      String CusId=String.valueOf(this.cmbCustomerId.getValue());
      String Itemcode= String.valueOf(this.cmbItemCode.getValue());
      double unitPrice= Double.parseDouble(this.txtUnitPrice.getText());
      int Qty= Integer.parseInt(this.txtQty.getText());
      double Price= unitPrice*(double)Qty;
        //Button btnDelete=new Button("Delete");
        Button btnDelete=new Button("Delete");
        this.txtQty.setText("");
        if(!this.obList.isEmpty()){
            for(int i =0; i < this.tblOrderCart.getItems().size(); ++i){
                if(this.clmItemCode.getCellData(i).equals(Itemcode));{
                    Qty +=(Integer)this.clmQty.getCellData(i);
                    Price= unitPrice*(double) Qty;
                    ((CustomerPlaceOrderTm)this.obList.get(i)).setQty(Qty);
                    ((CustomerPlaceOrderTm)this.obList.get(i)).setPrice(Price);
                    this.tblOrderCart.refresh();
                    return;
                }

            }
        }
        btnDelete.setOnAction((e)->{
            ButtonType ok=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",new ButtonType[]{ok,no});
            Optional<ButtonType> result=alert.showAndWait();

            if(result.orElse(no)==ok){
                CustomerPlaceOrderTm tm=(CustomerPlaceOrderTm) this.tblOrderCart.getSelectionModel().getSelectedItem();
                this.tblOrderCart.getItems().removeAll(new CustomerPlaceOrderTm[]{(CustomerPlaceOrderTm)this.tblOrderCart.getSelectionModel().getSelectedItem() });
                this.tblOrderCart.setItems(obList);
            }

        });
        this.obList.add(new CustomerPlaceOrderTm(CorderId,CusId,Itemcode,Qty,Price,btnDelete));
        this.tblOrderCart.setItems(obList);

    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String CorderId=this.orderIdLbl.getText();
        String CustomerId= String.valueOf(this.cmbCustomerId.getValue());
        ArrayList<CusCartDetails> cusCartDetails=new ArrayList();

        for(int i=0; i < this.tblOrderCart.getItems().size();++i){
            CustomerPlaceOrderTm tm=(CustomerPlaceOrderTm) this.obList.get(i);
            cusCartDetails.add(new CusCartDetails(CorderId,tm.getCusId(),tm.getItemCode(),tm.getQty(),tm.getPrice()));
        }
        CustomerOrderPlace customerOrderPlace=new CustomerOrderPlace(CorderId,CustomerId,cusCartDetails);
        try{
            boolean isPlaced= customerOrderPlaceService.CustomerPlaceOrder(customerOrderPlace);
            if(isPlaced){
                this.obList.clear();
                this.loadNextOrderId();
                (new Alert(Alert.AlertType.CONFIRMATION,"Order Placed",new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.ERROR, "Order Not Placed!", new ButtonType[0])).show();
            }
        }catch (ClassNotFoundException|SQLException var7){
            throw new RuntimeException(var7);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerOrderService=new CustomerOrderServiceImpl();
        customerOrderPlaceService=new CustomerOrderPlaceServiceImpl();
        this.loadOrderDate();
        this.loadCustomerIds();
        this.loadNextOrderId();
        this.loadItemCodes();
        this.setCellValueFactory();

    }

    private void loadNextOrderId()  {
        try {
            String OrderId = customerOrderService.generateNextOrderId();
            this.orderIdLbl.setText(OrderId);
        } catch (ClassNotFoundException | SQLException var2) {
            throw new RuntimeException(var2);
        }
    }
    private void loadOrderDate(){
        this.dateLbl.setText(String.valueOf(LocalDate.now()));
    }
    private void loadCustomerIds()  {
        try{
            ObservableList<String> observableList= FXCollections.observableArrayList();
            ArrayList<String> idList= customerOrderService.loadCustomerIds();
            Iterator var3=idList.iterator();
            while (var3.hasNext()){
                String CustomerId=(String) var3.next();
                observableList.add(CustomerId);
            }
            this.cmbCustomerId.setItems(observableList);
        }catch (ClassNotFoundException|SQLException var5){
            throw new RuntimeException(var5);
        }
    }
    private void loadItemCodes(){
        try{
            ObservableList<String> observableList=FXCollections.observableArrayList();
            ArrayList<String> itemList= customerOrderService.loadItemCodes();
            Iterator var3=itemList.iterator();

            while (var3.hasNext()){
                String Code=(String)var3.next();
                observableList.add(Code);
            }
            this.cmbItemCode.setItems(observableList);
        }catch (ClassNotFoundException|SQLException var5){
            throw new RuntimeException(var5);
        }
    }
    private void setCellValueFactory(){
    this.clmOrderId.setCellValueFactory(new PropertyValueFactory<CustomerPlaceOrderTm,String>("CorderId"));
    this.clmCustomerId.setCellValueFactory(new PropertyValueFactory("CusId"));
    this.clmItemCode.setCellValueFactory(new PropertyValueFactory("ItemCode"));
    this.clmQty.setCellValueFactory(new PropertyValueFactory("Qty"));
    this.clmPrice.setCellValueFactory(new PropertyValueFactory("Price"));
    this.clmAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }
    private void fillItemFields(Item item){
        this.txtStock.setText(String.valueOf(item.getQty()));
        this.txtUnitPrice.setText(String.valueOf(item.getUnitprice()));
        this.txtName.setText(item.getName());
        this.tblOrderCart.refresh();
    }

    public void itemCodeOnAction(ActionEvent actionEvent) {
        String Itemcode=String.valueOf(this.cmbItemCode.getValue());
        try{
            Item item=customerOrderService.search(Itemcode);
            this.fillItemFields(item);
            this.txtQty.requestFocus();
        }catch (ClassNotFoundException|SQLException var4){
            throw new RuntimeException(var4);
        }
    }
    private void stockUpdate(){
        int Qty= Integer.parseInt(txtStock.getText());
        if(!txtQty.getText().equals("") & (Qty>0)){
            int q= Integer.parseInt(txtQty.getText());
            int q2= Integer.parseInt(txtStock.getText());
            int result=q2-q;
            if(result<=0){
                new Alert(Alert.AlertType.WARNING,"Out Of Stock!",new ButtonType[0]).show();

            }else{
                txtStock.setText(String.valueOf(result));
            }
        }

    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
        this.btnAddToCartOnAction(actionEvent);

    }
}

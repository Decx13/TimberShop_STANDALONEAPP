package lk.ijse.timbershop.controller;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.timbershop.service.custom.SupplierOrderPlaceService;
import lk.ijse.timbershop.service.custom.SupplierOrderService;
import lk.ijse.timbershop.service.custom.impl.SupplierOrderPlaceServiceImpl;
import lk.ijse.timbershop.service.custom.impl.SupplierOrderServiceImpl;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.to.SupCartDetails;
import lk.ijse.timbershop.to.SupplierOrderPlace;
import lk.ijse.timbershop.view.tm.SupplierPlaceOrderTm;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;

public class SupplierOrderController implements Initializable {


    public AnchorPane supOrderPane;
    public TextField txtQty;
    public TextField txtUnitPrice;
    public JFXComboBox cmbSupId;
    public TextField txtName;
    public TextField txtStock;
    public Label lblOrderId;
    public Label lblDate;
    public TableColumn clmOrderId;
    public TableColumn clmSupId;
    public TableColumn clmItemCode;
    public TableColumn clmQty;
    public TableColumn clmPrice;
    public TableColumn clmAction;
    public JFXComboBox cmbItemCode;
    public TableView<SupplierPlaceOrderTm> tblOrderCart;

    private ObservableList<SupplierPlaceOrderTm> obList = FXCollections.observableArrayList();
    private SupplierOrderService supplierOrderService;
    private SupplierOrderPlaceService supplierOrderPlaceService;

    public SupplierOrderController() {
    }

    public void backtoOrderForm(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) supOrderPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderForm.fxml"))));
        stage.setTitle("ORDER HERE");
    }
    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        stockUpdate();
        String S_orderId=this.lblOrderId.getText();
        String SupplierId= String.valueOf(this.cmbSupId.getValue());
        String Itemcode= String.valueOf(this.cmbItemCode.getValue());
        double Unitprice= Double.parseDouble(this.txtUnitPrice.getText());
        int Qty= Integer.parseInt(this.txtQty.getText());
        double Price=Unitprice*(double) Qty;
        Button btnDelete=new Button("Delete");
        this.txtQty.setText("");
        if(!this.obList.isEmpty()){
            for(int i =0; i < this.tblOrderCart.getItems().size(); ++i){
                if(this.clmItemCode.getCellData(i).equals(Itemcode));{
                    Qty +=(Integer)this.clmQty.getCellData(i);
                    Price= Unitprice*(double) Qty;
                    ((SupplierPlaceOrderTm)this.obList.get(i)).setQty(Qty);
                    ((SupplierPlaceOrderTm)this.obList.get(i)).setPrice(Price);
                    this.tblOrderCart.refresh();
                    return;
                }

            }
        }
        btnDelete.setOnAction((e)->{
            ButtonType ok=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure?",new ButtonType[]{ok,no});
            Optional<ButtonType> result=alert.showAndWait();
            if(result.orElse(no)==ok){
                SupplierPlaceOrderTm tm=(SupplierPlaceOrderTm) this.tblOrderCart.getSelectionModel().getSelectedItem();
                this.tblOrderCart.getItems().removeAll(new SupplierPlaceOrderTm[]{(SupplierPlaceOrderTm) this.tblOrderCart.getSelectionModel().getSelectedItem()});
                this.tblOrderCart.setItems(obList);
            }
        });
        this.obList.add(new SupplierPlaceOrderTm(S_orderId,SupplierId,Itemcode,Qty,Price,btnDelete));
        this.tblOrderCart.setItems(obList);

    }
    public void btnConfirmOrderAction(ActionEvent actionEvent) throws ClassNotFoundException {
        System.out.println(lblOrderId);
        String SorderId=this.lblOrderId.getText();
        String SupplierId= String.valueOf(this.cmbSupId.getValue());
        ArrayList<SupCartDetails> supCartDetails=new ArrayList();

        for(int i=0;i<this.tblOrderCart.getItems().size(); ++i){
            SupplierPlaceOrderTm tm=(SupplierPlaceOrderTm) this.obList.get(i);
            supCartDetails.add(new SupCartDetails(SorderId,tm.getSuppllierId(),tm.getItemcode(),tm.getQty(),tm.getPrice()));
        }
        SupplierOrderPlace supplierOrderPlace=new SupplierOrderPlace(SorderId,SupplierId,supCartDetails);
        try{
            boolean isPlaced=supplierOrderPlaceService.SupplierPlaceOrder(supplierOrderPlace);
            if(isPlaced){
                this.obList.clear();
                this.loadNextOrderId();
                (new Alert(Alert.AlertType.CONFIRMATION,"Order Confirmed!",new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.ERROR, "Order Not Confirmed!", new ButtonType[0])).show();
            }
        }catch (RuntimeException|SQLException var7){
            throw new RuntimeException(var7);
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        supplierOrderService=new SupplierOrderServiceImpl();
        supplierOrderPlaceService=new SupplierOrderPlaceServiceImpl();
        this.loadOrderDate();
        this.loadSupplierIds();
        this.loadNextOrderId();
        this.loadItemCodes();
        this.setCellValueFactory();
    }
    private void loadNextOrderId()  {
        try {
            String S_orderId = supplierOrderService.generateNextOrderId();

            this.lblOrderId.setText(S_orderId);
        } catch (ClassNotFoundException | SQLException var2) {
            throw new RuntimeException(var2);
        }
    }
    private void loadOrderDate(){
        this.lblDate.setText(String.valueOf(LocalDate.now()));
    }
    private void loadSupplierIds()  {
        try{
            ObservableList<String> observableList= FXCollections.observableArrayList();
            ArrayList<String> idList= supplierOrderService.loadSupplierIds();
            Iterator var3=idList.iterator();
            while (var3.hasNext()){
                String SupplierId=(String) var3.next();
                observableList.add(SupplierId);
            }
            this.cmbSupId.setItems(observableList);
        }catch (ClassNotFoundException|SQLException var5){
            throw new RuntimeException(var5);
        }
    }
    private void loadItemCodes(){
        try{
            ObservableList<String> observableList=FXCollections.observableArrayList();
            ArrayList<String> itemList= supplierOrderService.loadItemCodes();
            Iterator var3=itemList.iterator();

            while (var3.hasNext()){
                String Itemcode=(String)var3.next();
                observableList.add(Itemcode);
            }
            this.cmbItemCode.setItems(observableList);
        }catch (ClassNotFoundException|SQLException var5){
            throw new RuntimeException(var5);
        }
    }
    private void setCellValueFactory(){
        this.clmOrderId.setCellValueFactory(new PropertyValueFactory<SupplierPlaceOrderTm,String>("SorderId"));
        this.clmSupId.setCellValueFactory(new PropertyValueFactory<SupplierPlaceOrderTm,String>("SuppllierId"));
        this.clmItemCode.setCellValueFactory(new PropertyValueFactory("Itemcode"));
        this.clmQty.setCellValueFactory(new PropertyValueFactory("Qty"));
        this.clmPrice.setCellValueFactory(new PropertyValueFactory("Price"));
        this.clmAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }
    private void fillItemFields(Item item) {
        this.txtStock.setText(String.valueOf(item.getQty()));
        this.txtUnitPrice.setText(String.valueOf(item.getUnitprice()));
        this.txtName.setText(item.getName());
    }
    private void stockUpdate(){
        int Qty= Integer.parseInt(txtStock.getText());
        if(!txtQty.getText().equals("") & (Qty>0)){
            int q= Integer.parseInt(txtQty.getText());
            int q2= Integer.parseInt(txtStock.getText());
            int result=q2+q;
            txtStock.setText(String.valueOf(result));
            }
        }



    public void txtQtyOnAction(ActionEvent actionEvent) {
        this.btnAddToCartOnAction(actionEvent);
    }

    public void itemCodeOnAction(ActionEvent actionEvent) {
        String Itemcode=String.valueOf(this.cmbItemCode.getValue());
        try{
            Item item=supplierOrderService.search(Itemcode);
            this.fillItemFields(item);
            this.txtQty.requestFocus();
        }catch (ClassNotFoundException|SQLException var4){
            throw new RuntimeException(var4);
        }
    }
}

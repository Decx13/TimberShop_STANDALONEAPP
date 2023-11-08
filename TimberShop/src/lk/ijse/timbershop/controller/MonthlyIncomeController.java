package lk.ijse.timbershop.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.timbershop.db.DBConnection;

import lk.ijse.timbershop.service.custom.MonthlyIncomeService;
import lk.ijse.timbershop.service.custom.impl.MonthlyIncomeServiceImpl;
import lk.ijse.timbershop.to.IncomeTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class MonthlyIncomeController {
    public AnchorPane monthlyPane;
    public TableColumn clmDate;
    public TableColumn clmCount;
    public TableColumn clmTotal;
    public TableView tblReport;
    public Label lblTotal;
    private MonthlyIncomeService monthlyIncomeService;

    public void iniatialize(){

    }


    public void initialize(){
        monthlyIncomeService=new MonthlyIncomeServiceImpl();
        setTable();
       // print();
    }
    public void backToSellingForm(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) monthlyPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SellingForm.fxml"))));
    }

    public void setTable(){
        clmDate.setCellValueFactory(new PropertyValueFactory<IncomeTM,String>("date"));
        clmCount.setCellValueFactory(new PropertyValueFactory<IncomeTM,String>("count"));
        clmTotal.setCellValueFactory(new PropertyValueFactory<IncomeTM, Double>("total"));

        try {
            int total = 0;
            ObservableList<IncomeTM> list = monthlyIncomeService.getDailyIncome(LocalDate.now().getMonthValue(),LocalDate.now().getYear());
            for(IncomeTM ob : list){
                total+=ob.getTotal();
            }
            lblTotal.setText(String.valueOf(Double.valueOf(total)));
            tblReport.setItems(list);

        } catch (SQLException e) {
            throw  new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(){
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("total",lblTotal.getText());
        try {
            JasperDesign jr = JRXmlLoader.load("D:\\gdse\\Timber Shop Final\\TimberShop1\\TimberShop\\src\\lk\\ijse\\timbershop\\report\\IncomeReport.jrxml");
            String sql = "select co.date as date,Count(co.C_orderId) as count , sum(cod.Qty*cod.Unitprice) as total,Day(co.Date) as day,Month(co.date) as month , Year(co.date) as year" +
                    " from C_orderdetail cod inner join customerorder co on cod.C_orderId = " +
                    "co.C_orderId group by co.date having year = "+LocalDate.now().getYear()+" AND month = "+LocalDate.now().getMonthValue() ;
            JRDesignQuery qu = new JRDesignQuery();
            qu.setText(sql);
            jr.setQuery(qu);

            JasperReport rp= JasperCompileManager.compileReport(jr);
            JasperPrint jp = JasperFillManager.fillReport(rp,hm, DBConnection.getInstance().getConnection());

            JasperViewer view = new JasperViewer(jp,false);
            view.show();


        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnReportPrintOnAction(ActionEvent actionEvent) {
        print();
    }
}

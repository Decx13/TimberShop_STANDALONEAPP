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

import lk.ijse.timbershop.service.custom.EmployeeService;
import lk.ijse.timbershop.service.custom.impl.EmployeeServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.Employee;
import lk.ijse.timbershop.util.Regex;
import lk.ijse.timbershop.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeFormController {
    public AnchorPane employeePane;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtNum;
    public TextField txtSalary;
    private EmployeeService employeeService;

    public void initialize(){

        employeeService=new EmployeeServiceImpl();
    }


    public void backtoMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) employeePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }



    public void addEmployee(ActionEvent actionEvent) {
        boolean a=Regex.isTextFieldValid(TextFields.ADDRESS,txtAddress.getText());
        if(!a){
            new Alert(Alert.AlertType.WARNING,"Invalid Address").show();
            return;
        }
        boolean e=Regex.isTextFieldValid(TextFields.DOUBLE,txtSalary.getText());
        if(!e){
            new Alert(Alert.AlertType.WARNING,"Invalid Salary").show();
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


        String EmployeeId = this.txtId.getText();
        String Name = this.txtName.getText();
        String Address = this.txtAddress.getText();
        String Number = this.txtNum.getText();
        double Salary=Double.parseDouble(this.txtSalary.getText());
        Employee employee = new Employee(EmployeeId, Name, Address, Number,Salary);
        try {
            boolean isAdded= employeeService.add(employee);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }
    public void searchfromId(ActionEvent actionEvent) {
        String EmployeeId = this.txtId.getText();

        try {
            Employee employee = employeeService.search(EmployeeId);
            if (employee != null) {
                this.fillData(employee);
            }

        } catch (ClassNotFoundException | SQLException var4) {
            throw new RuntimeException(var4);
        }
    }
    private void fillData(Employee employee) {
        this.txtId.setText(employee.getEmployeeId());
        this.txtName.setText(employee.getName());
        this.txtAddress.setText(employee.getAddress());
        this.txtNum.setText(employee.getNumber());
        this.txtSalary.setText(String.valueOf(employee.getSalary()));
    }


    public void updateEmployee(ActionEvent actionEvent) {
        String EmployeeId=txtId.getText();
        String Name=txtName.getText();
        String Address=txtAddress.getText();
        String Number=txtNum.getText();
        double Salary= Double.parseDouble(txtSalary.getText());
        Employee employee=new Employee(EmployeeId,Name,Address,Number,Salary);
        try{
            boolean isUpdate=employeeService.updateEmployee(employee);
            if(isUpdate){
                (new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!", new ButtonType[0])).show();
            }else{
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }
        }catch(ClassNotFoundException|SQLException var9){
            throw new RuntimeException(var9);
        }
    }

    public void deleteEmployeeAction(ActionEvent actionEvent) {
        try{
            boolean isDeleted=employeeService.deleteEmployee(txtId.getText());
            if(isDeleted){
                (new Alert(Alert.AlertType.CONFIRMATION, "Employee Deleted!", new ButtonType[0])).show();
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
        Regex.setTextColor(TextFields.NAME,(JFXTextField) txtName);
    }

    public void addressRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ADDRESS,(JFXTextField) txtAddress);
    }

    public void numberRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PHONE,(JFXTextField) txtNum);
    }

    public void salaryRelease(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.DOUBLE,(JFXTextField) txtSalary);
    }
}

package lk.ijse.timbershop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.timbershop.service.ServiceFactory;
import lk.ijse.timbershop.service.ServiceType;
import lk.ijse.timbershop.service.custom.LoginFormService;
import lk.ijse.timbershop.service.custom.impl.LoginFormServiceImpl;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.to.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginFormController {
    public AnchorPane loginPane;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public JFXButton logBtn;
    public Label alertLabel;
    private LoginFormService loginFormService;

    public void initialize(){
        loginFormService = ServiceFactory.getInstance().getService(ServiceType.LOGINFORM);
    }

    public void loginActionBtn(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==logBtn){
            String Username=txtName.getText();
            String Password=txtPassword.getText();
            if(Username.equalsIgnoreCase("Mithila") && (Password.equalsIgnoreCase("1234"))){
                Stage stage=(Stage) loginPane.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
                stage.setTitle("Main Window");

            } else if (txtName.getText().isEmpty() ||(txtPassword.getText().isEmpty())) {
                alertLabel.setText("Please Enter Your Login Details");

            }else{
                txtName.setUnFocusColor(Paint.valueOf("RED"));
                txtPassword.setUnFocusColor(Paint.valueOf("RED"));
                alertLabel.setText("Wrong Username or Password");
            }
        }
      /* Stage stage=(Stage) loginPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");*/
    }

    public void signUpAction(ActionEvent actionEvent) {
        String Username = this.txtName.getText();
        String Password = this.txtPassword.getText();
        User user = new User(Username, Password);
        try {
            boolean isAdded = loginFormService.signUp(user);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "SignUp Successful!", new ButtonType[0])).show();
            } else {
                (new Alert(Alert.AlertType.WARNING, "Something Wrong!", new ButtonType[0])).show();
            }

        } catch (ClassNotFoundException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }
}

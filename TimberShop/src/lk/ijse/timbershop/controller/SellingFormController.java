package lk.ijse.timbershop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SellingFormController {
    public AnchorPane tabPane;
    public AnchorPane sellingPane;

    public void weeklyIncomeAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/WeeklyIncome.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);
    }

    public void monthlyIncomeAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("../view/MonthlyIncome.fxml"));
        tabPane.getChildren().clear();
        tabPane.getChildren().add(node);
    }

    public void backtMainWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) sellingPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.setTitle("Main Window");
    }
}

package lk.ijse.timbershop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WeeklyIncomeController {
    public AnchorPane weeklyPane;

    public void backToSellingForm(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) weeklyPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SellingForm.fxml"))));
    }
}

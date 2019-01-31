package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.awt.event.ActionEvent;


public class Controller  {
    @FXML
    private Label miLabel;
    @FXML
    public void setLabelText(javafx.event.ActionEvent actionEvent) {
        System.out.println("Se ha clickado el botón");
        miLabel.setText("Hola Mundo");
    }
}

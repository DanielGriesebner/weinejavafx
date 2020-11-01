package at.weine;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private FlowPane weinefeed;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weinefeed.getChildren().add(new Wein(1, "Pin", "a" , true, Weinart.Rosewein, "2019", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75));
        weinefeed.getChildren().add(new Wein(2, "asdf", "a" , true, Weinart.Rosewein, "2019", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75));

    }
}

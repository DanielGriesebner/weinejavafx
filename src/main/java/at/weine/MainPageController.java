package at.weine;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private FlowPane weinefeed;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = new Image("https://i.pinimg.com/originals/aa/f0/06/aaf006b11e06e519bf5262c9b82efa77.jpg");
        weinefeed.setAlignment(Pos.TOP_CENTER);
        //weinefeed.getChildren().add(new Wein(2, "asdf", "a" , true, Weinart.Rosewein, "2019", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75, image));
        for(int i = 1; i<11;i++){
            weinefeed.getChildren().add(new Wein(i, "Riesling", "Federspiel" , false, Weinart.Weisswein, "2018", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75, image));
        }
    }
}

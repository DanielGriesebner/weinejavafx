package at.weine;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private FlowPane weinefeed;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("https://bilder.t-online.de/b/84/93/82/46/id_84938246/920/tid_da/eichhoernchen-geert-weggen-zeigt-die-welt-der-kleinen-nager-.jpg");
        weinefeed.setAlignment(Pos.TOP_CENTER);
        //weinefeed.getChildren().add(new Wein(2, "asdf", "a" , true, Weinart.Rosewein, "2019", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75, image));
        for(int i = 1; i<11;i++){
            weinefeed.getChildren().add(new Wein(i, "Pin", "a" , true, Weinart.Rosewein, "2019", "Deutschland", "Alfons", "asdf", "asdf", 10.50, 2, 1, (float)12.75, image));
        }
    }
}

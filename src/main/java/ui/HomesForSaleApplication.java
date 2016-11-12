package ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.print.attribute.standard.Chromaticity;

/**
 * Created by 123 on 12.11.2016.
 */
public class HomesForSaleApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Homes for sale");
        stage.setWidth(1000);
        stage.setHeight(300);
        TextField addressText = new TextField("Address");
        TextField cityText = new TextField("City");
        TextField stateText = new TextField("State");
        TextField zipText = new TextField("Zip");
        TextField priceText = new TextField("Price");

        Button button = new Button("Add");
        HBox hb = new HBox();
        hb.getChildren().addAll(addressText, cityText, stateText, zipText, priceText, button);
        hb.setSpacing(5.0);
        ((Group)scene.getRoot()).getChildren().addAll(hb);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(HomesForSaleApplication.class, args);
    }
}

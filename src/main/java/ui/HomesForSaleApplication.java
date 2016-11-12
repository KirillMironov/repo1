package ui;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.print.attribute.standard.Chromaticity;

/**
 * Created by 123 on 12.11.2016.
 */
public class HomesForSaleApplication extends Application {
    TableView<Home> table = new TableView<>();
    ObservableList<Home> homes = FXCollections.observableArrayList(
            new Home("1000 Main St", "Malibu", "CA", "990265", "900000$")
    );
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Homes for sale");
        stage.setWidth(1000);
        stage.setHeight(500);

        TableColumn<Home, String> addressCol = new TableColumn<>();
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.setItems(homes);

        TableColumn<Home, String> cityCol = new TableColumn<>();
        cityCol.setMinWidth(100);
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        table.setItems(homes);

        TableColumn<Home, String> stateCol = new TableColumn<>();
        stateCol.setMinWidth(100);
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        table.setItems(homes);

        TableColumn<Home, String> zipCol = new TableColumn<>();
        zipCol.setMinWidth(100);
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zip"));
        table.setItems(homes);

        TableColumn<Home, String> priceCol = new TableColumn<>();
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(homes);
        table.getColumns().addAll(addressCol, cityCol, stateCol, zipCol, priceCol);

        TextField addressText = new TextField("Address");
        TextField cityText = new TextField("City");
        TextField stateText = new TextField("State");
        TextField zipText = new TextField("Zip");
        TextField priceText = new TextField("Price");

        Button button = new Button("Add");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homes.add(new Home(addressText.getText(), cityText.getText(), stateText.getText(), zipText.getText(), priceText.getText()));
            }
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(addressText, cityText, stateText, zipText, priceText, button);
        hb.setSpacing(5.0);

        VBox vb = new VBox();
        vb.setSpacing(5.0);
        vb.getChildren().addAll(table, hb);

        ((Group)scene.getRoot()).getChildren().addAll(vb);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(HomesForSaleApplication.class, args);
    }
}

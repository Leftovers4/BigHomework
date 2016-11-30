package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelWorkerController {

    private Stage stage;
    @FXML private Pane addhotelworkerPane;
    @FXML private TableView hotelworkerlist;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void fillHotelWorkerInfo() {
        addhotelworkerPane.setVisible(true);
        hotelworkerlist.setPrefHeight(150);
    }

    @FXML
    private void confirmToAdd() {
        addhotelworkerPane.setVisible(false);
        hotelworkerlist.setPrefHeight(370);
    }
}

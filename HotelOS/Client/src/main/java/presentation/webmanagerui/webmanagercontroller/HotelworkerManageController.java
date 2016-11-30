package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagerscene.AddHotelWorkerPane;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelworkerManageController {

    private Stage stage;
    private Pane pane;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.pane = mainPane;
    }

    @FXML
    private void toaddHotelWorker() {
        pane.getChildren().remove(0);
        pane.getChildren().add(new AddHotelWorkerPane(stage));
    }
}

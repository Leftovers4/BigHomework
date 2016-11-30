package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelController {

    private Stage stage;

    @FXML private Pane finishInfoPane;
    @FXML private Pane addhotelworkerPane;
    @FXML private Pane confirmHotelInfoPane;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }


    /**
     * 下一步，确认酒店信息
     */
    @FXML
    private void toconfirmHotelInfoEvent() {
        finishInfoPane.setVisible(false);
        addhotelworkerPane.setVisible(false);
        confirmHotelInfoPane.setVisible(true);
    }

    /**
     * 下一步，添加酒店工作人员
     */
    @FXML
    private void toaddHotelWorkerEvent() {
        finishInfoPane.setVisible(false);
        addhotelworkerPane.setVisible(true);
        confirmHotelInfoPane.setVisible(false);
    }
}

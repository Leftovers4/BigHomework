package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/19.
 */
public class UserSearchHotelController {

    private Stage stage;

    @FXML private Pane moreInfoChoice;
    @FXML private Pane upMoreInfo;
    @FXML private TableView hotelList;
    @FXML private Pane downMoreInfo;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void showMoreChoice() {
        moreInfoChoice.setVisible(true);
        FlowPane.setMargin(moreInfoChoice, new Insets(-105, 0, 0, 160));
        moreInfoChoice.setDisable(false);
        upMoreInfo.setDisable(false);
        upMoreInfo.setVisible(true);
        FlowPane.setMargin(hotelList, new Insets(20, 0, 0, 160));
        downMoreInfo.setVisible(false);
        downMoreInfo.setDisable(true);
    }

    @FXML
    private void hideMoreChoice() {
        moreInfoChoice.setVisible(false);
        FlowPane.setMargin(moreInfoChoice, new Insets(-160, 0, 0, 160));
        moreInfoChoice.setDisable(true);
        downMoreInfo.setVisible(true);
        downMoreInfo.setDisable(false);
        FlowPane.setMargin(hotelList, new Insets(-90, 0, 0, 160));
        upMoreInfo.setVisible(false);
        upMoreInfo.setDisable(true);
    }
}

package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/24.
 */
public class UserGenerateOrderController {

    private Stage stage;

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

    @FXML private DatePicker checkInDatePicker;
    @FXML private DatePicker checkOutDatePicker;
    @FXML private ComboBox checkInHour;
    @FXML private ComboBox checkInMin;
    @FXML private ComboBox checkOutHour;
    @FXML private ComboBox checkOutMin;
    @FXML private ComboBox roomType;
    @FXML private ComboBox roomNum;
    @FXML private RadioButton childHave;
    @FXML private RadioButton childNone;
    @FXML private ComboBox peopleNum;

    @FXML private Label writeOrder;
    @FXML private Label confirmPromotion;
    @FXML private Label submit;
    @FXML private Button confirmBtn;
    @FXML private Button backToEdit;
    @FXML private Button nextBtn;

    @FXML private Label checkIndateLabel;
    @FXML private Label checkInTimeLabel;
    @FXML private Label checkOutDateLabel;
    @FXML private Label checkOutTime;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomNumLabel;
    @FXML private Label peopleNumLabel;
    @FXML private Label child;


    @FXML
    private void nextBtnEvent() {
        checkInDatePicker.setVisible(false);
        checkOutDatePicker.setVisible(false);
        checkInHour.setVisible(false);
        checkInMin.setVisible(false);
        checkOutHour.setVisible(false);
        checkOutMin.setVisible(false);
        roomType.setVisible(false);
        roomNum.setVisible(false);
        childHave.setVisible(false);
        childNone.setVisible(false);
        peopleNum.setVisible(false);
        writeOrder.setStyle("-fx-text-fill: black");
        confirmPromotion.setStyle("-fx-text-fill: deepskyblue");
        confirmBtn.setVisible(true);
        backToEdit.setVisible(true);
        nextBtn.setVisible(false);

        checkIndateLabel.setVisible(true);
        checkInTimeLabel.setVisible(true);
        checkOutDateLabel.setVisible(true);
        checkOutTime.setVisible(true);
        roomTypeLabel.setVisible(true);
        roomNumLabel.setVisible(true);
        peopleNumLabel.setVisible(true);
        child.setVisible(true);
    }

    @FXML
    private void submitBtnEvent() {
        submit.setStyle("-fx-text-fill: deepskyblue");
        confirmPromotion.setStyle("-fx-text-fill: black");
    }
}

package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import presentation.util.CancelDateBefore;

import java.time.LocalDate;

/**
 * Created by wyj on 2016/11/24.
 */
public class UserGenerateOrderController {

    private Stage stage;

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

    private LocalDate date;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;

        initial();
    }

    private void initial() {
        for (int i = 0; i<24; i++) {
            checkInHour.getItems().add(i);
            checkOutHour.getItems().add(i);
        }
        for (int i = 0; i<60; i++) {
            checkInMin.getItems().add(i);
            checkOutMin.getItems().add(i);
        }
        roomType.getItems().add("单人间");
        roomType.getItems().add("标准间");
        roomType.getItems().add("多床房");
        roomType.getItems().add("标准套间");
        roomType.getItems().add("豪华套间");
        roomType.getItems().add("其他");
        checkInDatePicker.setDayCellFactory(new CancelDateBefore(checkInDatePicker));
        checkOutDatePicker.setDayCellFactory(new CancelDateBefore(checkOutDatePicker));
    }


    @FXML
    private void closeWindow(){
        stage.close();
    }
    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    /**
     * 下一步，确认促销优惠
     */
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

    private boolean judgeBlank() {
        boolean checkindate = checkInDatePicker.getValue().equals("");
        boolean chec
    }

    /**
     * 提交并生成订单
     */
    @FXML
    private void submitBtnEvent() {
        submit.setStyle("-fx-text-fill: deepskyblue");
        confirmPromotion.setStyle("-fx-text-fill: black");
    }

}

package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import presentation.util.CancelDateBefore;
import presentation.util.InputWrongAlert;

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
            if (i<10) {
                checkInHour.getItems().add("0" +i);
                checkOutHour.getItems().add("0" +i);
            } else {
                checkInHour.getItems().add(i);
                checkOutHour.getItems().add(i);
            }
        }
        for (int i = 0; i<60; i++) {
            if (i<10) {
                checkInMin.getItems().add("0" + i);
                checkOutMin.getItems().add("0" + i);
            } else {
                checkInMin.getItems().add(i);
                checkOutMin.getItems().add(i);
            }
        }
        roomType.getItems().add("单人间");
        roomType.getItems().add("标准间");
        roomType.getItems().add("多床房");
        roomType.getItems().add("标准套间");
        roomType.getItems().add("豪华套间");
        roomType.getItems().add("其他");
        checkInDatePicker.setDayCellFactory(new CancelDateBefore(checkInDatePicker, LocalDate.now()));
        checkOutDatePicker.setDayCellFactory(new CancelDateBefore(checkOutDatePicker, LocalDate.now()));
    }


    /**
     * 下一步，确认促销优惠
     */
    @FXML
    private void nextBtnEvent() {
        if (!judgeBlank()) {
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

            checkIndateLabel.setText(checkInDatePicker.getValue().toString());
            checkInTimeLabel.setText(checkInHour.getValue().toString() + ":" + checkInMin.getValue().toString());
            checkOutDateLabel.setText(checkOutDatePicker.getValue().toString());
            checkOutTime.setText(checkOutHour.getValue().toString() + ":" + checkOutMin.getValue().toString());
            roomTypeLabel.setText(roomType.getValue().toString());
//            roomNumLabel.setText(roomNum.getValue().toString());
//            peopleNumLabel.setText(peopleNum.getValue().toString());
            if (childHave.isSelected()) {
                child.setText("有");
            } else {
                child.setText("无");
            }
        } else {
            new InputWrongAlert("信息填写不完整", "警告").showAndWait();
        }
    }

    /**
     * 判断是否有内容未填写
     * @return
     */
    private boolean judgeBlank() {
        boolean checkindate = checkInDatePicker.getValue() == null;
        boolean checkinhour = checkInHour.getValue() == null;
        boolean checkinmin = checkInMin.getValue() == null;
        boolean checkoutdate = checkOutDatePicker.getValue() == null;
        boolean checkouthour = checkOutHour.getValue() == null;
        boolean checkoutmin = checkOutMin.getValue() == null;
        boolean roomtype = roomType.getValue() == null;
//        boolean roomnum = roomNum.getValue() == null;
//        boolean peoplenum = peopleNum.getValue() == null;
        boolean childhave = childHave.isSelected();
        boolean childhavenot = childNone.isSelected();

        boolean isChildSelected;
        if (!childhave && !childhavenot) {
            isChildSelected = false;
        } else {
            isChildSelected = true;
        }
        return checkindate || checkinhour || checkinmin || checkoutdate
                || checkouthour || checkoutmin || roomtype || !isChildSelected;
    }

    /**
     * 返回按钮事件，返回到填写订单界面
     */
    @FXML
    private void backToEdit() {
        checkInDatePicker.setVisible(true);
        checkOutDatePicker.setVisible(true);
        checkInHour.setVisible(true);
        checkInMin.setVisible(true);
        checkOutHour.setVisible(true);
        checkOutMin.setVisible(true);
        roomType.setVisible(true);
        roomNum.setVisible(true);
        childHave.setVisible(true);
        childNone.setVisible(true);
        peopleNum.setVisible(true);
        confirmPromotion.setStyle("-fx-text-fill: black");
        writeOrder.setStyle("-fx-text-fill: deepskyblue");
        confirmBtn.setVisible(true);
        backToEdit.setVisible(true);
        nextBtn.setVisible(true);

        checkIndateLabel.setVisible(false);
        checkInTimeLabel.setVisible(false);
        checkOutDateLabel.setVisible(false);
        checkOutTime.setVisible(false);
        roomTypeLabel.setVisible(false);
        roomNumLabel.setVisible(false);
        peopleNumLabel.setVisible(false);
        child.setVisible(false);
        backToEdit.setVisible(false);
        nextBtn.setVisible(false);
    }

    /**
     * 提交并生成订单
     */
    @FXML
    private void submitBtnEvent() {
        submit.setStyle("-fx-text-fill: deepskyblue");
        confirmPromotion.setStyle("-fx-text-fill: black");
        backToEdit.setVisible(false);
    }

}

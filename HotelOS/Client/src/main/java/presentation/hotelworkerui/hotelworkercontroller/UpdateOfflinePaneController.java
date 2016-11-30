package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;

/**
 * Created by Hitiger on 2016/11/23.
 * Description :
 */
public class UpdateOfflinePaneController {

    @FXML private Button checkInBtn;
    @FXML private Button checkOutBtn;
    @FXML private Label  busyRoomLabel;
    @FXML private ComboBox roomTypeBox;
    @FXML private ComboBox roomAmountBox;

    private Stage stage;
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, Boolean isCheckIn) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        alertController = new AlertController();

        setBtnVisible(isCheckIn);
    }

    private void setBtnVisible(Boolean isCheckIn) {
        checkInBtn.setVisible(isCheckIn);
        checkOutBtn.setVisible(!isCheckIn);
    }

    private Boolean judgeInput(){
        if(roomTypeBox.getValue() == null || roomAmountBox == null) return false;
        return true;
    }
    @FXML void checkIn(){
        if(judgeInput()){}
        else alertController.showInputWrongAlert("请选择客房类型和数量","入住失败");

    }
    @FXML void checkOut(){
        if(judgeInput()){}
        else alertController.showInputWrongAlert("请选择客房类型和数量","退房失败");
    }

}

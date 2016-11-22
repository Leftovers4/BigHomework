package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class UpdateOrderInfoPaneController {

    //实际离开时间
    @FXML private Label      actLeaveTimeLabel;
    @FXML private DatePicker actLeaveTimeDatePicker;
    @FXML private TextField  actLeaveTimeField;

    //入住时间
    @FXML private Label      checkinTimeLabel;
    @FXML private DatePicker checkinTimeDatePicker;
    @FXML private TextField  checkinTimeField;

    //预计离开时间
    @FXML private Label      expLeaveTimeLabel;
    @FXML private DatePicker expLeaveTimeDatePicker;
    @FXML private TextField  expLeaveTimeField;

    private Stage stage;
    private Pane mainPane;
    private Boolean isCheckIn;

    public void launch(Stage primaryStage, Pane mainPane ,Boolean isCheckIn) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        setActLeaveTimeComponentsVisible(!isCheckIn);
        setCheckinTimeComponentsVisible(isCheckIn);
        setExpLeaveTimeComponentsVisible(isCheckIn);
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
    private void back(){}

    private void setActLeaveTimeComponentsVisible(Boolean isVisible){
        actLeaveTimeLabel.setVisible(isVisible);
        actLeaveTimeDatePicker.setVisible(isVisible);
        actLeaveTimeField.setVisible(isVisible);
    }

    private void setCheckinTimeComponentsVisible(Boolean isVisible){
        checkinTimeLabel.setVisible(isVisible);
        checkinTimeDatePicker.setVisible(isVisible);
        checkinTimeField.setVisible(isVisible);
    }

    private void setExpLeaveTimeComponentsVisible(Boolean isVisible){
        expLeaveTimeLabel.setVisible(isVisible);
        expLeaveTimeDatePicker.setVisible(isVisible);
        expLeaveTimeField.setVisible(isVisible);
    }
}

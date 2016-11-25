package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;

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
    @FXML private Label      checkinTimeDayLabel;
    @FXML private Label      checkinTimeMinLabel;

    //预计离开时间
    @FXML private Label      expLeaveTimeLabel;
    @FXML private DatePicker expLeaveTimeDatePicker;
    @FXML private TextField  expLeaveTimeField;
    @FXML private Label  expLeaveTimeDayLabel;
    @FXML private Label  expLeaveTimeMinLabel;

    //入住人数
    @FXML private TextField  peopleAmountField;
    @FXML private Label  peopleAmountLabel;

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
        setPeopleAmountComponentsVisible(isCheckIn);
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
    private void back(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new FindOrderPane(stage,mainPane,isCheckIn));
    }

    private void setActLeaveTimeComponentsVisible(Boolean isVisible){
        actLeaveTimeLabel.setVisible(isVisible);
        actLeaveTimeDatePicker.setVisible(isVisible);
        actLeaveTimeField.setVisible(isVisible);
    }

    private void setCheckinTimeComponentsVisible(Boolean isVisible){
        checkinTimeDatePicker.setVisible(isVisible);
        checkinTimeField.setVisible(isVisible);

        checkinTimeDayLabel.setVisible(!isVisible);
        checkinTimeMinLabel.setVisible(!isVisible);
    }

    private void setExpLeaveTimeComponentsVisible(Boolean isVisible){
        expLeaveTimeDatePicker.setVisible(isVisible);
        expLeaveTimeField.setVisible(isVisible);

        expLeaveTimeDayLabel.setVisible(!isVisible);
        expLeaveTimeMinLabel.setVisible(!isVisible);
    }

    private void setPeopleAmountComponentsVisible(Boolean isVisible){
        peopleAmountField.setVisible(isVisible);
        peopleAmountLabel.setVisible(!isVisible);
    }
}

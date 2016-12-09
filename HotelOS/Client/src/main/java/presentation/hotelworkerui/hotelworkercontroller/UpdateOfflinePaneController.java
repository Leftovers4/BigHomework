package presentation.hotelworkerui.hotelworkercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateCheckInPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOutPane;
import presentation.util.alert.AlertController;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/23.
 * Description :
 */
public class UpdateOfflinePaneController {

    @FXML private Button checkInBtn;
    @FXML private Button checkOutBtn;
    @FXML private Label  busyRoomLabel;
    @FXML private ComboBox roomTypeBox;
    @FXML private TextField roomAmountField;
    @FXML private Label updateTitleLabel;

    private Pane mainPane;
    private AlertController alertController;
    private Boolean isCheckIn;
    private HotelBLService hotelBLService;

    public void launch(Pane mainPane, Boolean isCheckIn) {
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        alertController = new AlertController();

        initService();
        initLabel();
        initBox();
        setBtnVisible();
    }

    private void initService() {
        try {
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initLabel() {
        updateTitleLabel.setText(isCheckIn ? "线下入住" : "线下退房");
        //TODO 更换酒店ID
        try {
            busyRoomLabel.setText(String.valueOf(hotelBLService.viewOfflineCheckInRoomAmount(522000)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initBox() {
        //TODO 房间类型
        roomTypeBox.getItems().addAll("单人房", "双人房");
        roomTypeBox.setValue("单人房");
    }

    private void setBtnVisible() {
        checkInBtn.setVisible(isCheckIn);
        checkOutBtn.setVisible(!isCheckIn);
    }

    private Boolean judgeInput(){
        if(roomAmountField.getText().equals("")) return false;
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcherAmount = pattern.matcher(roomAmountField.getText());
            if(!matcherAmount.matches()) return false;
        }
        return true;
    }
    @FXML
    private void checkIn(){
        if(judgeInput()){
            try {
                ResultMessage resultMessage = hotelBLService.offlineCheckIn(121121, Integer.parseInt(roomAmountField.getText()));
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("更新线下入住信息成功", "入住成功"))
                        mainPane.getChildren().add(new UpdateCheckInPane(mainPane));
                }else {
                    //酒店工作人员输入的数量不合理
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else alertController.showInputWrongAlert("请选择客房类型和数量","入住失败");

    }
    @FXML
    private void checkOut(){
        if(judgeInput()){
            try {
                ResultMessage resultMessage = hotelBLService.offlineCheckOut(121121, Integer.parseInt(roomAmountField.getText()));
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("更新线下退房信息成功", "退房成功"))
                        mainPane.getChildren().add(new UpdateOutPane(mainPane));
                }else {
                    //酒店工作人员输入的数量不合理
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else alertController.showInputWrongAlert("请选择客房类型和数量","退房失败");
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        if(isCheckIn) mainPane.getChildren().add(new UpdateCheckInPane(mainPane));
        else mainPane.getChildren().add(new UpdateOutPane(mainPane));
    }

}

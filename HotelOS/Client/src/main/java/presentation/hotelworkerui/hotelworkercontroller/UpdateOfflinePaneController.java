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
import util.EnumFactory;
import util.ResultMessage;
import vo.hotel.RoomVO;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
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
    @FXML private ComboBox roomAmountBox;
    @FXML private Label updateTitleLabel;

    private Pane mainPane;
    private AlertController alertController;
    private Boolean isCheckIn;
    private HotelBLService hotelBLService;
    private  HashMap<String, RoomVO> typeToRoomVOMap;

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
            alertController.showNetConnectAlert();
        }
    }

    private void initLabel() {
        updateTitleLabel.setText(isCheckIn ? "线下入住" : "线下退房");
        try {
            busyRoomLabel.setText(String.valueOf(hotelBLService.viewOfflineCheckInRoomAmount(ComWorkerSceneController.hotelID)));
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    private void initBox() {
        typeToRoomVOMap = new HashMap<>();
        List<RoomVO> list= null;
        try {
            list = hotelBLService.viewAllHotelRooms(ComWorkerSceneController.hotelID);
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
        for (RoomVO roomVO : list){
            String roomType = EnumFactory.getString(roomVO.roomType);
            roomTypeBox.getItems().add(roomType);

            typeToRoomVOMap.put(roomType, roomVO);
        }

        roomTypeBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    roomAmountBox.getItems().clear();
                    if(isCheckIn){
                        int roomNum = typeToRoomVOMap.get(roomTypeBox.getValue().toString()).bookable;
                        for (int i = 0; i < roomNum; i++) roomAmountBox.getItems().add(i+1);
                    }else {
                        RoomVO temp = typeToRoomVOMap.get(roomTypeBox.getValue().toString());
                        int roomNum = temp.total - temp.available;
                        for (int i = 0; i < roomNum; i++) roomAmountBox.getItems().add(i+1);
                    }
                }
        );
    }

    private void setBtnVisible() {
        checkInBtn.setVisible(isCheckIn);
        checkOutBtn.setVisible(!isCheckIn);
    }

    @FXML
    private void checkIn(){
        if(roomAmountBox.getValue() != null){
            try {
                ResultMessage resultMessage = hotelBLService.offlineCheckIn(typeToRoomVOMap.get(roomTypeBox.getValue().toString()).roomID, Integer.parseInt(roomAmountBox.getValue().toString()));
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("更新线下入住信息成功", "入住成功"))
                        mainPane.getChildren().add(new UpdateCheckInPane(mainPane));
                }
            } catch (RemoteException e) {
                alertController.showNetConnectAlert();
            }
        }
        else alertController.showInputWrongAlert("无可入住的房间","入住失败");

    }
    @FXML
    private void checkOut(){
        if(roomAmountBox.getValue() != null){
            try {
                ResultMessage resultMessage = hotelBLService.offlineCheckOut(typeToRoomVOMap.get(roomTypeBox.getValue().toString()).roomID, Integer.parseInt(roomAmountBox.getValue().toString()));
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("更新线下退房信息成功", "退房成功"))
                        mainPane.getChildren().add(new UpdateOutPane(mainPane));
                }
            } catch (RemoteException e) {
                alertController.showNetConnectAlert();
            }
        }
        else alertController.showInputWrongAlert("无可退房的房间","退房失败");
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        if(isCheckIn) mainPane.getChildren().add(new UpdateCheckInPane(mainPane));
        else mainPane.getChildren().add(new UpdateOutPane(mainPane));
    }

}

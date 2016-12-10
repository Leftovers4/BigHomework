package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelController {

    private Stage stage;

    @FXML private Pane finishInfoPane;
    @FXML private Pane addhotelworkerPane;
    @FXML private Pane confirmHotelInfoPane;

    @FXML private TextField hotelnameField;
    @FXML private ComboBox hotelcity;
    @FXML private ComboBox hoteltracingarea;
    @FXML private RadioButton onestar;
    @FXML private RadioButton twostar;
    @FXML private RadioButton threestar;
    @FXML private RadioButton fourstar;
    @FXML private RadioButton fivestar;

    @FXML private Label hotelidLabel;
    @FXML private Label hotelnameLabel;
    @FXML private Label hoteladdressLabel;
    @FXML private Label hoteltracingareaLabel;
    @FXML private Label hotelstarLabel;

    @FXML private TableView hotelworkerList;
    @FXML private TextField workernameField;
    @FXML private TextField workerphoneField;

    private HotelBlServiceImpl hotelBlService;
    private PersonnelBLServiceImpl personnelBLService;
    private String hotelID;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            hotelBlService = new HotelBlServiceImpl();
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 下一步，确认酒店信息
     */
    @FXML
    private void toconfirmHotelInfoEvent() {
        finishInfoPane.setVisible(false);
        addhotelworkerPane.setVisible(false);
        confirmHotelInfoPane.setVisible(true);

        HotelVO hotelVO = new HotelVO();

        hotelVO.hotelName = hotelnameField.getText();
        hotelVO.address = hotelcity.getValue().toString() + hoteltracingarea.getValue().toString();

        if (onestar.isSelected()) {
            hotelVO.star = 1;
        } else if (twostar.isSelected()) {
            hotelVO.star = 2;
        } else if (threestar.isSelected()) {
            hotelVO.star = 3;
        } else if (fourstar.isSelected()) {
            hotelVO.star = 4;
        } else if (fivestar.isSelected()) {
            hotelVO.star = 5;
        }

        try {
            ResultMessage resultMessage = hotelBlService.addHotel(hotelVO);

            if (resultMessage == ResultMessage.Success) {
                System.out.println("hotel add success");
            } else {
                System.out.println("hotel add fail");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下一步，添加酒店工作人员
     */
    @FXML
    private void toaddHotelWorkerEvent() {
        finishInfoPane.setVisible(false);
        addhotelworkerPane.setVisible(true);
        confirmHotelInfoPane.setVisible(false);

//        hotelID =
    }
}

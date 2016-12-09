package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotel.HotelVO;

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

    private HotelBlServiceImpl hotelBlService;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            hotelBlService = new HotelBlServiceImpl();
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
            hotelBlService.addHotel(hotelVO);
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
    }
}

package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.AddTradProducer;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;
import java.util.Iterator;

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
    @FXML private TextField initialPasswordField;

    private HotelBlServiceImpl hotelBlService;
    private PersonnelBLServiceImpl personnelBLService;
    private long hotelID;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            hotelBlService = new HotelBlServiceImpl();
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        Iterator<String> cityList = AddTradProducer.getAllAddress();
        while (cityList.hasNext()) {
            hotelcity.getItems().add(cityList.next());
        }

        hotelcity.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    hoteltracingarea.getItems().clear();
                    Iterator<String> tracingareaList = AddTradProducer.getTradingAreasByAddress(newValue.toString());
                    while (tracingareaList.hasNext()) {
                        hoteltracingarea.getItems().add(tracingareaList.next());
                    }
                }
            }
        });
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
        hotelVO.address = hotelcity.getValue().toString();
        hotelVO.tradingArea = hoteltracingarea.getValue().toString();

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
            hotelID = hotelBlService.addHotel(hotelVO);

            HotelVO basicHotelInfo = hotelBlService.viewBasicHotelInfo(hotelID);

            hotelidLabel.setText(String.valueOf(basicHotelInfo.hotelID));
            hotelnameLabel.setText(basicHotelInfo.hotelName);
            hoteladdressLabel.setText(basicHotelInfo.address);
            hoteltracingareaLabel.setText(basicHotelInfo.tradingArea);
            hotelstarLabel.setText(String.valueOf(basicHotelInfo.star));
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

    /**
     * 确认添加酒店工作人员
     */
    @FXML
    private void confirmAddWorker() {
        PersonnelVO personnelVO = new PersonnelVO();

        personnelVO.name = workernameField.getText();
        personnelVO.password = initialPasswordField.getText();
        personnelVO.hotelID = hotelID;

        try {
            personnelBLService.addHotelWorker(personnelVO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

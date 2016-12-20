package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.webmanagerui.webmanagerscene.HotelManagePane;
import util.AddTradProducer;
import util.PersonnelType;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelController {

    private Pane mainPane;

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

    @FXML private Label hotelworkeridLabel;
    @FXML private Label hotelworkernameLabel;
    @FXML private Label workerhotelLabel;
    @FXML private Pane workerinfopane;
    @FXML private Pane confirmworkerpane;

    @FXML private TextField workernameField;
    @FXML private TextField initialPasswordField;

    private HotelBlServiceImpl hotelBlService;
    private PersonnelBLServiceImpl personnelBLService;
    private long hotelID;

    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;

        alertController = new AlertController();
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
        if (isHotelInfoFull()) {
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

                hotelidLabel.setText(String.valueOf(hotelID));
                hotelnameLabel.setText(hotelVO.hotelName);
                hoteladdressLabel.setText(hotelVO.address);
                hoteltracingareaLabel.setText(hotelVO.tradingArea);
                hotelstarLabel.setText(String.valueOf(hotelVO.star));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
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
        if (isWorkerInfoFull()) {
            PersonnelVO personnelVO = new PersonnelVO();

            personnelVO.name = workernameField.getText();
            personnelVO.password = initialPasswordField.getText();
            personnelVO.hotelID = hotelID;

            try {
                long hotelWorkerID = personnelBLService.addHotelWorker(personnelVO);

                workerinfopane.setVisible(false);
                confirmworkerpane.setVisible(true);

                hotelworkeridLabel.setText(String.valueOf(hotelWorkerID));
                hotelworkernameLabel.setText(personnelVO.name);
                workerhotelLabel.setText(hotelBlService.viewBasicHotelInfo(hotelID).hotelName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
        }
    }

    @FXML
    private void confirmHotelWorkerAdd() {

        alertController.showUpdateSuccessAlert("添加成功！", "成功提示");
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new HotelManagePane(mainPane));
    }

    private boolean isHotelInfoFull() {
        boolean hotelname = !hotelnameField.getText().equals("");
        boolean city = hotelcity.getValue() != null;
        boolean area = hoteltracingarea.getValue() != null;
        boolean star = onestar.isSelected() || twostar.isSelected() || threestar.isSelected() ||
                fourstar.isSelected() || fivestar.isSelected();

        return hotelname && city && area && star;
    }

    private boolean isWorkerInfoFull() {
        boolean name = !workernameField.getText().equals("");
        boolean password = !initialPasswordField.getText().equals("");

        return  name && password;
    }
}

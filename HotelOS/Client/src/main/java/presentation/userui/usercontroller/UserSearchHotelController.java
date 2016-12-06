package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.userui.userscene.OrderDetailUserPane;
import presentation.util.UserHotelListButtonCell;

/**
 * Created by wyj on 2016/11/19.
 */
public class UserSearchHotelController {

    private Stage stage;
    private Pane mainPane;

    @FXML private Pane moreInfoChoice;
    @FXML private Pane upMoreInfo;
    @FXML private TableView hotelList;
    @FXML private Pane downMoreInfo;

    @FXML private ComboBox cityComBox;
    @FXML private ComboBox tradingAreaCombox;

    @FXML private CheckBox simgleRoomCB;
    @FXML private CheckBox standardRoomCB;
    @FXML private CheckBox moreBedsRoomCB;
    @FXML private CheckBox standardFlatCB;
    @FXML private CheckBox grandFlatCB;
    @FXML private CheckBox otherRoomType;

    @FXML private DatePicker checkInDate;
    @FXML private DatePicker checkOutDate;

    @FXML private CheckBox twoHundredLess;
    @FXML private CheckBox twoToFourHundred;
    @FXML private CheckBox fourToSixHundred;
    @FXML private CheckBox sixToEightHundred;
    @FXML private CheckBox eightHundredMore;

    @FXML private CheckBox threeStar;
    @FXML private CheckBox fourStar;
    @FXML private CheckBox fiveStar;
    @FXML private CheckBox twoStarLess;

    @FXML private CheckBox fourPoFiveMore;
    @FXML private CheckBox threeToFour;
    @FXML private CheckBox threeLess;
    @FXML private CheckBox fourToFourPoFive;

    @FXML private CheckBox onlyCheckRegistered;

    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn hotelAddressCol;
    @FXML private TableColumn hotelScoreCol;
    @FXML private TableColumn registerRecordCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn btnCol;

    private UserHotelListButtonCell userHotelListButtonCell;
    private HotelBlServiceImpl hotelBlService;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        hotelBlService = new HotelBlServiceImpl();

        cityComBox.getItems().add("南京市");
        tradingAreaCombox.getItems().add("新街口");

        initialData();
    }

    private void initialData() {
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelAddressCol.setCellValueFactory(new PropertyValueFactory<>("hotelAddress"));
        hotelScoreCol.setCellValueFactory(new PropertyValueFactory<>("hotelScore"));
        registerRecordCol.setCellValueFactory(new PropertyValueFactory<>("registerRecord"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        btnCol.setCellValueFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userHotelListButtonCell = new UserHotelListButtonCell(stage, mainPane, hotelList);
                return userHotelListButtonCell;
            }
        });
        hotelList.setItems(getSearchedHotelList());
    }

    private ObservableList getSearchedHotelList() {
//        ObservableList<HotelVO> list = FXCollections.observableArrayList(hotelBlService.searchHotelsByConditions());
        return null;
    }


    @FXML
    private void showMoreChoice() {
        moreInfoChoice.setVisible(true);
        FlowPane.setMargin(moreInfoChoice, new Insets(-105, 0, 0, 160));
        moreInfoChoice.setDisable(false);
        upMoreInfo.setDisable(false);
        upMoreInfo.setVisible(true);
        FlowPane.setMargin(hotelList, new Insets(50, 0, 0, 160));
        downMoreInfo.setVisible(false);
        downMoreInfo.setDisable(true);
    }

    @FXML
    private void hideMoreChoice() {
        moreInfoChoice.setVisible(false);
        FlowPane.setMargin(moreInfoChoice, new Insets(-160, 0, 0, 160));
        moreInfoChoice.setDisable(true);
        downMoreInfo.setVisible(true);
        downMoreInfo.setDisable(false);
        FlowPane.setMargin(hotelList, new Insets(0, 0, 0, 160));
        upMoreInfo.setVisible(false);
        upMoreInfo.setDisable(true);
    }



    @FXML
    /**
     * 重置筛选条件
     */
    private void resetChoice() {
        simgleRoomCB.setSelected(false);
        standardRoomCB.setSelected(false);
        moreBedsRoomCB.setSelected(false);
        standardFlatCB.setSelected(false);
        grandFlatCB.setSelected(false);
        otherRoomType.setSelected(false);
        checkInDate.setValue(null);
        checkOutDate.setValue(null);
        twoHundredLess.setSelected(false);
        twoToFourHundred.setSelected(false);
        fourToSixHundred.setSelected(false);
        sixToEightHundred.setSelected(false);eightHundredMore.setSelected(false);
        threeStar.setSelected(false);
        fourStar.setSelected(false);
        fiveStar.setSelected(false);
        twoStarLess.setSelected(false);
        fourPoFiveMore.setSelected(false);
        threeToFour.setSelected(false);
        threeLess.setSelected(false);
        fourToFourPoFive.setSelected(false);
        onlyCheckRegistered.setSelected(false);
    }








    /***************临时方法***********************************/
    @FXML
    private void showOrderDetail() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new OrderDetailUserPane(stage, mainPane));
    }
}

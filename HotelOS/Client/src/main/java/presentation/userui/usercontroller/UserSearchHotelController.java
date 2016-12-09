package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.collections.FXCollections;
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
import presentation.util.buttoncell.UserHotelListButtonCell;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/19.
 */
public class UserSearchHotelController {

    private Stage stage;
    private Pane mainPane;
    private String userID;

    @FXML private Pane moreInfoChoice;
    @FXML private Pane upMoreInfo;
    @FXML private TableView hotelList;
    @FXML private Pane downMoreInfo;

    @FXML private ComboBox cityComBox;
    @FXML private ComboBox tradingAreaCombox;

    @FXML private TextField searchField;

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

    public void launch(Stage primaryStage, Pane mainPane, String userID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.userID = userID;

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        cityComBox.getItems().add("南京市");
        tradingAreaCombox.getItems().add("新街口");


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


    /**
     * 确认执行酒店搜索
     */
    @FXML
    private void confirmChoose() {
        HotelConditionsVO hotelConditionsVO = new HotelConditionsVO();

        hotelConditionsVO.address = cityComBox.getPromptText();
        hotelConditionsVO.tradingArea = tradingAreaCombox.getPromptText();
        hotelConditionsVO.name = searchField.getText();

        hotelConditionsVO.priceLowerBound = getPriceBound()[0];
        hotelConditionsVO.priceUpperBound = getPriceBound()[1];

        hotelConditionsVO.starLowerBound = getStarBound()[0];
        hotelConditionsVO.starUpperBound = getStarBound()[1];

        hotelConditionsVO.ratingLowerBound = getRateBound()[0];
        hotelConditionsVO.ratingUpperBound = getRateBound()[1];

        hotelConditionsVO.hasOrdered = onlyCheckRegistered.isSelected();


        initalTable(hotelConditionsVO);
    }

    //获得价格区间
    private double[] getPriceBound() {
        double[] bound = new double[2];

        double lowerprice = 800, higherprice = 0;

        if (twoHundredLess.isSelected()) {
            if (lowerprice >= 0) {
                lowerprice = 0;
            }
            if (higherprice <= 200) {
                higherprice = 200;
            }
        }
        if (twoToFourHundred.isSelected()) {
            if (lowerprice >= 200) {
                lowerprice = 200;
            }
            if (higherprice <= 400) {
                higherprice = 400;
            }
        }
        if (fourToSixHundred.isSelected()) {
            if (lowerprice >= 400) {
                lowerprice = 400;
            }
            if (higherprice <= 600) {
                higherprice = 600;
            }
        }
        if (sixToEightHundred.isSelected()) {
            if (lowerprice > 600) {
                lowerprice = 600;
            }
            if (higherprice <= 800) {
                higherprice = 800;
            }
        }
        if (eightHundredMore.isSelected()) {
            if (lowerprice >= 800) {
                lowerprice = 800;
            }
            if (higherprice < Double.MAX_VALUE) {
                higherprice = Double.MAX_VALUE;
            }
        }

        bound[0] = lowerprice;
        bound[1] = higherprice;

        return bound;
    }

    //获得星级区间
    private int[] getStarBound() {
        int[] bound = new int[2];

        int lowerstar = 5, higherstar = 0;

        if (twoStarLess.isSelected()) {
            if (lowerstar >= 0) {
                lowerstar = 0;
            }
            if (higherstar <= 2) {
                higherstar = 2;
            }
        }
        if (threeStar.isSelected()) {
            if (lowerstar >= 3) {
                lowerstar = 3;
            }
            if (higherstar <= 3) {
                higherstar = 3;
            }
        }
        if (fourStar.isSelected()) {
            if (lowerstar >= 4) {
                lowerstar = 4;
            }
            if (higherstar <= 4) {
                higherstar = 4;
            }
        }
        if (fiveStar.isSelected()) {
            if (lowerstar >= 5) {
                lowerstar = 5;
            }
            if (higherstar <= 5) {
                higherstar = 5;
            }
        }

        bound[0] = lowerstar;
        bound[1] = higherstar;

        return bound;
    }

    //获得酒店评分区间
    private double[] getRateBound() {
        double[] bound = new double[2];

        double lowerrate = 5, higherrate = 0;

        if (threeLess.isSelected()) {
            if (lowerrate >= 0) {
                lowerrate = 0;
            }
            if (higherrate <= 3) {
                higherrate = 3;
            }
        }
        if (threeToFour.isSelected()) {
            if (lowerrate >= 3) {
                lowerrate = 3;
            }
            if (higherrate <= 4) {
                higherrate = 4;
            }
        }
        if (fourToFourPoFive.isSelected()) {
            if (lowerrate >= 4) {
                lowerrate = 4;
            }
            if (higherrate <= 4.5) {
                higherrate = 4.5;
            }
        }
        if (fourPoFiveMore.isSelected()) {
            if (lowerrate >= 4.5) {
                lowerrate = 4.5;
            }
            if (higherrate <= 5) {
                higherrate = 5;
            }
        }

        bound[0] = lowerrate;
        bound[1] = higherrate;

        return bound;
    }


    private void initalTable(HotelConditionsVO hotelConditionsVO) {

        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        hotelScoreCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        registerRecordCol.setCellValueFactory(new PropertyValueFactory<>("registerRecord"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userHotelListButtonCell = new UserHotelListButtonCell(stage, mainPane, hotelList);
                return userHotelListButtonCell;
            }
        });
        hotelList.setItems(getSearchedHotelList(hotelConditionsVO));
    }

    private ObservableList getSearchedHotelList(HotelConditionsVO hotelConditionsVO) {
        ObservableList<HotelVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.searchHotelsByConditions(userID, hotelConditionsVO));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return list;
    }


    /***************临时方法***********************************/
//    @FXML
//    private void showOrderDetail() {
//        mainPane.getChildren().remove(0);
//        mainPane.getChildren().add(new OrderDetailUserPane(stage, mainPane));
//    }
}

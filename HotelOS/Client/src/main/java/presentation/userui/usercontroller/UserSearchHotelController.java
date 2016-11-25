package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.InfoPane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.userui.userscene.OrderDetailUserPane;

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

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
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
    private void showMoreChoice() {
        moreInfoChoice.setVisible(true);
        FlowPane.setMargin(moreInfoChoice, new Insets(-105, 0, 0, 160));
        moreInfoChoice.setDisable(false);
        upMoreInfo.setDisable(false);
        upMoreInfo.setVisible(true);
        FlowPane.setMargin(hotelList, new Insets(20, 0, 0, 160));
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
        FlowPane.setMargin(hotelList, new Insets(-90, 0, 0, 160));
        upMoreInfo.setVisible(false);
        upMoreInfo.setDisable(true);
    }


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

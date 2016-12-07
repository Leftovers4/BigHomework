package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.*;
import presentation.util.other.LeftBarEffect;

import java.util.ArrayList;
import java.util.Arrays;

import static presentation.util.other.MyTimeLabel.EnableShowTime;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户主界面控制器，负责基本信息、浏览订单、搜索酒店等界面的跳转
 */
public class ComUserSceneController {

    private Stage stage;

    @FXML private Pane mainPane;
    @FXML private Button indexBtn;
    @FXML private Button userInfoBtn;
    @FXML private Button orderListBtn;
    @FXML private Button searchHotelBtn;
    @FXML private Button hotelRegisteredBtn;
    @FXML private ImageView leftBarSlider;

    @FXML private ImageView topbarphoto;
    private Button currentBtn = null;

    @FXML private Label timeLabel;

    //左边栏按钮集合
    private ArrayList<Button> leftBarBtnArr;

    LeftBarEffect leftBarEffect = new LeftBarEffect();

    public void launch(Stage primaryStage){
        primaryStage.setX(400);
        primaryStage.setY(200);
        mainPane.getChildren().add(new InfoPane(primaryStage, mainPane, topbarphoto));
        this.stage = primaryStage;

        leftBarBtnArr = new ArrayList<>(Arrays.asList(userInfoBtn, orderListBtn, searchHotelBtn,
                hotelRegisteredBtn, indexBtn));

        EnableShowTime(timeLabel);
    }


    @FXML
    private void closeWindow(){
        stage.close();
    }
    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    /**
     * 滑块位置改变
     * @param y
     */
    private void changeSliderPos(double y) {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutX(193);
        leftBarSlider.setLayoutY(y);
    }

    /**
     * 鼠标点击按钮效果
     * @param button
     */
    private void leftBarBtnEffect(Button button) {
        leftBarEffect.buttonActionEffect(button, leftBarBtnArr);
    }
    @FXML
    private void index() {
        leftBarSlider.setVisible(false);
        leftBarBtnEffect(indexBtn);
        indexBtn.setStyle("-fx-background-color: transparent");
        currentBtn = null;
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UserGenerateOrderPane(stage));
    }
    @FXML
    private void userInfo() {
        changeSliderPos(260);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new InfoPane(stage, mainPane, topbarphoto));
        leftBarBtnEffect(userInfoBtn);
        currentBtn = userInfoBtn;
    }
    @FXML
    private void orderList() {
        changeSliderPos(305);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UserOrderListPane(stage, mainPane));
        leftBarBtnEffect(orderListBtn);
        currentBtn = orderListBtn;
    }
    @FXML
    private void searchHotel() {
        changeSliderPos(350);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new SearchHotelPane(stage, mainPane));
        leftBarBtnEffect(searchHotelBtn);
        currentBtn = searchHotelBtn;
    }
    @FXML
    private void hotelRegistered() {
        changeSliderPos(395);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new RegisteredHotelPane(stage, mainPane));
        leftBarBtnEffect(hotelRegisteredBtn);
        currentBtn = hotelRegisteredBtn;
    }


    /**
     * 鼠标悬停按钮效果
     * @param button
     */
    private void mouseOnEffect(Button button) {
        leftBarEffect.buttonMouseOnEffect(button, leftBarBtnArr, currentBtn);
    }
    @FXML
    private void mouseOnUserInfo() {
        mouseOnEffect(userInfoBtn);
    }
    @FXML
    private void mouseOnorderList() {
        mouseOnEffect(orderListBtn);
    }
    @FXML
    private void mouseOnSearchHotel() {
        mouseOnEffect(searchHotelBtn);
    }
    @FXML
    private void mouseOnRegisteredHotel() {
        mouseOnEffect(hotelRegisteredBtn);
    }


    /**
     * 鼠标移出按钮效果
     * @param button
     */
    private void mouseOutEffect(Button button) {
        leftBarEffect.buttonMouseOutEffect(button, currentBtn);
    }
    @FXML
    private void mouseOutUserInfoBtn() {
        mouseOutEffect(userInfoBtn);
    }
    @FXML
    private void mouseOutOrderListBtn() {
        mouseOutEffect(orderListBtn);
    }
    @FXML
    private void mouseOutSearchHotelBtn() {
        mouseOutEffect(searchHotelBtn);
    }
    @FXML
    private void mouseOutHotelRegisteredBtn() {
        mouseOutEffect(hotelRegisteredBtn);
    }
}


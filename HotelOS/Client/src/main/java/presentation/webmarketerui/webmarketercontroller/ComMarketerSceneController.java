package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import presentation.util.other.MyTimeLabel;
import presentation.util.other.LeftBarEffect;
import presentation.webmarketerui.webmarketerscene.FindOrderPane;
import presentation.webmarketerui.webmarketerscene.FindUserPane;
import presentation.webmarketerui.webmarketerscene.ManagePromotionPane;
import presentation.webmarketerui.webmarketerscene.OrderListPane;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 酒店主界面控制器，负责基本信息、浏览订单、录入可用客房等界面的跳转
 */
public class ComMarketerSceneController {


    @FXML
    private Pane mainPane;

    @FXML
    private Button managePromotionBtn;
    @FXML
    private Button orderListBtn;
    @FXML
    private Button appealOrderBtn;
    @FXML
    private Button addCreditBtn;

    @FXML
    private ImageView slider;
    @FXML private Label timeLabel;

    private Button currentBtn = null;
    //左边栏按钮集合
    private ArrayList<Button> leftBarBtnArr;
    LeftBarEffect leftBarEffect = new LeftBarEffect();

    private Stage stage;
    private AlertController alertController;
    public void launch(Stage primaryStage) {
        stage = primaryStage;
        mainPane.getChildren().add(new ManagePromotionPane(stage));
        leftBarBtnArr = new ArrayList<>(Arrays.asList(managePromotionBtn, orderListBtn, appealOrderBtn, addCreditBtn));

        alertController = new AlertController();
        //实时刷新time
        MyTimeLabel.EnableShowTime(timeLabel);
    }

    /**
     * 更换Pane
     */
    private void changePane(Pane newPane) {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(newPane);
    }

    /**
     * 滑块位置改变
     * @param y
     */
    private void changeSliderPos(double y) {
        slider.setVisible(true);
        slider.setLayoutX(193);
        slider.setLayoutY(y);
    }


    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    /**
     * 鼠标点击按钮效果
     *
     * @param
     */
    private void leftBarBtnEffect(Button button) {
        leftBarEffect.buttonActionEffect(button, leftBarBtnArr);
    }
    @FXML
    private void showManagePromotion() {
        leftBarBtnEffect(managePromotionBtn);
        changePane(new ManagePromotionPane(stage));
        currentBtn = managePromotionBtn;
        changeSliderPos(260);
    }

    /**
     * 显示订单列表
     */
    @FXML
    private void showOrderList() {
        leftBarBtnEffect(orderListBtn);
        changePane(new OrderListPane(mainPane));
        currentBtn = orderListBtn;
        changeSliderPos(305);
    }


    @FXML
    private void showAppealOrder() {
        leftBarBtnEffect(appealOrderBtn);
        changePane(new FindOrderPane(mainPane));
        currentBtn = appealOrderBtn;
        changeSliderPos(350);
    }

    @FXML
    private void showAddCredit() {
        leftBarBtnEffect(addCreditBtn);
        changePane(new FindUserPane(mainPane));
        currentBtn = addCreditBtn;
        changeSliderPos(395);
    }



    /**
     * 鼠标悬停按钮效果
     * @param button
     */
    private void mouseOnEffect(Button button) {
        leftBarEffect.buttonMouseOnEffect(button, leftBarBtnArr, currentBtn);
    }
    @FXML
    private void mouseOnPromotionBtn() {
        mouseOnEffect(managePromotionBtn);
    }
    @FXML
    private void mouseOnOrderListBtn() {
        mouseOnEffect(orderListBtn);
    }
    @FXML
    private void mouseOnAppealOrderBtn() {
        mouseOnEffect(appealOrderBtn);
    }
    @FXML
    private void mouseOnAddCreditBtn() {
        mouseOnEffect(addCreditBtn);
    }


    /**
     * 鼠标移出按钮效果
     * @param button
     */
    private void mouseOutEffect(Button button) {
        leftBarEffect.buttonMouseOutEffect(button, currentBtn);
    }
    @FXML
    private void mouseOutPromotionBtn() {
        mouseOutEffect(managePromotionBtn);
    }
    @FXML
    private void mouseOutOrderListBtn() {
        mouseOutEffect(orderListBtn);
    }
    @FXML
    private void mouseOutAppealOrderBtn() {
        mouseOutEffect(appealOrderBtn);
    }
    @FXML
    private void mouseOutAddCreditBtn() {
        mouseOutEffect(managePromotionBtn);
    }
}

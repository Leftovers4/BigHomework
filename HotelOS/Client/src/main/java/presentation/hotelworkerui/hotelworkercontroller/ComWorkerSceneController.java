package presentation.hotelworkerui.hotelworkercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.personnelbl.PersonnelBLService;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.*;
import presentation.loginui.loginscene.LoginScene;
import presentation.util.alert.AlertController;
import presentation.util.other.ChangePhoto;
import presentation.util.other.MyTimeLabel;
import presentation.util.other.LeftBarEffect;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 酒店主界面控制器，负责基本信息、浏览订单、录入可用客房等界面的跳转
 */
public class ComWorkerSceneController {


    @FXML private Pane mainPane;

    @FXML private Button hotelInfoBtn;
    @FXML private Button orderListBtn;
    @FXML private Button registerRoomBtn;
    @FXML private Button managePromotionBtn;
    @FXML private Button updateCheckInBtn;
    @FXML private Button updateOutBtn;

    @FXML private ImageView slider;
    //时间按钮
    @FXML private Label timeLabel;

    private Button currentBtn = null;
    //左边栏按钮集合
    private ArrayList<Button> leftBarBtnArr;
    LeftBarEffect leftBarEffect = new LeftBarEffect();

    private Stage stage;
    private AlertController alertController;
    public static long hotelID;

    private HotelBLService hotelBLService;
    private UserBLService userBLService;

    public void launch(Stage primaryStage, long hotelID){
        this.stage = primaryStage;
        this.hotelID = hotelID;
        alertController = new AlertController();
        currentBtn = hotelInfoBtn;
        hotelInfoBtn.setStyle("-fx-background-color: #0F81C7");
        mainPane.getChildren().add(new InfoPane(stage, mainPane));
        changeSliderPos(260);
        leftBarBtnArr = new ArrayList<>(Arrays.asList(hotelInfoBtn, orderListBtn, registerRoomBtn,
                managePromotionBtn, updateCheckInBtn, updateOutBtn));

        //实时刷新time
        MyTimeLabel.EnableShowTime(timeLabel);

        try {
            hotelBLService = new HotelBlServiceImpl();
            userBLService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        getAllPhoto();
    }


    /**
     * 更换Pane
     */
    private void changePane(Pane newPane){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(newPane);
    }

    /**
     * 侧边栏滑块位置改变
     * @param y
     */
    private void changeSliderPos(double y) {
        slider.setVisible(true);
        slider.setLayoutX(184);
        slider.setLayoutY(y);
    }


    /**
     * 鼠标点击按钮效果
     * @param button
     */
    private void leftBarBtnEffect(Button button) {
        leftBarEffect.buttonActionEffect(button, leftBarBtnArr);
    }

    @FXML
    private void showHotelInfo(){
        getAllPhoto();
        leftBarBtnEffect(hotelInfoBtn);
        changeSliderPos(260);
        changePane(new InfoPane(stage, mainPane));
        currentBtn = hotelInfoBtn;
    }

    /**
     * 显示订单列表
     */
    @FXML
    private void showOrderList(){
        getAllPhoto();
        leftBarBtnEffect(orderListBtn);
        changeSliderPos(305);
        changePane(new OrderListPane(mainPane));
        currentBtn = orderListBtn;
    }

    @FXML
    private void showRegisterRoom(){
        getAllPhoto();
        leftBarBtnEffect(registerRoomBtn);
        changeSliderPos(350);
        changePane(new RegisterRoomPane());
        currentBtn = registerRoomBtn;
    }

    @FXML
    private void showManagePromotion(){
        getAllPhoto();
        leftBarBtnEffect(managePromotionBtn);
        changeSliderPos(395);
        changePane(new ManagePromotionPane());
        currentBtn = managePromotionBtn;
    }

    @FXML
    private void showUpdateCheckIn(){
        getAllPhoto();
        leftBarBtnEffect(updateCheckInBtn);
        changeSliderPos(440);
        changePane(new UpdateCheckInPane(mainPane));
        currentBtn = updateCheckInBtn;
    }

    @FXML
    private void showUpdateOut(){
        getAllPhoto();
        leftBarBtnEffect(updateOutBtn);
        changeSliderPos(485);
        changePane(new UpdateOutPane(mainPane));
        currentBtn = updateOutBtn;
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
     * 鼠标悬停按钮效果
     * @param button
     */
    private void mouseOnEffect(Button button) {
        leftBarEffect.buttonMouseOnEffect(button, leftBarBtnArr, currentBtn);
    }
    @FXML
    private void mouseOnHotelInfo() {
        mouseOnEffect(hotelInfoBtn);
    }
    @FXML
    private void mouseOnOrderList() {
        mouseOnEffect(orderListBtn);
    }
    @FXML
    private void mouseOnRegisterRoom() {
        mouseOnEffect(registerRoomBtn);
    }
    @FXML
    private void mouseOnManagePromotion() {
        mouseOnEffect(managePromotionBtn);
    }
    @FXML
    private void mouseOnUpdateCheckin() {
        mouseOnEffect(updateCheckInBtn);
    }
    @FXML
    private void mouseOnUpdateOut() {
        mouseOnEffect(updateOutBtn);
    }

    /**
     * 鼠标移出按钮效果
     * @param button
     */
    private void mouseOutEffect(Button button) {
        leftBarEffect.buttonMouseOutEffect(button, currentBtn);
    }
    @FXML
    private void mouseOutHotelInfo() {
        mouseOutEffect(hotelInfoBtn);
    }
    @FXML
    private void mouseOutOrderList() {
        mouseOutEffect(orderListBtn);
    }
    @FXML
    private void mouseOutRegisterRoom() {
        mouseOutEffect(registerRoomBtn);
    }
    @FXML
    private void mouseOutManagePromotion() {
        mouseOutEffect(managePromotionBtn);
    }
    @FXML
    private void mouseOutUpdateCheckin() {
        mouseOutEffect(updateCheckInBtn);
    }
    @FXML
    private void mouseOutUpdateOut() {
        mouseOutEffect(updateOutBtn);
    }





    private void getAllPhoto() {
        String path = "C:/Leftovers/client/hotel/hotelImg/" + hotelID + "/";
        String userpath = "C:/Leftovers/client/hotel/userImage/";
        try {

            try {
                List<UserVO> userVOList = userBLService.getAllUsers();

                for (int i = 0; i<userVOList.size(); i++) {
                    if (userVOList.get(i).image != null) {
                        ChangePhoto.setImage(userpath, userVOList.get(i).username, userVOList.get(i).image);
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            HotelVO hotelVO = hotelBLService.viewBasicHotelInfo(hotelID);
            if (hotelVO.image != null) {
                ChangePhoto.setImage(path, hotelID, hotelVO.image);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

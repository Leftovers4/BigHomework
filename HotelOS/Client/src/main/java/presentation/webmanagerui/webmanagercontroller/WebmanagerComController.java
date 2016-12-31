package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import presentation.util.other.ChangePhoto;
import presentation.util.other.LeftBarEffect;
import presentation.webmanagerui.webmanagerscene.HotelManagePane;
import presentation.webmanagerui.webmanagerscene.HotelWorkerManagePane;
import presentation.webmanagerui.webmanagerscene.UserManagePane;
import presentation.webmanagerui.webmanagerscene.WebMarketerManagePane;
import vo.hotel.HotelVO;
import vo.user.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static presentation.util.other.MyTimeLabel.EnableShowTime;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmanagerComController {

    private Stage stage;

    @FXML private Pane mainPane;
    @FXML private Button hotelManageBtn;
    @FXML private Button userBtn;
    @FXML private Button hotelworkerBtn;
    @FXML private Button webmarketerBtn;
    @FXML private ImageView leftBarSlider;

    @FXML private Label timelabel;

    @FXML private SplitMenuButton topname;

    private Button currentBtn = null;
    LeftBarEffect leftBarEffect = new LeftBarEffect();
    private ArrayList<Button> buttons;
    private AlertController alertController;

    private HotelBLService hotelBLService;
    private UserBLService userBLService;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;

        changeSliderPos(260);

        try {
            hotelBLService = new HotelBlServiceImpl();
            userBLService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }

        currentBtn = hotelManageBtn;
        buttons = new ArrayList<>(Arrays.asList(hotelManageBtn, userBtn, hotelworkerBtn, webmarketerBtn));
        alertController = new AlertController();
        hotelManageBtn.setStyle("-fx-background-color: #0F81C7");
        mainPane.getChildren().add(new HotelManagePane(mainPane));
        EnableShowTime(timelabel);

        getPhoto();
    }

    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert())stage.close();
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
        leftBarSlider.setLayoutX(184);
        leftBarSlider.setLayoutY(y);
    }

    /**
     * 鼠标点击事件
     */
    @FXML
    private void hotelManageEvent() {
        currentBtn = hotelManageBtn;
        leftBarEffect.buttonActionEffect(hotelManageBtn, buttons);
        changeSliderPos(260);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new HotelManagePane(mainPane));
    }
    @FXML
    private void userManageEvent() {
        currentBtn = userBtn;
        leftBarEffect.buttonActionEffect(userBtn, buttons);
        changeSliderPos(305);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new UserManagePane(stage, mainPane));
    }
    @FXML
    private void hotelWorkerEvent() {
        currentBtn = hotelworkerBtn;
        leftBarEffect.buttonActionEffect(hotelworkerBtn, buttons);
        changeSliderPos(350);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new HotelWorkerManagePane(stage, mainPane));
    }
    @FXML
    private void webMarketerEvent() {
        currentBtn = webmarketerBtn;
        leftBarEffect.buttonActionEffect(webmarketerBtn, buttons);
        changeSliderPos(395);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new WebMarketerManagePane(stage, mainPane));
    }

    /**
     * 鼠标悬停事件
     */
    @FXML
    private void hotelManageMouseOn() {
        leftBarEffect.buttonMouseOnEffect(hotelManageBtn, buttons, currentBtn);
    }
    @FXML
    private void userManageMouseOn() {
        leftBarEffect.buttonMouseOnEffect(userBtn, buttons, currentBtn);
    }
    @FXML
    private void hotelWorkerMouseOn() {
        leftBarEffect.buttonMouseOnEffect(hotelworkerBtn, buttons, currentBtn);
    }
    @FXML
    private void webMarketerMouseOn() {
        leftBarEffect.buttonMouseOnEffect(webmarketerBtn, buttons, currentBtn);
    }

    /**
     * 鼠标移出事件
     */
    @FXML
    private void hotelManageMouseOut() {
        leftBarEffect.buttonMouseOutEffect(hotelManageBtn, currentBtn);
    }
    @FXML
    private void userManageMouseOut() {
        leftBarEffect.buttonMouseOutEffect(userBtn, currentBtn);
    }
    @FXML
    private void hotelWorkerMouseOut() {
        leftBarEffect.buttonMouseOutEffect(hotelworkerBtn, currentBtn);
    }
    @FXML
    private void webMarketerMouseOut() {
        leftBarEffect.buttonMouseOutEffect(webmarketerBtn, currentBtn);
    }


    private void getPhoto() {
        String pathhotel = "C:/Leftovers/client/webmanager/hotelImg/";
        String pathuser = "C:/Leftovers/client/webmanager/userImg/";

        try {
            List<HotelVO> hotelList = hotelBLService.viewFullHotelList();
            List<UserVO> userList = userBLService.getAllUsers();

            for (int i = 0; i<hotelList.size(); i++) {
                if (hotelList.get(i).image != null) {
                    ChangePhoto.setImage(pathhotel, hotelList.get(i).hotelID, hotelList.get(i).image);
                }
            }
            for (int j = 0; j<userList.size(); j++) {
                if (userList.get(j).image != null) {
                    ChangePhoto.setImage(pathuser, userList.get(j).username, userList.get(j).image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

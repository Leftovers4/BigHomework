package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.other.LeftBarEffect;
import presentation.webmanagerui.webmanagerscene.HotelManagePane;
import presentation.webmanagerui.webmanagerscene.HotelworkerManagePane;
import presentation.webmanagerui.webmanagerscene.UserManagePane;
import presentation.webmanagerui.webmanagerscene.WebmarketerManagePane;

import java.util.ArrayList;
import java.util.Arrays;

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

    private Button currentBtn = null;
    LeftBarEffect leftBarEffect = new LeftBarEffect();
    private ArrayList<Button> buttons;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;

        hotelManageBtn.setStyle("-fx-background-color: #0F81C7");

        buttons = new ArrayList<>(Arrays.asList(hotelManageBtn, userBtn, hotelworkerBtn, webmarketerBtn));

        primaryStage.setX(400);
        primaryStage.setY(200);

        mainPane.getChildren().add(new HotelManagePane(primaryStage, mainPane));

        EnableShowTime(timelabel);
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
     * 鼠标点击事件
     */
    @FXML
    private void hotelManageEvent() {
        currentBtn = hotelManageBtn;
        leftBarEffect.buttonActionEffect(hotelManageBtn, buttons);
        changeSliderPos(260);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new HotelManagePane(stage, mainPane));
    }
    @FXML
    private void userManageEvent() {
        currentBtn = userBtn;
        leftBarEffect.buttonActionEffect(userBtn, buttons);
        changeSliderPos(305);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UserManagePane(stage, mainPane));
    }
    @FXML
    private void hotelWorkerEvent() {
        currentBtn = hotelworkerBtn;
        leftBarEffect.buttonActionEffect(hotelworkerBtn, buttons);
        changeSliderPos(350);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new HotelworkerManagePane(stage, mainPane));
    }
    @FXML
    private void webMarketerEvent() {
        currentBtn = webmarketerBtn;
        leftBarEffect.buttonActionEffect(webmarketerBtn, buttons);
        changeSliderPos(395);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new WebmarketerManagePane(stage));
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
}

package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.*;

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

    private Stage stage;

    public void launch(Stage primaryStage){
        stage = primaryStage;
        mainPane.getChildren().add(new InfoPane(stage,mainPane));
    }

    /**
     * 更换Pane
     */
    private void changePane(Pane newPane){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(newPane);
    }

    @FXML
    private void showHotelInfo(){
        changePane(new InfoPane(stage,mainPane));
    }

    /**
     * 显示订单列表
     */
    @FXML
    private void showOrderList(){
        changePane(new OrderListPane(stage));
    }

    @FXML
    private void showRegisterRoom(){
        changePane(new RegisterRoomPane(stage));
    }

    @FXML
    private void showManagePromotion(){
        changePane(new ManagePromotionPane(stage));
    }

    @FXML
    private void showUpdateCheckIn(){
        changePane(new UpdateCheckInPane(stage,mainPane));
    }

    @FXML
    private void showUpdateOut(){
        changePane(new UpdateOutPane(stage,mainPane));
    }


}

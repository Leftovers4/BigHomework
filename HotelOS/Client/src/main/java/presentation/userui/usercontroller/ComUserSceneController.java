package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.InfoPane;
import presentation.userui.userscene.SearchHotelPane;

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

    public void launch(Stage primaryStage){
        mainPane.getChildren().add(new InfoPane(primaryStage));
        this.stage = primaryStage;
    }

    @FXML
    private void index() {
        leftBarSlider.setVisible(false);
    }
    @FXML
    private void userInfo() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(260);
        leftBarSlider.setLayoutX(193);
    }
    @FXML
    private void orderList() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(305);
        leftBarSlider.setLayoutX(193);
    }
    @FXML
    private void searchHotel() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(350);
        leftBarSlider.setLayoutX(193);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new SearchHotelPane(stage));
    }
    @FXML
    private void hotelRegistered() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(395);
        leftBarSlider.setLayoutX(193);
    }
}

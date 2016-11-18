package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.userui.userscene.UserInfoScene;

/**
 * Created by wyj on 2016/11/17.
 */
public class UserIndexSceneController {

    @FXML private Button indexBtn;
    @FXML private Button userInfoBtn;
    @FXML private Button orderListBtn;
    @FXML private Button searchHotelBtn;
    @FXML private Button hotelRegisteredBtn;
    @FXML private ImageView leftBarSlider;

    Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void index() {
        leftBarSlider.setVisible(false);
    }
    public void userInfo() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(260);
        leftBarSlider.setLayoutX(193);
    }

    public void orderList() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(305);
        leftBarSlider.setLayoutX(193);
    }

    public void searchHotel() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(350);
        leftBarSlider.setLayoutX(193);
    }

    public void hotelRegistered() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(395);
        leftBarSlider.setLayoutX(193);
    }

    /**
     * 关闭窗口
     */
    public void closeWindow() {
        stage.close();
    }

    /**
     * 最小化窗口
     */
    public void minimizeWindow() {
        stage.setIconified(true);
    }
}

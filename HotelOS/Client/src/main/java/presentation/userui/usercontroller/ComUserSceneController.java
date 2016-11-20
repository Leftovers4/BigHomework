package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    @FXML private Button currentBtn = null;

    public void launch(Stage primaryStage){
        mainPane.getChildren().add(new InfoPane(primaryStage));
        this.stage = primaryStage;
    }

    @FXML
    private void index() {
        leftBarSlider.setVisible(false);
        userInfoBtn.setStyle("-fx-background-color: transparent");
        orderListBtn.setStyle("-fx-background-color: transparent");
        searchHotelBtn.setStyle("-fx-background-color: transparent");
        hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        currentBtn = indexBtn;
    }
    @FXML
    private void userInfo() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(260);
        leftBarSlider.setLayoutX(193);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new InfoPane(stage));
        userInfoBtn.setStyle("-fx-background-color: #0F81C7");
        orderListBtn.setStyle("-fx-background-color: transparent");
        searchHotelBtn.setStyle("-fx-background-color: transparent");
        hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        currentBtn = userInfoBtn;
    }
    @FXML
    private void orderList() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(305);
        leftBarSlider.setLayoutX(193);
        orderListBtn.setStyle("-fx-background-color: #0F81C7");
        userInfoBtn.setStyle("-fx-background-color: transparent");
        searchHotelBtn.setStyle("-fx-background-color: transparent");
        hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        currentBtn = orderListBtn;
    }
    @FXML
    private void searchHotel() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(350);
        leftBarSlider.setLayoutX(193);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new SearchHotelPane(stage));
        searchHotelBtn.setStyle("-fx-background-color: #0F81C7");
        userInfoBtn.setStyle("-fx-background-color: transparent");
        orderListBtn.setStyle("-fx-background-color: transparent");
        hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        currentBtn = searchHotelBtn;
    }
    @FXML
    private void hotelRegistered() {
        leftBarSlider.setVisible(true);
        leftBarSlider.setLayoutY(395);
        leftBarSlider.setLayoutX(193);
        hotelRegisteredBtn.setStyle("-fx-background-color: #0F81C7");
        userInfoBtn.setStyle("-fx-background-color: transparent");
        orderListBtn.setStyle("-fx-background-color: transparent");
        searchHotelBtn.setStyle("-fx-background-color: transparent");
        currentBtn = hotelRegisteredBtn;
    }

    @FXML
    private void mouseOnUserInfo() {
        userInfoBtn.setStyle("-fx-background-color: deepskyblue");
        if(orderListBtn != currentBtn) {
            orderListBtn.setStyle("-fx-background-color: transparent");
        } else {
            orderListBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(searchHotelBtn != currentBtn) {
            searchHotelBtn.setStyle("-fx-background-color: transparent");
        } else {
            searchHotelBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(hotelRegisteredBtn != currentBtn) {
            hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        } else {
            hotelRegisteredBtn.setStyle("-fx-background-color: #0F81C7");
        }
    }

    @FXML
    private void mouseOnorderList() {
        orderListBtn.setStyle("-fx-background-color: deepskyblue");
        if(userInfoBtn != currentBtn) {
            userInfoBtn.setStyle("-fx-background-color: transparent");
        } else {
            userInfoBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(searchHotelBtn != currentBtn) {
            searchHotelBtn.setStyle("-fx-background-color: transparent");
        } else {
            searchHotelBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(hotelRegisteredBtn != currentBtn) {
            hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        } else {
            hotelRegisteredBtn.setStyle("-fx-background-color: #0F81C7");
        }
    }

    @FXML
    private void mouseOnSearchHotel() {
        searchHotelBtn.setStyle("-fx-background-color: deepskyblue");
        if(userInfoBtn != currentBtn) {
            userInfoBtn.setStyle("-fx-background-color: transparent");
        } else {
            userInfoBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(orderListBtn != currentBtn) {
            orderListBtn.setStyle("-fx-background-color: transparent");
        } else {
            orderListBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(hotelRegisteredBtn != currentBtn) {
            hotelRegisteredBtn.setStyle("-fx-background-color: transparent");
        } else {
            hotelRegisteredBtn.setStyle("-fx-background-color: #0F81C7");
        }
    }

    @FXML
    private void mouseOnRegisteredHotel() {
        hotelRegisteredBtn.setStyle("-fx-background-color: deepskyblue");
        if(userInfoBtn != currentBtn) {
            userInfoBtn.setStyle("-fx-background-color: transparent");
        } else {
            userInfoBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(orderListBtn != currentBtn) {
            orderListBtn.setStyle("-fx-background-color: transparent");
        } else {
            orderListBtn.setStyle("-fx-background-color: #0F81C7");
        }
        if(searchHotelBtn != currentBtn) {
            searchHotelBtn.setStyle("-fx-background-color: transparent");
        } else {
            searchHotelBtn.setStyle("-fx-background-color: #0F81C7");
        }
    }
}

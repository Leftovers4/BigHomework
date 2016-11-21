package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateCheckInPane;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderController {
    //选择线上入住后显现的组件
    @FXML private ImageView findOrderImg;
    @FXML private TextField idorNameField;
    @FXML private Button findByIDorNameBtn;
    private Stage stage;
    private Pane mainPane;
    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
    }

    @FXML private void closeWindow(){
        stage.close();
    }

    @FXML private void minWindow(){
        stage.setIconified(true);
    }

    @FXML private void back(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UpdateCheckInPane(stage,mainPane));
    }

    /**
     * 搜索订单
     */
    @FXML private void findOrder(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new OrderDetailPane(stage,mainPane));
    }
}

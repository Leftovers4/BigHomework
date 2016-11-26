package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.OrderDetailPaneController;
import vo.order.OrderVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderDetailPane extends Pane{

    public OrderDetailPane(Stage primaryStage, Pane mainPane,Boolean isCheckIn,Boolean isFromList,OrderVO orderVO) {
        loadFxml(primaryStage,mainPane,isCheckIn,isFromList,orderVO);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane,Boolean isCheckIn,Boolean isFromList, OrderVO orderVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelorderdetail.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OrderDetailPaneController orderDetailPaneController = fxmlLoader.getController();
        orderDetailPaneController.launch(primaryStage,mainPane,isCheckIn,isFromList,orderVO);
    }
}

package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.UpdateOrderInfoPaneController;
import vo.order.OrderVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class UpdateOrderInfoPane extends Pane{
    public UpdateOrderInfoPane(Stage primaryStage, Pane mainPane, Boolean isCheckIn,Boolean isFromList, OrderVO orderVO) {
        loadFxml(primaryStage,mainPane,isCheckIn,isFromList,orderVO);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane,Boolean isCheckIn,Boolean isFromList,OrderVO orderVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelupdateorderinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UpdateOrderInfoPaneController updateOrderInfoPaneController = fxmlLoader.getController();
        updateOrderInfoPaneController.launch(primaryStage,mainPane,isCheckIn,isFromList,orderVO);
    }
}

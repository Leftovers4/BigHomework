package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.UserReviewPaneController;
import vo.order.OrderVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/12/6.
 * Description :
 */
public class UserReviewPane extends Pane{
    public UserReviewPane(Pane mainPane, Boolean isCheckIn, Boolean isFromList, OrderVO orderVO) {
        loadFxml(mainPane,isCheckIn,isFromList, orderVO);
    }

    private void loadFxml(Pane mainPane,Boolean isCheckIn, Boolean isFromList, OrderVO orderVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hoteluserreview.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserReviewPaneController userReviewPaneController = fxmlLoader.getController();
        userReviewPaneController.launch(mainPane, isCheckIn, isFromList, orderVO);
    }
}

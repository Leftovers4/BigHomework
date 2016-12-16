package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import presentation.userui.usercontroller.CheckMyReviewController;

import java.io.IOException;

/**
 * Created by wyj on 2016/12/13.
 */
public class CheckMyReviewPane extends Pane {

    public CheckMyReviewPane(String orderID) {
        loadFxml(orderID);
    }

    private void loadFxml(String orderID) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/checkmyreview.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CheckMyReviewController checkMyReviewController = fxmlLoader.getController();
        checkMyReviewController.launch(orderID);
    }
}

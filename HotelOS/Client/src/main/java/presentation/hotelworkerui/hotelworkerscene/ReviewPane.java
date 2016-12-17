package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.ReviewPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class ReviewPane extends Pane{
    public ReviewPane(Pane mainPane, String rating, long hotelID) {
        loadFxml(mainPane, rating, hotelID);
    }

    private void loadFxml(Pane mainPane, String rating, long hotelID) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelreview.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReviewPaneController reviewPaneController = fxmlLoader.getController();
        reviewPaneController.launch(mainPane, rating, hotelID);
    }
}

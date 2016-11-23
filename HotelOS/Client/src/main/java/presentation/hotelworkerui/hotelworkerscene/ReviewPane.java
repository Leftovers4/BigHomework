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
    public ReviewPane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage,mainPane);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelreview.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReviewPaneController reviewPaneController = fxmlLoader.getController();
        reviewPaneController.launch(primaryStage,mainPane);
    }
}

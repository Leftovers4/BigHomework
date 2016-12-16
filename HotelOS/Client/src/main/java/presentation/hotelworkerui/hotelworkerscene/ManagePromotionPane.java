package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkercontroller.ManagePromotionPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class ManagePromotionPane extends Pane{
    public ManagePromotionPane() {
        loadFxml();
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelpromotion.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ManagePromotionPaneController managePromotionPaneController = fxmlLoader.getController();
        managePromotionPaneController.launch();
    }
}

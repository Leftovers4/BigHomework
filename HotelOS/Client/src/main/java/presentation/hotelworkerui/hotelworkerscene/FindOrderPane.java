package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.FindOrderPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderPane extends Pane{

    public FindOrderPane(Pane mainPane,Boolean isCheckIn) {
        loadFxml(mainPane,isCheckIn);
    }

    private void loadFxml(Pane mainPane,Boolean isCheckIn) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/hotelworker/hotelfindorder.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FindOrderPaneController findOrderPaneController = fxmlLoader.getController();
        findOrderPaneController.launch(mainPane,isCheckIn);
    }
}

package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.FindOrderController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderPane extends Pane{

    public FindOrderPane(Stage primaryStage,Pane mainPane,Boolean isCheckIn) {
        loadFxml(primaryStage,mainPane,isCheckIn);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane,Boolean isCheckIn) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelfindorder.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FindOrderController findOrderController = fxmlLoader.getController();
        findOrderController.launch(primaryStage,mainPane,isCheckIn);
    }
}

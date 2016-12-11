package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.OrderListPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderListPane extends Pane{

    public OrderListPane(Pane mainPane) {
        loadFxml(mainPane);
    }

    private void loadFxml(Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/hotelworker/hotelorderlist1.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OrderListPaneController orderListPaneController = fxmlLoader.getController();
        orderListPaneController.launch(mainPane);
    }
}

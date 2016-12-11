package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmarketerui.webmarketercontroller.OrderListPaneController;

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
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/webmarketer/weborderlist1.fxml"));
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

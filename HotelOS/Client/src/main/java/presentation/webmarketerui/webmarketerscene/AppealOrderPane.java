package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmarketerui.webmarketercontroller.AppealOrderPaneController;
import vo.order.OrderVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AppealOrderPane extends Pane{
    public AppealOrderPane(Pane mainPane, OrderVO orderVO) {
        loadFxml(mainPane, orderVO);
    }

    private void loadFxml(Pane mainPane, OrderVO orderVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/webmarketer/weborderappeal.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppealOrderPaneController appealOrderPaneController = fxmlLoader.getController();
        appealOrderPaneController.launch(mainPane, orderVO);
    }
}

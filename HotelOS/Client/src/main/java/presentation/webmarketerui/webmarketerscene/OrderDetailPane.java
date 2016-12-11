package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import presentation.webmarketerui.webmarketercontroller.OrderDetailPaneController;
import vo.order.OrderVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderDetailPane extends Pane{

    public OrderDetailPane(Pane mainPane,OrderVO orderVO) {
        loadFxml(mainPane,orderVO);
    }

    private void loadFxml(Pane mainPane, OrderVO orderVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/webmarketer/weborderdetail.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OrderDetailPaneController orderDetailPaneController = fxmlLoader.getController();
        orderDetailPaneController.launch(mainPane,orderVO);
    }
}

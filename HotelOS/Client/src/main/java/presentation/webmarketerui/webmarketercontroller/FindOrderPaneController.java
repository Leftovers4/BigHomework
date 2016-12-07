package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.AppealOrderPane;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class FindOrderPaneController {
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }


    //TODO 更换OrderVO
    @FXML
    private void findOrder() {
        mainPane.getChildren().remove(0);

        OrderPriceVO orderPriceVO = new OrderPriceVO(250, 200);
        OrderVO orderVO = new OrderVO();
        orderVO.hotelName = "如家酒店";
        orderVO.orderID = "12345678912345678";
        orderVO.username = "陆仁贾";
        orderVO.orderType = OrderType.Executed;
        orderVO.orderPriceVO = orderPriceVO;
        mainPane.getChildren().add(new AppealOrderPane(mainPane,orderVO));
    }

}

package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/12/6.
 * Description :
 */
public class UserReviewPaneController {

    private Pane mainPane;
    private OrderVO orderVO;
    private Boolean isCheckIn;
    private Boolean isFromList;
    public void launch(Pane mainPane, Boolean isCheckIn, Boolean isFromList, OrderVO orderVO) {
        this.mainPane = mainPane;
        this.orderVO = orderVO;
        this.isCheckIn = isCheckIn;
        this.isFromList = isFromList;
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new OrderDetailPane(mainPane,isCheckIn, isFromList,orderVO));
    }
}

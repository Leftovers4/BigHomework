package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateCheckInPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOrderInfoPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOutPane;
import presentation.util.AlertController;
import util.OrderType;
import util.RoomType;
import vo.order.OrderPriceVO;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.time.LocalDateTime;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderPaneController {
    //选择线上入住后显现的组件
    @FXML private ImageView findOrderImg;
    @FXML private TextField idorNameField;
    @FXML private Button findByIDorNameBtn;
    private Pane mainPane;
    private Boolean isCheckIn;
    private AlertController alertController;
    public void launch(Pane mainPane,Boolean isCheckIn) {
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        alertController = new AlertController();
        initLabel();
    }

    private void initLabel() {
        idorNameField.setPromptText(isCheckIn ? "更新入住信息，请输入客户名" : "更新退房信息，请输入客户名");
    }


    /**
     * 搜索订单
     */
    @FXML private void findOrder(){
        mainPane.getChildren().clear();
        OrderVO orderVO = new OrderVO();
        orderVO.orderID = "12345678912345678";
        orderVO.username = "网红";
        orderVO.orderPriceVO = new OrderPriceVO(250, 200);
        orderVO.orderType = OrderType.Unexecuted;

        ReviewVO reviewVO = new ReviewVO();
        reviewVO.reviewTime = LocalDateTime.of(2016, 11, 12, 21, 00);
        reviewVO.review = "那你提莫无敌非常非常棒棒 象牙蚌啊!";
        reviewVO.rating = 5;
        reviewVO.roomType = RoomType.Couple;
        reviewVO.orderID = orderVO.orderID;
        reviewVO.username = orderVO.username;

        OrderTimeVO orderTimeVO = new OrderTimeVO(LocalDateTime.of(2016, 11, 11, 11, 00), LocalDateTime.of(2016, 11, 11, 20, 00), null, null,
                null, LocalDateTime.of(2016, 11, 12, 21, 00), null, null);

        orderVO.reviewVO = reviewVO;
        orderVO.orderTimeVO = orderTimeVO;
        mainPane.getChildren().add(new UpdateOrderInfoPane(mainPane,isCheckIn,false,orderVO));
    }
}

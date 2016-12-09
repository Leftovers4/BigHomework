package presentation.hotelworkerui.hotelworkercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOrderInfoPane;
import presentation.util.alert.AlertController;
import util.OrderType;
import util.RoomType;
import vo.order.OrderPriceVO;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderPaneController {
    //选择线上入住后显现的组件
    @FXML private TextField idorNameField;
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
        idorNameField.setPromptText(isCheckIn ? "更新入住信息，请输入订单号" : "更新退房信息，请输入订单号");
    }


    /**
     * 搜索订单
     */
    @FXML private void findOrder(){
        if(idorNameField.getText().equals("")) alertController.showInputWrongAlert("订单号不能为空","查询失败");
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcherID = pattern.matcher(idorNameField.getText());
            if(matcherID.matches()){
                OrderVO orderVO = null;
                try {
                    OrderBLService orderBLService = new OrderBlServiceImpl();
                    orderVO = orderBLService.searchOrderByID(idorNameField.getText());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if(orderVO == null){
                    alertController.showNullWrongAlert("查询不到该订单,请重新输入","查询失败");
                }else {
                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(new UpdateOrderInfoPane(mainPane,isCheckIn,false,orderVO));
                }
            }else {
                alertController.showInputWrongAlert("订单号需输入数字,请重新输入","输入错误");
            }
        }
    }
}

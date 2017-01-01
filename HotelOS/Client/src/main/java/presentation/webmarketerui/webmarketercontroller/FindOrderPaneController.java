package presentation.webmarketerui.webmarketercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.AppealOrderPane;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/28.
 * Description : 查询订单界面控制器
 */
public class FindOrderPaneController {

    @FXML private TextField orderIDField;
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }


    @FXML
    private void findOrder() {
        if(orderIDField.getText().equals("")) alertController.showInputWrongAlert("订单号不能为空","查询失败");
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcherID = pattern.matcher(orderIDField.getText());
            if(matcherID.matches()){
                OrderVO orderVO = null;
                try {
                    OrderBLService orderBLService = new OrderBlServiceImpl();
                    orderVO = orderBLService.searchOrderByID(orderIDField.getText());
                } catch (RemoteException e) {
                    alertController.showNetConnectAlert();
                }
                if(orderVO == null){
                    alertController.showNullWrongAlert("查询不到该订单,请重新输入","查询失败");
                }else {
                    mainPane.getChildren().clear();
                    mainPane.getChildren().add(new AppealOrderPane(mainPane,orderVO));
                }
            }else {
                alertController.showInputWrongAlert("订单号需输入数字,请重新输入","输入错误");
            }
        }
    }

}

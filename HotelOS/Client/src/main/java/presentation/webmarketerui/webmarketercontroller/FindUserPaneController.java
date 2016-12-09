package presentation.webmarketerui.webmarketercontroller;

import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.AddCreditPane;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class FindUserPaneController {

    @FXML
    private TextField userNameField;

    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    //TODO 更好UserVo
    @FXML
    private void findUser() {
        if (userNameField.getText().equals("")) alertController.showInputWrongAlert("客户名不能为空", "查询失败");
        else {
            UserVO userVO = null;
            try {
                UserBLService userBLService = new UserBlServiceImpl();
                userVO = userBLService.viewBasicUserInfo(userNameField.getText());
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (userVO == null) {
                alertController.showNullWrongAlert("查询不到该客户,请重新输入", "查询失败");
            } else {
                mainPane.getChildren().clear();
                mainPane.getChildren().add(new AddCreditPane(mainPane, userVO));
            }
        }
    }

}

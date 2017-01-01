package presentation.webmarketerui.webmarketercontroller;

import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.AddCreditPane;
import util.ResultMessage;
import vo.user.UserVO;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/28.
 * Description : 信用充值界面控制器
 */
public class AddCreditPaneController {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label usertruenameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label birthDateLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label creditLabel;

    @FXML
    private TextField creditTextField;
    @FXML
    private Button addBtn;

    @FXML private ImageView userPhoto;

    private Pane mainPane;
    private AlertController alertController;
    private String userName;

    public void launch(Pane mainPane, UserVO userVO) {
        this.mainPane = mainPane;
        this.userName = userVO.username;
        alertController = new AlertController();
        initLabels(userVO);

        initPhoto(userVO);
    }

    /**
     * 初始化客户头像
     * @param userVO
     */
    private void initPhoto(UserVO userVO) {
        String newpath = "C:/Leftovers/client/hotel/userImage/";

        if (userVO != null) {
            if (userVO.image != null) {
                String path = newpath + userVO.username + ".jpg";
                File file = new File(newpath);
                if (file.exists()) {
                    Image image = new Image("file:///" + path);
                    userPhoto.setImage(image);
                }
            }
        }

    }

    private void initLabels(UserVO userVO) {
        usernameLabel.setText(userVO.username);
        usertruenameLabel.setText(userVO.name);
        sexLabel.setText(userVO.gender ? "男" : "女");
        birthDateLabel.setText(String.valueOf(userVO.memberVO.birthday));
        phoneLabel.setText(userVO.phone);
        creditLabel.setText(String.valueOf(userVO.creditVO.credit));
    }

    /**
     * 信用充值
     */
    @FXML
    private void addCredit() {
        if(judgeInput()){
            try {
                UserBLService userBLService = new UserBlServiceImpl();
                ResultMessage resultMessage = userBLService.topup(userName, Double.parseDouble(creditTextField.getText()));
                if(resultMessage == ResultMessage.Success) {
                    if(alertController.showUpdateSuccessAlert("信用充值成功","充值成功")){
                        UserVO newUserVO = userBLService.viewBasicUserInfo(userName);
                        mainPane.getChildren().clear();
                        mainPane.getChildren().add(new AddCreditPane(mainPane, newUserVO));
                    }
                }
            } catch (RemoteException e) {
                alertController.showNetConnectAlert();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    private boolean judgeInput() {
        if(creditTextField.getText().equals("")){
            alertController.showInputWrongAlert("请输入充值额度","充值失败");
            return false;
        }
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9].*$");
            Matcher matcherCredit = pattern.matcher(creditTextField.getText());
            if(!matcherCredit.matches()){
                alertController.showInputWrongAlert("充值额度必须为数字，请重新输入","充值失败");
                return false;
            }
        }
        return true;
    }

}

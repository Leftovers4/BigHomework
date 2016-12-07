package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import vo.user.UserVO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
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

    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane, UserVO userVO) {
        this.mainPane = mainPane;
        alertController = new AlertController();
        initLabels(userVO);
    }

    private void initLabels(UserVO userVO) {
        usernameLabel.setText(userVO.username);
        usertruenameLabel.setText(userVO.name);
        sexLabel.setText(userVO.gender ? "男" : "女");
        birthDateLabel.setText(String.valueOf(userVO.memberVO.birthday));
        phoneLabel.setText(userVO.phone);
        creditLabel.setText(String.valueOf(userVO.creditVO.credit));
    }

    @FXML
    private void addCredit() {
        if(judgeInput()){
            //TODO addcredit
        }
    }


    private boolean judgeInput() {
        if(creditTextField.getText().equals("")){
            alertController.showInputWrongAlert("请输入充值额度","充值失败");
            return false;
        }
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcherCredit = pattern.matcher(creditTextField.getText());
            if(!matcherCredit.matches()){
                alertController.showInputWrongAlert("充值额度必须为整数，请重新输入","充值失败");
                return false;
            }
        }
        return true;
    }

}

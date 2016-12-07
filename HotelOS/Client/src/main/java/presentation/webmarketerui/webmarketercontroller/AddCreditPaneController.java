package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import vo.user.UserVO;

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
    }

}

package presentation.loginui.logincontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import presentation.userui.userscene.ComUserScene;
import presentation.webmanagerui.webmanagerscene.WebmanagerComScene;
import util.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/6.
 * Description: 登录界面
 */
public class LoginSceneController {

    @FXML private Button changeToLogin;
    @FXML private Button changeToRegister;
    @FXML private Label slider;
    @FXML private Button buttonLogin;
    @FXML private Button buttonRegister;
    @FXML private TextField loginUsername;
    @FXML private PasswordField loginPassword;
    @FXML private Button managerEntrance;
    @FXML private Button userEntrance;
    @FXML private Label nameLabel;
    @FXML private Label passwordLabel;
    @FXML private ImageView namePic;
    @FXML private ImageView passwordPic;
    @FXML private Pane movingSection;

    private UserBlServiceImpl userBlService;

    //用于客户登录和工作人员登录界面切换
    private boolean isFromLogin = true;

    Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;

        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录、注册的切换
     * 滑块slider特效
     *
     * @param x
     * @param showTag
     * @param hideTag
     * @param showButton
     * @param hideButton
     */
    private void changeLoginAndRegister(int x, Button showTag, Button hideTag, Button showButton, Button hideButton) {
        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        KeyValue kv = new KeyValue(slider.layoutXProperty(), x);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        showTag.setTextFill(Color.DEEPSKYBLUE);
        hideTag.setTextFill(Color.BLACK);
        showButton.setVisible(true);
        hideButton.setVisible(false);
        loginUsername.setText("");
        loginPassword.setText("");
    }
    @FXML
    private void changeToLogin() {
        changeLoginAndRegister(236, changeToLogin, changeToRegister, buttonLogin, buttonRegister);
        namePic.setVisible(true);
        passwordPic.setVisible(true);
        nameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        isFromLogin = true;
    }
    @FXML
    private void changeToRegister() {
        changeLoginAndRegister(329, changeToRegister, changeToLogin, buttonRegister, buttonLogin);
        namePic.setVisible(false);
        passwordPic.setVisible(false);
        nameLabel.setVisible(true);
        passwordLabel.setVisible(true);
        isFromLogin = false;
    }

    /**
     * 客户登录注册界面切换至酒店工作人员界面特效
     */
    @FXML
    private void changeToManager() {
        changeToLogin.setVisible(false);
        changeToRegister.setVisible(false);
        slider.setVisible(false);
        managerEntrance.setVisible(false);
        userEntrance.setVisible(true);
        loginUsername.setText("");
        loginPassword.setText("");
        if (!isFromLogin) {
            nameLabel.setVisible(false);
            namePic.setVisible(true);
            passwordLabel.setVisible(false);
            passwordPic.setVisible(true);
            buttonRegister.setVisible(false);
            buttonLogin.setVisible(true);
        }

        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        KeyValue kvLoginBtn = new KeyValue(movingSection.layoutYProperty(), 165);
        KeyFrame kfLoginBtn = new KeyFrame(Duration.millis(400), kvLoginBtn);
        timeline.getKeyFrames().add(kfLoginBtn);
        timeline.play();

    }

    /**
     * 酒店工作人员登录界面切换至客户登陆注册界面
     */
    @FXML
    private void changeToUser() {
        changeToLogin.setVisible(true);
        changeToRegister.setVisible(true);
        slider.setVisible(true);
        managerEntrance.setVisible(true);
        userEntrance.setVisible(false);
        loginUsername.setText("");
        loginPassword.setText("");
        if (!isFromLogin) {
            buttonLogin.setVisible(false);
            buttonRegister.setVisible(true);
            nameLabel.setVisible(true);
            passwordLabel.setVisible(true);
            namePic.setVisible(false);
            passwordPic.setVisible(false);
        }

        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        KeyValue kvLoginBtn = new KeyValue(movingSection.layoutYProperty(), 195);
        KeyFrame kfLoginBtn = new KeyFrame(Duration.millis(400), kvLoginBtn);
        timeline.getKeyFrames().add(kfLoginBtn);
        timeline.play();
    }

    /**
     * 关闭窗口
     */
    @FXML
    private void closeWindow() {
        stage.close();
    }

    /**
     * 最小化窗口
     */
    @FXML
    private void minimizeWindow() {
        stage.setIconified(true);
    }

    /**
     * 客户登录
     */
    @FXML
    private void Login() {

        try {
            ResultMessage resultMessage = userBlService.login(loginUsername.getText(), loginPassword.getText());

            if (resultMessage == ResultMessage.UsernameNotExisted) {
                System.out.println("not exits");
            } else if (resultMessage == ResultMessage.PasswordWrong) {
                System.out.println("wrong password");
            } else if (resultMessage == ResultMessage.Success) {
                stage.setScene(new ComUserScene(new Group(),stage, loginUsername.getText()));
                System.out.println("success");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void webmanagerLogin() {
        stage.setScene(new WebmanagerComScene(new Group(), stage));
    }


    /**
     * 注册新用户
     */
    @FXML
    private void userRegister() {
        try {
            ResultMessage resultMessage = userBlService.registerUser(loginUsername.getText(), loginPassword.getText());

            if (resultMessage == ResultMessage.DataExisted) {
                System.out.printf("exits");
            }

            loginUsername.setText(null);
            loginPassword.setText(null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}

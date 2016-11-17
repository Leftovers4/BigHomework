package presentation.loginui.logincontroller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by wyj on 2016/11/6.
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

    //用于客户登录和工作人员登录界面切换
    private boolean isFromLogin = true;

    Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
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
    public void changeToLogin() {
        changeLoginAndRegister(236, changeToLogin, changeToRegister, buttonLogin, buttonRegister);
        namePic.setVisible(true);
        passwordPic.setVisible(true);
        nameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        isFromLogin = true;
    }
    public void changeToRegister() {
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
    public void changeToManager() {
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
        KeyValue kvLoginBtn = new KeyValue(buttonLogin.layoutYProperty(), 290);
        KeyFrame kfLoginBtn = new KeyFrame(Duration.millis(400), kvLoginBtn);
        timeline.getKeyFrames().add(kfLoginBtn);

        KeyValue kvRegisterBtn = new KeyValue(buttonRegister.layoutYProperty(), 290);
        KeyFrame kfRegisterBtn = new KeyFrame(Duration.millis(400), kvRegisterBtn);
        timeline.getKeyFrames().add(kfRegisterBtn);

        KeyValue kvNamePic = new KeyValue(namePic.layoutYProperty(), 190);
        KeyFrame kfNamePic = new KeyFrame(Duration.millis(400), kvNamePic);
        timeline.getKeyFrames().add(kfNamePic);

        KeyValue kvPasswordPic = new KeyValue(passwordPic.layoutYProperty(), 240);
        KeyFrame kfPasswordPic = new KeyFrame(Duration.millis(400), kvPasswordPic);
        timeline.getKeyFrames().add(kfPasswordPic);

        KeyValue kvNameLabel = new KeyValue(nameLabel.layoutYProperty(), 190);
        KeyFrame kfNameLabel = new KeyFrame(Duration.millis(400), kvNameLabel);
        timeline.getKeyFrames().add(kfNameLabel);

        KeyValue kvPasswordLabel = new KeyValue(passwordLabel.layoutYProperty(), 240);
        KeyFrame kfPasswordLabel = new KeyFrame(Duration.millis(400), kvPasswordLabel);
        timeline.getKeyFrames().add(kfPasswordLabel);

        KeyValue kvNameText = new KeyValue(loginUsername.layoutYProperty(), 190);
        KeyFrame kfNameText = new KeyFrame(Duration.millis(400), kvNameText);
        timeline.getKeyFrames().add(kfNameText);

        KeyValue kvPasswordText = new KeyValue(loginPassword.layoutYProperty(), 240);
        KeyFrame kfPasswordText = new KeyFrame(Duration.millis(400), kvPasswordText);
        timeline.getKeyFrames().add(kfPasswordText);
        timeline.play();

    }

    /**
     * 酒店工作人员登录界面切换至客户登陆注册界面
     */
    public void changeToUser() {
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
        KeyValue kvLoginBtn = new KeyValue(buttonLogin.layoutYProperty(), 320);
        KeyFrame kfLoginBtn = new KeyFrame(Duration.millis(400), kvLoginBtn);
        timeline.getKeyFrames().add(kfLoginBtn);

        KeyValue kvRegisterBtn = new KeyValue(buttonRegister.layoutYProperty(), 320);
        KeyFrame kfRegisterBtn = new KeyFrame(Duration.millis(400), kvRegisterBtn);
        timeline.getKeyFrames().add(kfRegisterBtn);

        KeyValue kvNamePic = new KeyValue(namePic.layoutYProperty(), 220);
        KeyFrame kfNamePic = new KeyFrame(Duration.millis(400), kvNamePic);
        timeline.getKeyFrames().add(kfNamePic);

        KeyValue kvPasswordPic = new KeyValue(passwordPic.layoutYProperty(), 270);
        KeyFrame kfPasswordPic = new KeyFrame(Duration.millis(400), kvPasswordPic);
        timeline.getKeyFrames().add(kfPasswordPic);

        KeyValue kvNameLabel = new KeyValue(nameLabel.layoutYProperty(), 220);
        KeyFrame kfNameLabel = new KeyFrame(Duration.millis(400), kvNameLabel);
        timeline.getKeyFrames().add(kfNameLabel);

        KeyValue kvPasswordLabel = new KeyValue(passwordLabel.layoutYProperty(), 270);
        KeyFrame kfPasswordLabel = new KeyFrame(Duration.millis(400), kvPasswordLabel);
        timeline.getKeyFrames().add(kfPasswordLabel);

        KeyValue kvNameText = new KeyValue(loginUsername.layoutYProperty(), 220);
        KeyFrame kfNameText = new KeyFrame(Duration.millis(400), kvNameText);
        timeline.getKeyFrames().add(kfNameText);

        KeyValue kvPasswordText = new KeyValue(loginPassword.layoutYProperty(), 270);
        KeyFrame kfPasswordText = new KeyFrame(Duration.millis(400), kvPasswordText);
        timeline.getKeyFrames().add(kfPasswordText);
        timeline.play();
    }

    /**
     * 关闭窗口
     */
    public void closeWindow() {
        stage.close();
    }

    /**
     * 最小化窗口
     */
    public void minimizeWindow() {
        stage.setIconified(true);
    }
}

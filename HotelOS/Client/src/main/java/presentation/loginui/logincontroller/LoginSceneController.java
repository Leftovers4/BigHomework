package presentation.loginui.logincontroller;

import bl.personnelbl.PersonnelBLService;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import presentation.hotelworkerui.hotelworkerscene.ComWorkerScene;
import presentation.userui.userscene.ComUserScene;
import presentation.util.alert.AlertController;
import presentation.webmanagerui.webmanagerscene.WebmanagerComScene;
import presentation.webmarketerui.webmarketerscene.ComMarketerScene;
import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/6.
 * Description: 登录界面
 */
public class LoginSceneController {

    @FXML private Button buttonLogin;
    @FXML private Button buttonRegister;
    @FXML private TextField loginUsername;
    @FXML private PasswordField loginPassword;
    @FXML private Button managerEntrance;
    @FXML private Button userEntrance;

    @FXML private PasswordField confirmPasswordField;
    @FXML private Hyperlink toregisterBtn;
    @FXML private Hyperlink tologinBtn;

    private UserBLService userBlService;
    private PersonnelBLService personnelBLService;

    private AlertController alertController;

    private boolean isFromLogin = true;
    private String currentUser;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;

        currentUser = "user";

        alertController = new AlertController();

        try {
            userBlService = new UserBlServiceImpl();
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录、注册的切换
     * 滑块slider特效
     * @param
     * @param
     */
    private void changeLoginAndRegister(boolean isfromtogintoregister) {
        if (isfromtogintoregister) {
            Timeline timeline = new Timeline();
            timeline.setAutoReverse(false);
            KeyValue kv1 = new KeyValue(loginUsername.layoutYProperty(), 29);
            KeyFrame kf1= new KeyFrame(Duration.millis(400), kv1);
            KeyValue kv2 = new KeyValue(loginPassword.layoutYProperty(), 89);
            KeyFrame kf2 = new KeyFrame(Duration.millis(400), kv2);
            KeyValue kv3 = new KeyValue(buttonLogin.layoutYProperty(), 237);
            KeyFrame kf3 = new KeyFrame(Duration.millis(400), kv3);
            KeyValue kv4 = new KeyValue(buttonRegister.layoutYProperty(), 237);
            KeyFrame kf4 = new KeyFrame(Duration.millis(400), kv4);
            timeline.getKeyFrames().addAll(kf1, kf2, kf3, kf4);
            timeline.play();
            buttonLogin.setVisible(false);
            buttonRegister.setVisible(true);
        } else {
            confirmPasswordField.setVisible(false);
            Timeline timeline = new Timeline();
            timeline.setAutoReverse(false);
            KeyValue kv1 = new KeyValue(loginUsername.layoutYProperty(), 57);
            KeyFrame kf1= new KeyFrame(Duration.millis(400), kv1);
            KeyValue kv2 = new KeyValue(loginPassword.layoutYProperty(), 128);
            KeyFrame kf2 = new KeyFrame(Duration.millis(400), kv2);
            KeyValue kv3 = new KeyValue(buttonLogin.layoutYProperty(), 226);
            KeyFrame kf3 = new KeyFrame(Duration.millis(400), kv3);
            KeyValue kv4 = new KeyValue(buttonRegister.layoutYProperty(), 226);
            KeyFrame kf4 = new KeyFrame(Duration.millis(400), kv4);
            timeline.getKeyFrames().addAll(kf1, kf2, kf3, kf4);
            timeline.play();
            buttonRegister.setVisible(false);
            buttonLogin.setVisible(true);
        }
        loginUsername.clear();
        loginPassword.clear();
        confirmPasswordField.clear();
    }
    @FXML
    private void changeToLogin() {
        changeLoginAndRegister(false);
        tologinBtn.setVisible(false);
        toregisterBtn.setVisible(true);
        confirmPasswordField.setVisible(false);
        buttonLogin.setVisible(true);
        buttonRegister.setVisible(false);
        isFromLogin = true;
    }
    @FXML
    private void changeToRegister() {
        changeLoginAndRegister(true);
        confirmPasswordField.setVisible(true);
        tologinBtn.setVisible(true);
        toregisterBtn.setVisible(false);
        buttonRegister.setVisible(true);
        buttonLogin.setVisible(false);
        isFromLogin = false;
    }

    /**
     * 客户登录注册界面切换至酒店工作人员界面特效
     */
    @FXML
    private void changeToManager() {
        managerEntrance.setVisible(false);
        userEntrance.setVisible(true);
        loginUsername.clear();
        loginPassword.clear();
        confirmPasswordField.clear();
        confirmPasswordField.setVisible(false);
        buttonLogin.setVisible(true);
        buttonRegister.setVisible(false);
        toregisterBtn.setVisible(false);
        tologinBtn.setVisible(false);
        currentUser = "worker";
        loginUsername.setPromptText("账号");

        changeLoginAndRegister(false);
    }

    /**
     * 酒店工作人员登录界面切换至客户登陆注册界面
     */
    @FXML
    private void changeToUser() {

        managerEntrance.setVisible(true);
        userEntrance.setVisible(false);
        loginUsername.clear();
        loginPassword.clear();
        confirmPasswordField.clear();
        buttonLogin.setVisible(true);
        buttonRegister.setVisible(false);
        confirmPasswordField.setVisible(false);
        tologinBtn.setVisible(true);
        toregisterBtn.setVisible(true);
        currentUser = "user";
        loginUsername.setPromptText("用户名");

        changeLoginAndRegister(false);
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
     * 登录
     */
    @FXML
    private void Login() {

        try {
            if (currentUser.equals("user")) {
                if (!loginUsername.getText().equals("") && !loginPassword.getText().equals("")) {
                    ResultMessage resultMessage = userBlService.login(loginUsername.getText(), loginPassword.getText());

                    if (resultMessage == ResultMessage.UsernameNotExisted) {
                        alertController.showInputWrongAlert("用户名不存在！", "登录失败");
                        System.out.println("not exits");
                    } else if (resultMessage == ResultMessage.PasswordWrong) {
                        alertController.showInputWrongAlert("密码错误！", "登录失败");
                        System.out.println("wrong password");
                    } else if (resultMessage == ResultMessage.Success) {
                        stage.setScene(new ComUserScene(new Group(), stage, loginUsername.getText()));
                        centerStage(stage);
                        System.out.println("success");
                    }
                } else {
                    alertController.showInputWrongAlert("请输入用户名和密码", "错误提示");
                }

            } else {
                if (!loginUsername.getText().equals("") && !loginPassword.getText().equals("")) {
                    if (isFormatTrue(loginUsername.getText())) {
                        ResultMessage resultMessage = personnelBLService.login(Integer.valueOf(loginUsername.getText()), loginPassword.getText());

                        if (resultMessage == ResultMessage.Success) {
                            System.out.println("personnel login success");
                            PersonnelVO personnelVO = personnelBLService.searchPersonnelByID(Integer.valueOf(loginUsername.getText()));
                            if(personnelVO.personnelType == PersonnelType.HotelWorker){
                                stage.setScene(new ComWorkerScene(new Group(), stage, personnelVO.hotelID));
                                centerStage(stage);
                            }else if(personnelVO.personnelType == PersonnelType.WebMarketer){
                                stage.setScene(new ComMarketerScene(new Group(), stage));
                                centerStage(stage);
                            }else {
                                stage.setScene(new WebmanagerComScene(new Group(), stage));
                                centerStage(stage);
                            }

                        } else {
                            alertController.showInputWrongAlert("登录失败！", "登录失败");
                            System.out.println("personnel login failed");
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 注册新用户
     */
    @FXML
    private void userRegister() {
        if (!loginUsername.getText().equals("") && !loginPassword.getText().equals("") && !confirmPasswordField.getText().equals("")) {

            if (loginPassword.getText().equals(confirmPasswordField.getText())) {
                try {
                    ResultMessage resultMessage = userBlService.registerUser(loginUsername.getText(), loginPassword.getText());

                    if (resultMessage == ResultMessage.DataExisted) {
                        alertController.showInputWrongAlert("用户名已存在！", "注册失败");
                        confirmPasswordField.clear();
                        System.out.printf("exits");
                    } else if (resultMessage == ResultMessage.Success) {
                        alertController.showUpdateSuccessAlert("注册成功！", "注册成功");
                        changeToLogin();
                    }

                    loginUsername.setText(null);
                    loginPassword.setText(null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                alertController.showInputWrongAlert("密码不一致", "错误提示");
            }
        } else {
            alertController.showInputWrongAlert("请输入用户名和密码", "错误提示");
        }

    }

    private void centerStage(Stage newStage){
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }

    private boolean isFormatTrue(String str) {
        char ch[] = str.toCharArray();
        boolean result = true;
        for (int i = 0; i<ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                result = result && true;
            } else {
                result = result && false;
                break;
            }
        }

        return result;
    }
}

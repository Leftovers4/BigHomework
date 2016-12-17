package presentation.userui.usercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.InfoPane;
import presentation.util.alert.AlertController;
import presentation.util.alert.InputWrongAlert;
import presentation.util.other.JudgeInput;
import util.MemberType;
import util.ResultMessage;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by wyj on 2016/11/25.
 */
public class RegisterCommonVIPController {

    private Stage stage;
    private String userID;
    private Pane mainPane;
    private ImageView topbarphoto;
    private ArrayList<Button> leftBarArr;

    @FXML private Button registerCommonBtn;
    @FXML private CheckBox confirmCommonvipInfo;

    @FXML private TextField usernameField;
    @FXML private RadioButton SexMan;
    @FXML private RadioButton SexWoman;
    @FXML private DatePicker birthdayPicker;
    @FXML private TextField phoneField;

    private UserBlServiceImpl userBlService;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, String userID, ImageView topbarphoto, ArrayList<Button> leftBarArr) {
        this.stage = primaryStage;
        this.userID = userID;
        this.mainPane = mainPane;
        this.topbarphoto = topbarphoto;
        this.leftBarArr = leftBarArr;

        alertController = new AlertController();

        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        try {
            UserVO userVO = userBlService.viewBasicUserInfo(userID);

            usernameField.setText(userVO.username);
            if (userVO.gender) {
                SexMan.setSelected(true);
            } else {
                SexWoman.setSelected(true);
            }
            phoneField.setText(userVO.phone);
            birthdayPicker.setValue(userVO.memberVO.birthday);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 核对信息
     */
    @FXML
    private void checkCommonvipInfo() {
        if (confirmCommonvipInfo.isSelected()) {
            registerCommonBtn.setDisable(false);
        } else {
            registerCommonBtn.setDisable(true);
        }
    }

    /**
     * 确认注册普通会员
     */
    @FXML
    private void confirmRegister() {
        boolean isempty = isEmpty();
        boolean isphoneok = JudgeInput.judgePhoneNumber(phoneField.getText());

        UserVO userVO = new UserVO();

        if (!isempty && isphoneok) {
            userVO.username = userID;
            userVO.name = usernameField.getText();
            userVO.gender = SexMan.isSelected();
            userVO.memberVO.birthday = birthdayPicker.getValue();
            userVO.phone = phoneField.getText();

            try {
                ResultMessage resultMessage = userBlService.registerNormalMember(userVO);
                if (resultMessage == ResultMessage.Success) {
                    System.out.println("success" + "=======================");

                    if (userVO.memberVO.memberType == MemberType.None) {
                        userVO.memberVO.memberType = MemberType.NormalMember;
                    } else if (userVO.memberVO.memberType == MemberType.EnterpriseMember) {
                        userVO.memberVO.memberType = MemberType.Both;
                    }

                    alertController.showUpdateSuccessAlert("注册成功！", "成功提示");

                } else if (resultMessage == ResultMessage.UsernameNotExisted) {
                    System.out.println("common vip exits");
                    alertController.showNullWrongAlert("用户不存在！", "错误提示");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new InfoPane(stage, mainPane, topbarphoto, userID, leftBarArr));

        } else if (!isempty && !isphoneok) {
            alertController.showInputWrongAlert("联系方式格式错误！", "格式错误");
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "格式错误");
        }
    }

    /**
     * 判断需要填写的内容是否为空
     * @return
     */
    private boolean isEmpty() {
        boolean username = usernameField.getText().equals("");
        boolean birthday = birthdayPicker.getValue().toString().equals("");
        boolean sex = true;
        if (SexMan.isSelected() || SexWoman.isSelected()) {
            sex = false;
        }
        return username || sex || birthday;
    }

}

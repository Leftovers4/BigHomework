package presentation.userui.usercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import presentation.util.alert.InputWrongAlert;
import util.MemberType;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/25.
 */
public class RegisterCompanyVIPController {

    private Stage stage;
    private String userID;

    @FXML private CheckBox confirmCompanyvipInfo;
    @FXML private Button registerCompanyBtn;

    @FXML private TextField usernameField;
    @FXML private RadioButton sexMan;
    @FXML private RadioButton sexWoman;
    @FXML private DatePicker birthdayPicker;
    @FXML private TextField phoneField;
    @FXML private TextField enterpriseField;

    private UserBlServiceImpl userBlService;

    public void launch(Stage primaryStage, String userID) {
        this.stage = primaryStage;
        this.userID = userID;

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

            usernameField.setText(userVO.name);
            if (userVO.gender) {
                sexMan.setSelected(true);
            } else {
                sexWoman.setSelected(true);
            }
            birthdayPicker.setValue(userVO.memberVO.birthday);
            phoneField.setText(userVO.phone);
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
    private void checkCompanyvipInfo() {
        if (confirmCompanyvipInfo.isSelected()) {
            registerCompanyBtn.setDisable(false);
        } else {
            registerCompanyBtn.setDisable(true);
        }
    }

    /**
     * 确认注册企业会员
     */
    @FXML
    private void confirmRegister() {
        boolean isempty = isEmpty();
        boolean isphoneok = judgePhoneNumber(phoneField.getText());

        UserVO userVO = new UserVO();

        if (!isempty && isphoneok) {
            userVO.name = usernameField.getText();
            userVO.gender = sexMan.isSelected();
            userVO.phone = phoneField.getText();
            userVO.memberVO.birthday = birthdayPicker.getValue();
            userVO.memberVO.enterprise = enterpriseField.getText();

            if (userVO.memberVO.memberType == MemberType.None) {
                userVO.memberVO.memberType = MemberType.EnterpriseMember;
            } else if (userVO.memberVO.memberType == MemberType.NormalMember) {
                userVO.memberVO.memberType = MemberType.Both;
            }
        } else if (!isempty && !isphoneok) {
            new InputWrongAlert("联系方式格式错误", "格式错误").showAndWait();
        } else {
            new InputWrongAlert("信息填写不完整", "保存失败").showAndWait();
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
        if (sexMan.isSelected() || sexWoman.isSelected()) {
            sex = false;
        }
        return username || sex || birthday;
    }

    /**
     * 判断输入的联系方式是否符合格式
     * @param str
     * @return
     */
    private boolean judgePhoneNumber(String str) {
        boolean judge = true;
        int length = str.length();
        if (length != 11) {
            judge = false;
        }
        for(int i = 0; i<length; i++) {
            int temp = str.charAt(i) - '0';
            if (temp >= 0 && temp <= 9) {
                judge = judge && true;
            } else {
                judge = judge && false;
            }
        }
        return judge;
    }
}

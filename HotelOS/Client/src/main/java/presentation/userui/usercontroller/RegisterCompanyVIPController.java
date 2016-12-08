package presentation.userui.usercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    }

    private void initialData() {
        try {
            UserVO userVO = userBlService.viewBasicUserInfo(userID);
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

    @FXML
    private void checkCompanyvipInfo() {
        if (confirmCompanyvipInfo.isSelected()) {
            registerCompanyBtn.setDisable(false);
        } else {
            registerCompanyBtn.setDisable(true);
        }
    }
}

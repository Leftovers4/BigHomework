package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {

    private Stage stage;

    @FXML private TextField userIdField;
    @FXML private TextField userNameField;
    @FXML private RadioButton sexMan;
    @FXML private RadioButton sexWoman;
    @FXML private DatePicker birthPicker;
    @FXML private TextField phoneField;
    @FXML private Button saveInfo;
    @FXML private Button cleanAllBtn;

    @FXML private Label userIdLabel;
    @FXML private Label usernameLabel;
    @FXML private Label userSex;
    @FXML private Label birthDate;
    @FXML private Label phone;
    @FXML private Button registerCommonvipBtn;
    @FXML private Button registerCompanyvipBtn;
    @FXML private Button editInfoBtn;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void editUserInfo() {
        userIdField.setVisible(true);
        userNameField.setVisible(true);
        sexMan.setVisible(true);
        sexWoman.setVisible(true);
        birthPicker.setVisible(true);
        phoneField.setVisible(true);
        saveInfo.setVisible(true);
        cleanAllBtn.setVisible(true);

        userIdLabel.setVisible(false);
        usernameLabel.setVisible(false);
        userSex.setVisible(false);
        birthDate.setVisible(false);
        phone.setVisible(false);
        registerCommonvipBtn.setVisible(false);
        registerCompanyvipBtn.setVisible(false);
        editInfoBtn.setVisible(false);
    }

    @FXML
    private void saveUserInfo() {
        userIdField.setVisible(false);
        userNameField.setVisible(false);
        sexMan.setVisible(false);
        sexWoman.setVisible(false);
        birthPicker.setVisible(false);
        phoneField.setVisible(false);
        saveInfo.setVisible(false);
        cleanAllBtn.setVisible(false);

        userIdLabel.setVisible(true);
        usernameLabel.setVisible(true);
        userSex.setVisible(true);
        birthDate.setVisible(true);
        phone.setVisible(true);
        registerCommonvipBtn.setVisible(true);
        registerCompanyvipBtn.setVisible(true);
        editInfoBtn.setVisible(true);
    }

    @FXML
    private void cleanAll() {
        userIdField.setText("");
        userNameField.setText("");
        birthPicker.setValue(null);
        sexMan.setSelected(false);
        sexWoman.setSelected(false);
        phoneField.setText("");
    }
}

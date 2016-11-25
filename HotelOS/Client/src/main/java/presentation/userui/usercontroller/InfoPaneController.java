package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.userui.userscene.CreditRecordPane;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {

    private Stage stage;
    private Pane mainPane;

    @FXML private TextField userIdField;
    @FXML private TextField userNameField;
    @FXML private RadioButton sexMan;
    @FXML private RadioButton sexWoman;
    @FXML private DatePicker birthPicker;
    @FXML private TextField phoneField;
    @FXML private Button saveInfo;
    @FXML private Button cleanAllBtn;

    @FXML private ImageView userPhoto;
    @FXML private ImageView topBarPhoto;

    @FXML private Label userIdLabel;
    @FXML private Label usernameLabel;
    @FXML private Label userSex;
    @FXML private Label birthDate;
    @FXML private Label phone;
    @FXML private Button registerCommonvipBtn;
    @FXML private Button registerCompanyvipBtn;
    @FXML private Button editInfoBtn;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
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

    @FXML
    private void changePhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择图片");
        File selectedDirectory = fileChooser.showOpenDialog(stage);

        if (selectedDirectory!=null) {
            try {
                String newpath = "C:/Leftovers/Cache/userPhoto/";
                String fileName = newpath + selectedDirectory.getName().toString();
                File testFile = new File(fileName);
                if (!testFile.exists()) {
                    File file = new File(newpath);
                    file.mkdirs();
                    FileInputStream input = null;
                    FileOutputStream output = null;

                    input = new FileInputStream(selectedDirectory);
                    output = new FileOutputStream(fileName);

                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }

                    output.flush();
                    output.close();
                    input.close();
                }
                Image image = new Image("file:///"+fileName);
                userPhoto.setImage(image);
                topBarPhoto.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }




    }


    @FXML
    private void checkCreditRecord() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CreditRecordPane(stage));
    }

}

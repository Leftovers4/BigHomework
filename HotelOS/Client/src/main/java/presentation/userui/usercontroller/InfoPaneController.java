package presentation.userui.usercontroller;

import blservice_stub.UserBLService_Stub;
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
import presentation.userui.userscene.RegisterCommonVIPPane;
import presentation.userui.userscene.RegisterCompanyVIPPane;
import presentation.util.InputWrongAlert;
import vo.user.UserVO;

import java.io.*;
import java.time.LocalDate;

import static presentation.util.ChangePhoto.updatePhoto;

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
    @FXML private Hyperlink checkcreditentrance;

    @FXML private ImageView userPhoto;

    @FXML private Label userIdLabel;
    @FXML private Label usernameLabel;
    @FXML private Label userSex;
    @FXML private Label birthDate;
    @FXML private Label phone;
    @FXML private Button registerCommonvipBtn;
    @FXML private Button registerCompanyvipBtn;
    @FXML private Button editInfoBtn;

    private UserBLService_Stub userBLService_stub;

    private ImageView topbarphoto;

    public void launch(Stage primaryStage, Pane mainPane, ImageView topbarphoto) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.topbarphoto = topbarphoto;

        userBLService_stub = new UserBLService_Stub();

        initialData();
    }

    private void initialData() {
        UserVO userVO = userBLService_stub.getBasicUserInfo("lisi");

        userIdLabel.setText(userVO.username);
        usernameLabel.setText(userVO.name);
        if (userVO.gender) {
            userSex.setText("男");
        } else {
            userSex.setText("女");
        }
        birthDate.setText(userVO.memberVO.birthday.toString());
        phone.setText(userVO.phone);
    }


    /**
     * 组件的显示与隐藏
     * @param show
     */
    private void showmodule(boolean show) {
        userIdField.setVisible(show);
        userNameField.setVisible(show);
        sexMan.setVisible(show);
        sexWoman.setVisible(show);
        birthPicker.setVisible(show);
        phoneField.setVisible(show);
        saveInfo.setVisible(show);
        cleanAllBtn.setVisible(show);

        userIdLabel.setVisible(!show);
        usernameLabel.setVisible(!show);
        userSex.setVisible(!show);
        birthDate.setVisible(!show);
        phone.setVisible(!show);
        registerCommonvipBtn.setVisible(!show);
        registerCompanyvipBtn.setVisible(!show);
        editInfoBtn.setVisible(!show);
        checkcreditentrance.setVisible(!show);
    }

    /**
     * 编辑基本信息
     */
    @FXML
    private void editUserInfo() {
        showmodule(true);

        userIdField.setText(userIdLabel.getText());
        userNameField.setText(usernameLabel.getText());
        if (userSex.getText().equals("男")) {
            sexMan.setSelected(true);
            sexWoman.setSelected(false);
        } else if (userSex.getText().equals("女")) {
            sexWoman.setSelected(true);
            sexMan.setSelected(false);
        } else {
            sexMan.setSelected(false);
            sexWoman.setSelected(false);
        }
        birthPicker.setValue(LocalDate.parse(birthDate.getText().toString()));
        phoneField.setText(phone.getText());
    }

    /**
     * 保存编辑基本信息
     */
    @FXML
    private void saveUserInfo() {
        boolean isempty = isEmpty();
        boolean phoneisright = judgePhoneNumber(phoneField.getText());

        if (!isempty && phoneisright) {
            userIdLabel.setText(userIdField.getText());
            userIdField.clear();
            usernameLabel.setText(userNameField.getText());
            userNameField.clear();
            if (sexMan.isSelected()) {
                userSex.setText("男");
            } else if (sexWoman.isSelected()) {
                userSex.setText("女");
            } else {
                userSex.setText("保密");
            }
            sexMan.setSelected(false);
            sexWoman.setSelected(false);
            birthDate.setText(birthPicker.getValue().toString());
            birthPicker.setValue(null);

            phone.setText(phoneField.getText());
            phoneField.clear();

            showmodule(false);
        } else if (!isempty && !phoneisright) {
            new InputWrongAlert("联系方式格式错误", "格式错误").showAndWait();
        } else {
            new InputWrongAlert("信息填写不完整", "保存失败").showAndWait();
        }


    }

    /**
     * 判断是否存在未填写的内容
     * @return
     */
    private boolean isEmpty() {
        boolean userid = userIdField.getText().equals("");
        boolean username = userNameField.getText().equals("");
        boolean phonenum = phoneField.getText().equals("");
        boolean sex = true;
        if (sexMan.isSelected() || sexWoman.isSelected()) {
            sex = false;
        }
        return userid || username || phonenum || sex;
    }

    /**
     * 判断联系方式是否符合格式
     * @return
     */
    private boolean judgePhoneNumber(String str) {
        int length = str.length();
        if (length != 11) {
            return false;
        }

        boolean judge = true;

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

    /**
     * 重置所编辑的信息
     */
    @FXML
    private void cleanAll() {
        userIdField.clear();
        userNameField.clear();
        birthPicker.setValue(null);
        sexMan.setSelected(false);
        sexWoman.setSelected(false);
        phoneField.clear();
    }

    /**
     * 更换账号头像
     */
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
//                Image image = new Image("file:///"+fileName);
//                userPhoto.setImage(image);
                updatePhoto(userPhoto, fileName);
                updatePhoto(topbarphoto, fileName);
//                topBarPhoto.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 查看信用变更记录
     */
    @FXML
    private void checkCreditRecord() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CreditRecordPane(stage));
    }


    /**
     * 注册普通会员
     */
    @FXML
    private void registerCommonvip() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new RegisterCommonVIPPane(stage));
    }

    /**
     * 注册企业会员
     */
    @FXML
    private void registerCompanyvip() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new RegisterCompanyVIPPane(stage));
    }


}

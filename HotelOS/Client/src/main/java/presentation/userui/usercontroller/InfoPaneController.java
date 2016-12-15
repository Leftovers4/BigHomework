package presentation.userui.usercontroller;

import bl.userbl.impl.UserBlServiceImpl;
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
import presentation.userui.userscene.InfoPane;
import presentation.userui.userscene.RegisterCommonVIPPane;
import presentation.userui.userscene.RegisterCompanyVIPPane;
import presentation.util.alert.AlertController;
import presentation.util.alert.InputWrongAlert;
import util.MemberType;
import util.ResultMessage;
import vo.user.UserVO;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import static presentation.util.other.ChangePhoto.updatePhoto;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {

    private Stage stage;
    private Pane mainPane;
    private String userID;

    @FXML private TextField userNameField;
    @FXML private RadioButton sexMan;
    @FXML private RadioButton sexWoman;
    @FXML private DatePicker birthPicker;
    @FXML private TextField phoneField;
    @FXML private Button saveInfo;
    @FXML private Button cleanAllBtn;
    @FXML private Hyperlink checkcreditentrance;

    @FXML private Label vipLevel;
    @FXML private Label vipCompany;

    @FXML private Label creditLabel;

    @FXML private ImageView userPhoto;

    @FXML private Label userIdLabel;
    @FXML private Label usernameLabel;
    @FXML private Label userSex;
    @FXML private Label birthDate;
    @FXML private Label phone;
    @FXML private Button registerCommonvipBtn;
    @FXML private Button registerCompanyvipBtn;
    @FXML private Button editInfoBtn;

    private UserBlServiceImpl userBlService;
    private ArrayList<Button> leftBarBtnArr;

    private ImageView topbarphoto;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, ImageView topbarphoto, String username, ArrayList<Button> leftBarBtnArr) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.topbarphoto = topbarphoto;
        this.userID = username;
        this.leftBarBtnArr = leftBarBtnArr;

        alertController = new AlertController();

        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {

        userIdLabel.setText(userID);

        if (firstToLogin(userID)) {
            //新注册后第一次登录填写个人信息
            for (int i = 0; i<leftBarBtnArr.size(); i++) {
                if (i != 0) {
                    leftBarBtnArr.get(i).setDisable(true);
                }
            }
            showmodule(true);
            userNameField.setText(null);
            sexMan.setSelected(false);
            sexWoman.setSelected(false);
            phoneField.setText(null);
            birthPicker.setValue(null);
        } else {
            //老用户信息显示
            try {
                UserVO userVO = userBlService.viewBasicUserInfo(userID);

                if (userVO.gender) {
                    userSex.setText("男");
                } else {
                    userSex.setText("女");
                }
                phone.setText(userVO.phone);
                birthDate.setText(userVO.memberVO.birthday.toString());

                creditLabel.setText(String.valueOf(userVO.creditVO.credit));

                //会员信息显示
                MemberType memberType = userVO.memberVO.memberType;
                System.out.println(memberType == null);

                if (memberType == MemberType.None) {
                    vipLevel.setVisible(false);
                    vipCompany.setVisible(false);
                    registerCommonvipBtn.setVisible(true);
                    registerCompanyvipBtn.setVisible(true);
                } else if (memberType == MemberType.NormalMember) {
                    vipLevel.setVisible(true);
                    registerCommonvipBtn.setVisible(false);
                    vipLevel.setText(String.valueOf(userVO.memberVO.level));
                    registerCompanyvipBtn.setVisible(true);
                    vipCompany.setVisible(false);
                } else if (memberType == MemberType.EnterpriseMember) {
                    vipCompany.setVisible(true);
                    registerCompanyvipBtn.setVisible(false);
                    vipCompany.setText(userVO.memberVO.enterprise);
                    registerCommonvipBtn.setVisible(true);
                    vipLevel.setVisible(false);
                } else if (memberType == MemberType.Both) {
                    vipCompany.setVisible(true);
                    vipCompany.setText(userVO.memberVO.enterprise);
                    vipLevel.setVisible(true);
                    vipLevel.setText(String.valueOf(userVO.memberVO.level));
                    registerCommonvipBtn.setVisible(false);
                    registerCompanyvipBtn.setVisible(false);
                } else {
                    registerCommonvipBtn.setVisible(true);
                    registerCompanyvipBtn.setVisible(true);
                    vipLevel.setVisible(false);
                    vipCompany.setVisible(false);
                }
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

    }

    /**
     * 判断用户信息是否已填写
     * 若未填写，则直接进入填写个人基本信息界面
     * @param username
     * @return
     */
    private boolean firstToLogin(String username) {
        boolean isNew = false;
        try {
            UserVO userVO = userBlService.viewBasicUserInfo(username);

            if (userVO.name.equals("")) {
                isNew = true;
            } else {
                isNew = false;
            }
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

        return isNew;
    }


    /**
     * 组件的显示与隐藏
     * @param show
     */
    private void showmodule(boolean show) {
        userNameField.setVisible(show);
        sexMan.setVisible(show);
        sexWoman.setVisible(show);
        birthPicker.setVisible(show);
        phoneField.setVisible(show);
        saveInfo.setVisible(show);
        cleanAllBtn.setVisible(show);
        vipLevel.setVisible(show);
        vipCompany.setVisible(show);

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

        userNameField.setText(usernameLabel.getText());
        if (userSex.getText().equals("男")) {
            sexMan.setSelected(true);
//            sexWoman.setSelected(false);
        } else if (userSex.getText().equals("女")) {
            sexWoman.setSelected(true);
//            sexMan.setSelected(false);
        }
        birthPicker.setValue(LocalDate.parse(birthDate.getText()));
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
            UserVO userVO = new UserVO();

            userVO.username = userID;
            userVO.newUsername = userID;
            userVO.name = userNameField.getText();
            userVO.gender = sexMan.isSelected();
            userVO.phone = phoneField.getText();
            userVO.memberVO.birthday = birthPicker.getValue();

            try {
                ResultMessage resultMessage = userBlService.updateBasicUserInfo(userVO);

                if (resultMessage == ResultMessage.DataExisted) {
                    System.out.println("exits");
                } else if (resultMessage == ResultMessage.Success) {
                    System.out.println("success");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            phone.setText(phoneField.getText());
            userNameField.clear();
            sexMan.setSelected(false);
            sexWoman.setSelected(false);
            birthPicker.setValue(null);
            phoneField.clear();

            showmodule(false);

            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new InfoPane(stage, mainPane, topbarphoto, userID, leftBarBtnArr));
            for (int i = 0; i<leftBarBtnArr.size(); i++) {
                if (i != 0) {
                    leftBarBtnArr.get(i).setDisable(false);
                }
            }

            initialData();
        } else if (!isempty && !phoneisright) {
            alertController.showInputWrongAlert("联系方式格式错误！", "格式错误");
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "格式错误");
        }


    }

    /**
     * 判断是否存在未填写的内容
     * @return
     */
    private boolean isEmpty() {
        boolean username = userNameField.getText().equals("");
        boolean phonenum = phoneField.getText().equals("");
        boolean sex = true;
        if (sexMan.isSelected() || sexWoman.isSelected()) {
            sex = false;
        }
        return username || phonenum || sex;
    }

    /**
     * 判断联系方式是否符合格式
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

    /**
     * 重置所编辑的信息
     */
    @FXML
    private void cleanAll() {
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
                String newpath = "C:/Leftovers/client/userImage/";
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
        mainPane.getChildren().add(new CreditRecordPane(stage, mainPane, userID));
    }


    /**
     * 注册普通会员
     */
    @FXML
    private void registerCommonvip() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new RegisterCommonVIPPane(stage, mainPane, userID, topbarphoto, leftBarBtnArr));
    }

    /**
     * 注册企业会员
     */
    @FXML
    private void registerCompanyvip() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new RegisterCompanyVIPPane(stage, mainPane, userID, topbarphoto, leftBarBtnArr));
    }


}

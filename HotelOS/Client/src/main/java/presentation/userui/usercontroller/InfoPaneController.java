package presentation.userui.usercontroller;

import bl.userbl.UserBLService;
import bl.userbl.impl.UserBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.userui.userscene.CreditRecordPane;
import presentation.userui.userscene.InfoPane;
import presentation.userui.userscene.RegisterCommonVIPPane;
import presentation.userui.userscene.RegisterCompanyVIPPane;
import presentation.util.alert.AlertController;
import presentation.util.alert.InputWrongAlert;
import presentation.util.other.ChangePhoto;
import presentation.util.other.JudgeInput;
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

    @FXML private GridPane infoEditGridPane;
    @FXML private TextField userNameField;
    @FXML private RadioButton sexMan;
    @FXML private RadioButton sexWoman;
    @FXML private DatePicker birthPicker;
    @FXML private TextField phoneField;
    @FXML private Button saveInfo;
    @FXML private Button cleanAllBtn;
    @FXML private Hyperlink checkcreditentrance;

    @FXML private ImageView levelImage;
    @FXML private Label vipCompany;

    @FXML private Label creditLabel;

    @FXML private ImageView userPhoto;

    @FXML private GridPane infoShowGridPane;
    @FXML private Label userIdLabel;
    @FXML private Label usernameLabel;
    @FXML private Label userSex;
    @FXML private Label birthDate;
    @FXML private Label phone;
    @FXML private Hyperlink registerCommonvipBtn;
    @FXML private Hyperlink registerCompanyvipBtn;
    @FXML private Button editInfoBtn;

    private UserBLService userBlService;
    private ArrayList<Button> leftBarBtnArr;

    private String newpath = "C:/Leftovers/client/userImage/";

    private ImageView topbarphoto;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, ImageView topbarphoto, String username, ArrayList<Button> leftBarBtnArr) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.topbarphoto = topbarphoto;
        this.userID = username;
        this.leftBarBtnArr = leftBarBtnArr;

        alertController = new AlertController();

        initialPhoto();
        initialService();
        initialData();
    }

    private void initialPhoto() {
        String path = newpath + userID + ".jpg";
        File file = new File(newpath);


        if (file.exists()) {
            Image image = new Image("file:///" + path);
            topbarphoto.setImage(image);
            userPhoto.setImage(image);
        }
    }

    private void initialService() {
        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
            cleanAll();
        } else {
            //老用户信息显示
            try {
                UserVO userVO = userBlService.viewBasicUserInfo(userID);

                usernameLabel.setText(userVO.name);
                userSex.setText(userVO.gender ? "男" : "女");
                phone.setText(userVO.phone);
                birthDate.setText(userVO.memberVO.birthday.toString());
                creditLabel.setText(String.valueOf(userVO.creditVO.credit));

                //会员信息显示
                MemberType memberType = userVO.memberVO.memberType;

                if (memberType == MemberType.None) {
                    setMemberComponentsVisible(false,false);
                } else if (memberType == MemberType.NormalMember) {
                    setMemberComponentsVisible(true,false);
                    setVipLevel(userVO.memberVO.level);
                } else if (memberType == MemberType.EnterpriseMember) {
                    vipCompany.setText(userVO.memberVO.enterprise);
                    setMemberComponentsVisible(false,true);
                } else if (memberType == MemberType.Both) {
                    setVipLevel(userVO.memberVO.level);
                    vipCompany.setText(userVO.memberVO.enterprise);
                    setMemberComponentsVisible(true,true);
                } else {
                    setMemberComponentsVisible(false,false);
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

    private void setMemberComponentsVisible(Boolean isCommonVIP, Boolean isComVip){
        registerCommonvipBtn.setVisible(!isCommonVIP);
        registerCompanyvipBtn.setVisible(!isComVip);
        vipCompany.setVisible(isComVip);
    }

    private void setVipLevel(int level) {
        String path = "/img/webmarketer/" + level + ".png";
        Image image = new Image(path);
        levelImage.setImage(image);
        levelImage.setVisible(true);
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
        infoEditGridPane.setVisible(show);
        saveInfo.setVisible(show);
        cleanAllBtn.setVisible(show);
        vipCompany.setVisible(show);

        infoShowGridPane.setVisible(!show);
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
        } else if (userSex.getText().equals("女")) {
            sexWoman.setSelected(true);
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
        boolean phoneisright = JudgeInput.judgePhoneNumber(phoneField.getText());

        if (!isempty && phoneisright) {
            UserVO userVO = new UserVO();

            userVO.username = userID;
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

            showmodule(false);

            mainPane.getChildren().clear();
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

                String fileName = selectedDirectory.getAbsolutePath();


                File file = new File(fileName);

                byte[] imgbyte = ChangePhoto.toBytesFromFile(file);

                ResultMessage resultMessage = userBlService.updateUserImage(userID, imgbyte);

                ChangePhoto.setImage(newpath, userID, imgbyte);
////                Image image = new Image("file:///"+fileName);
////                userPhoto.setImage(image);
                updatePhoto(userPhoto, newpath + userID +".jpg");
                updatePhoto(topbarphoto, newpath + userID +".jpg");
////                topBarPhoto.setImage(image);


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
        mainPane.getChildren().add(new CreditRecordPane(stage, mainPane, userID));
    }


    /**
     * 注册普通会员
     */
    @FXML
    private void registerCommonvip() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new RegisterCommonVIPPane(stage, mainPane, userID, topbarphoto, leftBarBtnArr));
    }

    /**
     * 注册企业会员
     */
    @FXML
    private void registerCompanyvip() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new RegisterCompanyVIPPane(stage, mainPane, userID, topbarphoto, leftBarBtnArr));
    }


}

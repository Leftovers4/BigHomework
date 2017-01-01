package presentation.webmanagerui.webmanagercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.util.other.DisableColumnChangeListener;
import presentation.util.other.JudgeInput;
import presentation.util.other.ToolTipShow;
import presentation.webmanagerui.webmanagerscene.CheckUserInfoPane;
import presentation.webmanagerui.webmanagerscene.UserManagePane;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 * description: 客户管理
 */
public class UserManageController {

    private Stage stage;
    private Pane mainPane;

    @FXML private TableView userlist;
    @FXML private Pane modifyUserInfoPane;

    @FXML private TextField nameField;
    @FXML private TextField phoneField;

    @FXML private TableColumn userIDCol;
    @FXML private TableColumn userNameCol;
    @FXML private TableColumn btnCol;
    @FXML private TableColumn phoneCol;


    private UserBlServiceImpl userBlService;
    private WebManUserButtonCell webManUserButtonCell;
    private int chooseModifyIndex;
    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        chooseModifyIndex = 0;
        alertController = new AlertController();

        try {
            userBlService = new UserBlServiceImpl();

            initialData();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }


    }


    private void initialData() {
        userIDCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManUserButtonCell = new WebManUserButtonCell();
                return webManUserButtonCell;
            }
        });
        final TableColumn[] tableColumns = {userIDCol, userNameCol, phoneCol, btnCol};
        userlist.getColumns().addListener(new DisableColumnChangeListener(userlist, tableColumns));
        userlist.setItems(getUserList());
    }

    private ObservableList getUserList() {
        ObservableList<UserVO> list = null;
        try {
            list = FXCollections.observableArrayList(userBlService.getAllUsers());
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }




    /**
     * Created by wyj on 2016/12/7.
     * Description: 网站管理人员工具类---客户列表按钮
     */
    private class WebManUserButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button editBtn = new Button();
        final private Button checkDetailBtn = new Button();
        private int selectedIndex;

        public WebManUserButtonCell() {

            Image editImg = new Image("/img/hotelworker/modifyroom.png");
            ImageView editimgview = new ImageView(editImg);
            editBtn.setGraphic(editimgview);
            editBtn.getStyleClass().add("TableEditButtonCell");
            Image checkdetailimg = new Image("/img/webmanager/information.png");
            ImageView checkdetailimgview = new ImageView(checkdetailimg);
            checkDetailBtn.setGraphic(checkdetailimgview);
            checkDetailBtn.getStyleClass().add("TableInfoButtonCell");

            editBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                chooseModifyIndex = selectedIndex;

                UserVO userVO = (UserVO) userlist.getItems().get(selectedIndex);

                nameField.setText(userVO.username);
                phoneField.setText(userVO.phone);

                userlist.setPrefHeight(300);
                userlist.setDisable(true);
                modifyUserInfoPane.setVisible(true);
            });

            checkDetailBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                UserVO userVO = (UserVO) userlist.getItems().get(selectedIndex);

                mainPane.getChildren().remove(0);
                mainPane.getChildren().add(new CheckUserInfoPane(mainPane, userVO.username));
            });

        }


        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                btnBox.getChildren().clear();
                editBtn.setTooltip(ToolTipShow.setTool("编辑"));
                checkDetailBtn.setTooltip(ToolTipShow.setTool("查看详情"));

                btnBox.setAlignment(Pos.CENTER);
                btnBox.setSpacing(10);
                btnBox.setPadding(new Insets(0, 0, 0 ,10));
                btnBox.getChildren().addAll(checkDetailBtn, editBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }

    }


    /**
     * 确认修改客户信息
     */
    @FXML
    private void confirmModify() {
        if (!nameField.getText().equals("") && !phoneField.getText().equals("")) {
            UserVO userVO = (UserVO) userlist.getItems().get(chooseModifyIndex);

            userVO.name = nameField.getText();
            userVO.phone = phoneField.getText();
            boolean isphoneok = JudgeInput.judgePhoneNumber(phoneField.getText());

            if (isphoneok) {
                try {
                    ResultMessage resultMessage = userBlService.updateBasicUserInfo(userVO);

                    if (resultMessage == ResultMessage.Success) {
                        System.out.println("modify success");

                        alertController.showUpdateSuccessAlert("修改成功！", "成功提示");

                        userlist.setPrefHeight(470);
                        userlist.setDisable(false);
                        modifyUserInfoPane.setVisible(false);
                        mainPane.getChildren().clear();
                        mainPane.getChildren().add(new UserManagePane(stage, mainPane));
                    }
                } catch (RemoteException e) {
                    alertController.showNetConnectAlert();
                }
            } else {
                alertController.showInputWrongAlert("联系方式格式错误", "格式错误");
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
        }
    }

    /**
     * 取消修改客户信息
     */
    @FXML
    private void cancelModify() {
        boolean confirm = alertController.showConfirmCancelAlert();

        if (confirm) {
            userlist.setPrefHeight(470);
            userlist.setDisable(false);
            modifyUserInfoPane.setVisible(false);
        }
    }
}

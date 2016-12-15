package presentation.webmanagerui.webmanagercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.webmanagerui.webmanagerscene.CheckUserInfoPane;
import presentation.webmanagerui.webmanagerscene.UserManagePane;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
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

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
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
        userlist.setItems(getUserList());
    }

    private ObservableList getUserList() {
        ObservableList<UserVO> list = null;
        try {
            list = FXCollections.observableArrayList(userBlService.getAllUsers());
        } catch (RemoteException e) {
            e.printStackTrace();
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

            Image editImg = new Image("/img/webmanager/edit.png");
            ImageView editimgview = new ImageView(editImg);
            editimgview.setFitHeight(20);
            editimgview.setFitWidth(20);
            editBtn.setGraphic(editimgview);
            editBtn.getStyleClass().add("tableCellBtn");
            Image checkdetailimg = new Image("/img/user/checkdetail.png");
            ImageView checkdetailimgview = new ImageView(checkdetailimg);
            checkdetailimgview.setFitHeight(20);
            checkdetailimgview.setFitWidth(20);
            checkDetailBtn.setGraphic(checkdetailimgview);
            checkDetailBtn.getStyleClass().add("tableCellBtn");

            editBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

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
                btnBox.getChildren().add(editBtn);
                btnBox.getChildren().add(checkDetailBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }

        public int getSelectedIndex() {
            return selectedIndex;
        }
    }


    /**
     * 确认修改客户信息
     */
    @FXML
    private void confirmModify() {
        UserVO userVO = (UserVO) userlist.getItems().get(webManUserButtonCell.getSelectedIndex());

        userVO.name = nameField.getText();
        userVO.phone = phoneField.getText();

        try {
            ResultMessage resultMessage = userBlService.updateBasicUserInfo(userVO);

            if (resultMessage == ResultMessage.Success) {
                System.out.println("modify success");

                userlist.setPrefHeight(400);
                userlist.setDisable(false);
                modifyUserInfoPane.setVisible(false);
                new UserManagePane(stage, mainPane);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消修改客户信息
     */
    @FXML
    private void cancelModify() {
        userlist.setPrefHeight(400);
        userlist.setDisable(false);
        modifyUserInfoPane.setVisible(false);
    }
}

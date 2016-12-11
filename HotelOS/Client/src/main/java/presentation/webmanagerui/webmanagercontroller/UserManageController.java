package presentation.webmanagerui.webmanagercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.WebManUserButtonCell;
import vo.user.UserVO;

import javax.swing.text.TabableView;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class UserManageController {

    private Stage stage;
    private Pane mainPane;

    @FXML private TableView userlist;
    @FXML private Pane modifyUserInfoPane;

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
                webManUserButtonCell = new WebManUserButtonCell(stage, mainPane, userlist);
                return webManUserButtonCell;
            }
        });
    }

//    private ObservableList getUserList() {
//        ObservableList<UserVO> list = FXCollections.observableArrayList(userBlService.viewBasicUserInfo())
//    }


    /**
     * 编辑客户信息
     */
    @FXML
    private void modifyUserInfoEvent() {
        userlist.setPrefHeight(300);
        modifyUserInfoPane.setVisible(true);
    }

    /**
     * 保存编辑
     */
    @FXML
    private void saveUserInfoEvent() {
        userlist.setPrefHeight(400);
        modifyUserInfoPane.setVisible(false);
    }
}

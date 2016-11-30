package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.TabableView;

/**
 * Created by wyj on 2016/11/29.
 */
public class UserManageController {

    private Stage stage;

    @FXML private TableView userlist;
    @FXML private Pane modifyUserInfoPane;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }


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

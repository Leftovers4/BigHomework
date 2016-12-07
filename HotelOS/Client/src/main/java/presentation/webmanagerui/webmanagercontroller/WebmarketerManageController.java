package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmarketerManageController {

    private Stage stage;

    @FXML private Pane addwebmarketerPane;
    @FXML private TableView webmarketerlist;

    @FXML private TableColumn webmarketerIDCol;
    @FXML private TableColumn webmarketerNameCol;
    @FXML private TableColumn webmarketerPhoneCol;
    @FXML private TableColumn btnCol;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    /**
     * 添加网站管理人员
     */
    @FXML
    private void addWebMarketerEvent() {
        addwebmarketerPane.setVisible(true);
        webmarketerlist.setPrefHeight(200);
    }

    /**
     * 保存添加
     */
    @FXML
    private void saveWebMarketerInfo() {
        addwebmarketerPane.setVisible(false);
        webmarketerlist.setPrefHeight(400);
    }
}

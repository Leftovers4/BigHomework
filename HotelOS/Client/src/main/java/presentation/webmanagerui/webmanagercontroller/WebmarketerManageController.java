package presentation.webmanagerui.webmanagercontroller;

import bl.personnelbl.impl.PersonnelBLServiceImpl;
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
import presentation.util.alert.AlertController;
import presentation.util.other.DisableColumnChangeListener;
import presentation.webmanagerui.webmanagerscene.WebmarketerManagePane;
import util.PersonnelType;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmarketerManageController {

    private Stage stage;
    private Pane mainPane;

    @FXML private Pane modifywebmarketerPane;
    @FXML private TableView webmarketerlist;

    @FXML private TableColumn webmarketerIDCol;
    @FXML private TableColumn webmarketerNameCol;
    @FXML private TableColumn btnCol;

    @FXML private TextField workernameField;
    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;

    @FXML private Pane fillinfoPane;
    @FXML private TextField newworkernameField;
    @FXML private TextField initialpasswordField;
    @FXML private TextField passwordField;
    @FXML private Button nextStepBtn;

    @FXML private Pane confirmPane;
    @FXML private Label workerIDLabel;
    @FXML private Button confirminfoBtn;
    @FXML private Label workernameLabel;

    private PersonnelBLServiceImpl personnelBLService;
    private WebManMarketerButtonCell webManMarketerButtonCell;

    private AlertController alertController;

    private long newmarketerID;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        alertController = new AlertController();

        try {
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }


    private void initialData() {
        webmarketerIDCol.setCellValueFactory(new PropertyValueFactory<>("personnelID"));
        webmarketerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManMarketerButtonCell = new WebManMarketerButtonCell();
                return webManMarketerButtonCell;
            }
        });
        final TableColumn[] tableColumns = {webmarketerIDCol, webmarketerNameCol, btnCol};
        webmarketerlist.getColumns().addListener(new DisableColumnChangeListener(webmarketerlist, tableColumns));
        webmarketerlist.setItems(getWebMarketerList());
    }
    private ObservableList getWebMarketerList() {
        ObservableList<PersonnelVO> list = null;
        try {
            list = FXCollections.observableArrayList(personnelBLService.viewTypePersonnelList(PersonnelType.WebMarketer));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }




    /**
     * Created by wyj on 2016/12/7.
     * Description: 网站管理人员工具类---网站营销人员列表按钮
     */
    private class WebManMarketerButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button editBtn = new Button();
        final private Button deleteBtn = new Button();
        private int selectedIndex;

        public WebManMarketerButtonCell() {

            Image editImg = new Image("/img/webmanager/edit.png");
            ImageView editimgview = new ImageView(editImg);
            editimgview.setFitHeight(20);
            editimgview.setFitWidth(20);
            editBtn.setGraphic(editimgview);
            editBtn.getStyleClass().add("tableCellBtn");
            Image deleteImg = new Image("/img/webmanager/delete.png");
            ImageView deleteimgview = new ImageView(deleteImg);
            deleteimgview.setFitWidth(20);
            deleteimgview.setFitHeight(20);
            deleteBtn.setGraphic(deleteimgview);
            deleteBtn.getStyleClass().add("tableCellBtn");

            editBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                PersonnelVO personnelVO = (PersonnelVO) webmarketerlist.getItems().get(selectedIndex);

                workernameField.setText(personnelVO.name);
                passwordField.setText(personnelVO.password);

                webmarketerlist.setPrefHeight(300);
                webmarketerlist.setDisable(true);
                modifywebmarketerPane.setVisible(true);
            });

            deleteBtn.setOnAction(event -> {
                boolean confirm = alertController.showConfirmDeleteAlert("确认删除？", "删除确认");

                if (confirm) {
                    selectedIndex = getTableRow().getIndex();
                    PersonnelVO personnelVO = (PersonnelVO) webmarketerlist.getItems().get(selectedIndex);

                    try {
                        ResultMessage resultMessage = personnelBLService.deletePersonnel(personnelVO.personnelID);

                        if (resultMessage == ResultMessage.Success) {
                            System.out.println(resultMessage);

                            new WebmarketerManagePane(stage, mainPane);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
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
                btnBox.getChildren().add(deleteBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }

        public int getSelectedIndex() {
            return selectedIndex;
        }
    }


    /**
     * 确认修改信息
     */
    @FXML
    private void confirmModify() {
        if (!workernameField.getText().equals("") && !passwordField.getText().equals("")) {
            PersonnelVO personnelVO = (PersonnelVO) webmarketerlist.getItems().get(webManMarketerButtonCell.getSelectedIndex());

            personnelVO.name = workernameField.getText();
            personnelVO.password = passwordField.getText();

            try {
                ResultMessage resultMessage = personnelBLService.updatePersonnelInfo(personnelVO);

                if (resultMessage == ResultMessage.Success) {
                    System.out.println("update success");

                    webmarketerlist.setPrefHeight(472);
                    webmarketerlist.setDisable(false);
                    modifywebmarketerPane.setVisible(false);
                    mainPane.getChildren().remove(0);
                    mainPane.getChildren().add(new WebmarketerManagePane(stage, mainPane));
                } else {
                    System.out.println(resultMessage+"==============");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
        }
    }

    /**
     * 取消修改信息
     */
    @FXML
    private void cancelModify() {
        webmarketerlist.setPrefHeight(472);
        webmarketerlist.setDisable(false);
        modifywebmarketerPane.setVisible(false);
    }


    /**
     * 添加新网站营销人员按钮事件
     */
    @FXML
    private void toAddNewWebMarketer() {
        webmarketerlist.setPrefHeight(300);
        webmarketerlist.setDisable(true);

        fillinfoPane.setVisible(true);
        fillinfoPane.setDisable(false);
        confirmPane.setDisable(true);
        confirmPane.setVisible(false);
    }



    /**
     * 下一步，确认新网站营销人员信息
     */
    @FXML
    private void toConfirmNewMarketerInfo() {
        fillinfoPane.setVisible(false);
        fillinfoPane.setDisable(true);
        confirmPane.setDisable(false);
        confirmPane.setVisible(true);

        if (!newworkernameField.getText().equals("") && !initialpasswordField.getText().equals("")) {
            PersonnelVO personnelVO = new PersonnelVO();

            personnelVO.name = newworkernameField.getText();
            personnelVO.password = initialpasswordField.getText();
            personnelVO.personnelType = PersonnelType.WebMarketer;

            try {
                newmarketerID = personnelBLService.addWebMarketer(personnelVO);

                workerIDLabel.setText(String.valueOf(newmarketerID));
                workernameLabel.setText(personnelVO.name);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
        }
    }

    /**
     * 确认新网站人员信息
     */
    @FXML
    private void confirmMarketerInfo() {
        boolean confirm = alertController.showConfirmCancelAlert();

        if (confirm) {
            confirmPane.setVisible(false);
            confirmPane.setDisable(true);

            webmarketerlist.setPrefHeight(472);
            webmarketerlist.setDisable(false);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new WebmarketerManagePane(stage, mainPane));
        }

    }
}

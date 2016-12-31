package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.personnelbl.PersonnelBLService;
import bl.personnelbl.impl.PersonnelBLServiceImpl;
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
import presentation.util.buttoncell.HotelNameCell;
import presentation.util.other.DisableColumnChangeListener;
import presentation.util.other.ToolTipShow;
import presentation.webmanagerui.webmanagerscene.CheckHotelInfoPane;
import presentation.webmanagerui.webmanagerscene.HotelWorkerManagePane;
import util.PersonnelType;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelworkerManageController {

    private Stage stage;
    private Pane pane;

    @FXML private TableView hotelworkerList;
    @FXML private TableColumn hotelIDCol;
    @FXML private TableColumn hotelnameCol;
    @FXML private TableColumn hotelworkerIDCol;
    @FXML private TableColumn hotelworkerNameCol;
    @FXML private TableColumn btnCol;

    @FXML private Pane modifyhotelworkerPane;
    @FXML private TextField workernameField;
    @FXML private TextField passwordField;
    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;

    private int index;

    private PersonnelBLService personnelBLService;
    private WebManHotelworkerButtonCell webManHotelworkerButtonCell;
    private int chooseModifyIndex;
    private HotelBLService hotelBLService;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.pane = mainPane;
        chooseModifyIndex = 0;
        alertController = new AlertController();

        try {
            personnelBLService = new PersonnelBLServiceImpl();
            hotelBLService = new HotelBlServiceImpl();

            initialData();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }

        index = -1;

    }


    private void initialData() {

        hotelIDCol.setCellValueFactory(new PropertyValueFactory<>("hotelID"));
        hotelnameCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelNameCell(hotelworkerList);
            }
        });
        hotelworkerIDCol.setCellValueFactory(new PropertyValueFactory<>("personnelID"));
        hotelworkerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManHotelworkerButtonCell = new WebManHotelworkerButtonCell();
                return webManHotelworkerButtonCell;
            }
        });
        final TableColumn[] tableColumns = {hotelIDCol, hotelworkerIDCol, hotelworkerNameCol, btnCol};
        hotelworkerList.getColumns().addListener(new DisableColumnChangeListener(hotelworkerList, tableColumns));
        hotelworkerList.setItems(getHotelWorkerList());
    }
    private ObservableList getHotelWorkerList() {
        ObservableList<PersonnelVO> list = null;
        try {
            list = FXCollections.observableArrayList(personnelBLService.viewTypePersonnelList(PersonnelType.HotelWorker));
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
        return list;
    }




    /**
     * Created by wyj on 2016/12/7.
     * Description: 网站管理人员工具类---酒店工作人员列表按钮
     */
    private class WebManHotelworkerButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button editBtn = new Button();
        final private Button deleteBtn = new Button();
        final private Button checkDetailBtn = new Button();
        private int selectedIndex;

        public WebManHotelworkerButtonCell() {

            Image editImg = new Image("/img/hotelworker/modifyroom.png");
            ImageView editimgview = new ImageView(editImg);
            editBtn.setGraphic(editimgview);
            editBtn.getStyleClass().add("TableEditButtonCell");
            Image deleteImg = new Image("/img/hotelworker/deleteroom.png");
            ImageView deleteimgview = new ImageView(deleteImg);
            deleteBtn.setGraphic(deleteimgview);
            deleteBtn.getStyleClass().add("TableDeleteButtonCell");
            Image checkdetailimg = new Image("/img/webmanager/information.png");
            ImageView checkdetailimgview = new ImageView(checkdetailimg);
            checkDetailBtn.setGraphic(checkdetailimgview);
            checkDetailBtn.getStyleClass().add("TableInfoButtonCell");

            editBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                chooseModifyIndex = selectedIndex;

                PersonnelVO personnelVO = (PersonnelVO) hotelworkerList.getItems().get(selectedIndex);
                workernameField.setText(personnelVO.name);

                hotelworkerList.setPrefHeight(300);
                hotelworkerList.setDisable(true);
                modifyhotelworkerPane.setVisible(true);
            });

            deleteBtn.setOnAction(event -> {
                boolean confirm = alertController.showConfirmDeleteAlert("确认删除？", "删除确认");
                if (confirm) {
                    selectedIndex = getTableRow().getIndex();

                    PersonnelVO personnelVO = (PersonnelVO) hotelworkerList.getItems().get(selectedIndex);

                    try {
                        ResultMessage resultMessage = personnelBLService.deletePersonnel(personnelVO.personnelID);

                        if (resultMessage == ResultMessage.Success) {
                            System.out.println("delete success");

                            hotelworkerList.setPrefHeight(400);
                            hotelworkerList.setDisable(false);
                            modifyhotelworkerPane.setVisible(false);
                            pane.getChildren().remove(0);
                            pane.getChildren().add(new HotelWorkerManagePane(stage, pane));
                        }
                    } catch (RemoteException e) {
                        alertController.showNetConnectAlert();
                    }
                }
            });

            checkDetailBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                PersonnelVO personnelVO = (PersonnelVO) hotelworkerList.getItems().get(selectedIndex);

                pane.getChildren().remove(0);
                pane.getChildren().add(new CheckHotelInfoPane(pane, personnelVO.hotelID));
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
                deleteBtn.setTooltip(ToolTipShow.setTool("删除"));
                checkDetailBtn.setTooltip(ToolTipShow.setTool("查看详情"));
                editBtn.setTooltip(ToolTipShow.setTool("编辑"));
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setSpacing(10);
                btnBox.setPadding(new Insets(0, 0, 0 ,10));
                btnBox.getChildren().addAll(checkDetailBtn, editBtn, deleteBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }
    }


    /**
     * 确认修改工作人员信息
     */
    @FXML
    private void confirmModify() {
        if (!workernameField.getText().equals("")) {
            PersonnelVO personnelVO = (PersonnelVO) hotelworkerList.getItems().get(chooseModifyIndex);

            personnelVO.name = workernameField.getText();
            if (!passwordField.getText().equals("")) {
                personnelVO.password = passwordField.getText();
            } else {
                personnelVO.password = personnelVO.password;
            }

            try {
                ResultMessage resultMessage = personnelBLService.updatePersonnelInfo(personnelVO);

                if (resultMessage == ResultMessage.Success) {
                    System.out.println("modify success");

                    hotelworkerList.setPrefHeight(480);
                    modifyhotelworkerPane.setVisible(false);

                    alertController.showUpdateSuccessAlert("修改成功！", "成功提示");
                    pane.getChildren().remove(0);
                    pane.getChildren().add(new HotelWorkerManagePane(stage, pane));
                } else {
                    System.out.println(resultMessage);
                }
            } catch (RemoteException e) {
                alertController.showNetConnectAlert();
            }
        } else {
            alertController.showInputWrongAlert("信息填写不完整", "错误提示");
        }
    }

    /**
     * 取消修改工作人员信息
     */
    @FXML
    private void cancelModify() {
        boolean confirm = alertController.showConfirmCancelAlert();

        if (confirm) {
            hotelworkerList.setPrefHeight(480);
            hotelworkerList.setDisable(false);
            modifyhotelworkerPane.setVisible(false);
        }
    }
}

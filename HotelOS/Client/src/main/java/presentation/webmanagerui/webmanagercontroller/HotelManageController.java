package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import presentation.util.other.ToolTipShow;
import presentation.webmanagerui.webmanagerscene.AddHotelPane;
import presentation.webmanagerui.webmanagerscene.CheckHotelInfoPane;
import presentation.webmanagerui.webmanagerscene.HotelManagePane;
import util.AddTradProducer;
import util.ResultMessage;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelManageController {

    private Pane pane;

    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;
    @FXML private Button searchhotelBtn;
    @FXML private Button newhotelBtn;
    @FXML private TextField hotelnameinput;
    @FXML private ComboBox cityCB;
    @FXML private ComboBox tracingareaCB;
    @FXML private ComboBox star;

    @FXML private Pane modifyPane;

    @FXML private TableView hotelList;
    @FXML private TableColumn hotelIDCol;
    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn hotelCityCol;
    @FXML private TableColumn hotelBusinessCol;
    @FXML private TableColumn btnCol;

    private HotelBlServiceImpl hotelBlService;
    private WebManHotelListButtonCell webManHotelListButtonCell;

    private AlertController alertController;


    public void launch(Pane mainPane) {
        this.pane = mainPane;

        alertController = new AlertController();

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
        initialTable();
    }


    private void initialData() {
        Iterator<String> cityList = AddTradProducer.getAllAddress();
        while (cityList.hasNext()) {
            cityCB.getItems().add(cityList.next());
        }

        for (int i = 1; i<=5; i++) {
            star.getItems().add(i);
        }

        cityCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    Iterator<String> tracingArea = AddTradProducer.getTradingAreasByAddress(newValue.toString());
                    while (tracingArea.hasNext()) {
                        tracingareaCB.getItems().clear();
                        tracingareaCB.getItems().add(tracingArea.next());
                    }
                }
            }
        });
    }


    private void initialTable() {
        hotelIDCol.setCellValueFactory(new PropertyValueFactory<>("hotelID"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelCityCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        hotelBusinessCol.setCellValueFactory(new PropertyValueFactory<>("tradingArea"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManHotelListButtonCell = new WebManHotelListButtonCell();
                return webManHotelListButtonCell;
            }
        });
        final TableColumn[] tableColumns = {hotelIDCol, hotelNameCol, hotelCityCol, hotelBusinessCol, btnCol};
        hotelList.getColumns().addListener(new DisableColumnChangeListener(hotelList, tableColumns));
        hotelList.setItems(getHotelList());

    }
    private ObservableList getHotelList() {
        ObservableList<HotelVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.viewFullHotelList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 添加酒店
     */
    @FXML
    private void newHotel() {
        pane.getChildren().remove(0);
        pane.getChildren().add(new AddHotelPane(pane));
    }






    /**
     * Created by wyj on 2016/12/7.
     * Description: 网站管理人员工具类---酒店管理列表按钮
     */
    private class WebManHotelListButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button editBtn = new Button();
        final private Button deleteBtn = new Button();
        final private Button checkDetailBtn = new Button();

        private int selectedIndex;

        public WebManHotelListButtonCell() {

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

                hotelList.setPrefHeight(300);
                hotelList.setDisable(true);
                modifyPane.setVisible(true);

                HotelVO hotelVO = (HotelVO) hotelList.getItems().get(selectedIndex);
                hotelnameinput.setText(hotelVO.hotelName);
                cityCB.setValue(hotelVO.address);
                tracingareaCB.setValue(hotelVO.tradingArea);
                star.setValue(hotelVO.star);
            });


            deleteBtn.setOnAction(event -> {

                boolean confirm = alertController.showConfirmDeleteAlert("确认删除？", "删除确认");

                if (confirm) {
                    selectedIndex = getTableRow().getIndex();

                    HotelVO hotelVO = (HotelVO) hotelList.getItems().get(selectedIndex);
                    try {
                        ResultMessage resultMessage = hotelBlService.deleteHotel(hotelVO.hotelID);

                        if (resultMessage == ResultMessage.Success) {
                            System.out.println("delete success");

                            alertController.showUpdateSuccessAlert("删除成功！", "成功提示");

                            pane.getChildren().remove(0);
                            pane.getChildren().add(new HotelManagePane(pane));
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });

            checkDetailBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                HotelVO hotelVO = (HotelVO) hotelList.getItems().get(selectedIndex);
                pane.getChildren().remove(0);
                pane.getChildren().add(new CheckHotelInfoPane(pane, hotelVO.hotelID));
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
                deleteBtn.setTooltip(ToolTipShow.setTool("删除"));
                checkDetailBtn.setTooltip(ToolTipShow.setTool("查看详情"));
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setSpacing(10);
                btnBox.setPadding(new Insets(0, 0, 0 ,10));
                btnBox.getChildren().addAll(checkDetailBtn, editBtn, deleteBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }


        public int getSelectedIndex() {
            return selectedIndex;
        }
    }


    /**
     * 确认修改酒店信息
     */
    @FXML
    private void confirmModify() {
        if (isHotelInfoFull()) {
            HotelVO hotelVO = (HotelVO) hotelList.getItems().get(webManHotelListButtonCell.getSelectedIndex());

            hotelVO.hotelName = hotelnameinput.getText();
            hotelVO.address = cityCB.getValue().toString();
            hotelVO.tradingArea = tracingareaCB.getValue().toString();
            hotelVO.star = Integer.parseInt(star.getValue().toString());

            try {
                ResultMessage resultMessage = hotelBlService.updateBasicHotelInfo(hotelVO);

                if (resultMessage == ResultMessage.Success) {
                    System.out.println("update success");

                    alertController.showUpdateSuccessAlert("修改成功！", "成功提示");

                    hotelList.setPrefHeight(491);
                    hotelList.setDisable(false);
                    modifyPane.setVisible(false);

                    new HotelManagePane(pane);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            alertController.showInputWrongAlert("输入信息不完整", "错误提示");
        }
    }

    /**
     * 取消修改酒店信息
     */
    @FXML
    private void cancelModify() {
        boolean confirm = alertController.showConfirmCancelAlert();
        if (confirm) {
            hotelList.setPrefHeight(491);
            hotelList.setDisable(false);
            modifyPane.setVisible(false);
        }
    }

    private boolean isHotelInfoFull() {
        boolean name = !hotelnameinput.getText().equals("");
        boolean city = !cityCB.getValue().equals("");
        boolean area = !tracingareaCB.getValue().equals("");
        boolean s = !star.getValue().equals("");

        return name && city && area && s;
    }

}





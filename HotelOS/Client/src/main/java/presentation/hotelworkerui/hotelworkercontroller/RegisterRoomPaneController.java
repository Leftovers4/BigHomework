package presentation.hotelworkerui.hotelworkercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
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
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.util.other.DisableColumnChangeListener;
import util.EnumFactory;
import util.RoomType;
import vo.hotel.RoomVO;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class RegisterRoomPaneController {

    //按钮
    @FXML
    private Button addRoomBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;

    //点击增加按钮后显示出来的组件
    @FXML
    private HBox addHBox;
    @FXML
    private ComboBox roomBox;
    @FXML
    private TextField roomAmountField;
    @FXML
    private TextField roomPriceField;

    //列表
    @FXML
    private TableView roomTable;
    @FXML
    private TableColumn roomTypeCol;


    @FXML
    private TableColumn roomAmountCol;
    @FXML
    private TableColumn roomPriceCol;
    @FXML
    private TableColumn roomOpCol;

    private HotelBLService hotelBLService;
    private RoomListButtonCell roomListButtonCell;

    //提示框控制器
    private AlertController alertController;

    //是修改操作还是添加操作
    private Boolean isAdd;

    public void launch() {
        alertController = new AlertController();

        initService();
        initTable();
        initBox();
        initData();
    }


    private void initService() {
        try {
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomAmountCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        roomPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        roomOpCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                roomListButtonCell = new RoomListButtonCell();
                return roomListButtonCell;
            }
        });

        final TableColumn[] proMemColumns = {roomTypeCol, roomAmountCol, roomPriceCol, roomOpCol};
        roomTable.getColumns().addListener(new DisableColumnChangeListener(roomTable, proMemColumns));
    }

    private void initBox() {
        roomBox.getItems().addAll("单人房", "双人房", "标准房", "套房", "总统套房", "商务套房", "大床房", "家庭房", "情侣房");
        roomBox.setValue("单人房");
    }

    private void initData() {
        roomTable.setItems(getRoomVoList());
    }

    private ObservableList getRoomVoList() {
        ObservableList<RoomVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBLService.viewAllHotelRooms(522000));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

    @FXML
    private void addRoom() {
        isAdd = true;
        roomTable.setDisable(true);
        setAddComponentsVisible(true);
    }

    @FXML
    private void confirmAdd() {
        if (roomAmountField.getText().equals("") || roomPriceField.getText().equals(""))
            alertController.showInputWrongAlert("请输入客房数量和价格", "添加失败");
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9.]*$");
            Matcher matcherAmount = pattern.matcher(roomAmountField.getText());
            Matcher matcherPrice = pattern.matcher(roomPriceField.getText());

            if (matcherAmount.matches() && matcherPrice.matches()) {
                int roomAmount = Integer.valueOf(roomAmountField.getText());
                double roomPrice = Double.valueOf(roomPriceField.getText());

                if (roomAmount > 0 && roomPrice > 0) {
                    if (isAdd) {
                        roomTable.setDisable(false);
                        //添加客房
                        RoomVO roomVO = new RoomVO();
                        roomVO.hotelID = 522000;
                        roomVO.roomType = (RoomType) EnumFactory.getEnum(roomBox.getValue().toString());
                        roomVO.total = roomAmount;
                        roomVO.price = roomPrice;
                        try {
                            hotelBLService.addRoom(roomVO);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //修改客房
                        roomTable.setDisable(false);
                        roomBox.setDisable(false);
                        RoomVO roomVO = new RoomVO();
                        roomVO.roomID = ((RoomVO) roomTable.getItems().get(roomListButtonCell.getSelectedIndex())).roomID;
                        roomVO.total = roomAmount;
                        roomVO.price = roomPrice;
                        try {
                            hotelBLService.updateRoomInfo(roomVO);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }

                    //刷新列表数据
                    initData();
                    roomAmountField.clear();
                    roomPriceField.clear();
                    setAddComponentsVisible(false);
                } else alertController.showInputWrongAlert("客房数量和价格输入格式有误，请重新输入", "添加失败");
            } else alertController.showInputWrongAlert("客房数量和价格输入格式有误，请重新输入", "添加失败");
        }
    }

    @FXML
    private void cancelAdd() {
        if (!isAdd) roomBox.setDisable(false);
        roomTable.setDisable(false);
        roomAmountField.clear();
        roomPriceField.clear();
        setAddComponentsVisible(false);
    }

    public void setAddComponentsVisible(Boolean isVisible) {
        addHBox.setVisible(isVisible);
        confirmBtn.setVisible(isVisible);
        cancelBtn.setVisible(isVisible);
        addRoomBtn.setVisible(!isVisible);
    }

    /**
     * 操作栏按钮
     */
    private class RoomListButtonCell extends TableCell<RoomVO, Boolean> {
        final private HBox btnBox = new HBox();
        final private Button modifyButton = new Button();
        final private Button deleteButton = new Button();
        private int selectedIndex;

        public RoomListButtonCell() {
            Image modifyImage = new Image("/img/hotelworker/modifyroom.png");
            modifyButton.setGraphic(new ImageView(modifyImage));
            modifyButton.getStyleClass().add("TableButtonCell");

            Image deleteImage = new Image("/img/hotelworker/deleteroom.png");
            deleteButton.setGraphic(new ImageView(deleteImage));
            deleteButton.getStyleClass().add("TableButtonCell");

            modifyButton.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                RoomVO roomVO = (RoomVO) roomTable.getItems().get(selectedIndex);

                isAdd = false;
                roomTable.setDisable(true);
                setAddComponentsVisible(true);
                roomBox.setValue(roomVO.roomType);
                roomBox.setDisable(true);
                roomAmountField.setText(String.valueOf(roomVO.total));
                roomPriceField.setText(String.valueOf(roomVO.price));
            });

            deleteButton.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                if (alertController.showConfirmDeleteAlert("您确定要删除此类客房吗？", "确认删除")) {
                    RoomVO roomVO = (RoomVO) roomTable.getItems().get(selectedIndex);
                    try {
                        hotelBLService.deleteRoom(roomVO.roomID);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    initData();
                }
            });

            btnBox.setSpacing(10);
            btnBox.setAlignment(Pos.CENTER);
            btnBox.setPadding(new Insets(0, 10, 0, 20));
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                btnBox.getChildren().clear();
                btnBox.getChildren().addAll(modifyButton, deleteButton);
                setGraphic(btnBox);
                setText(null);
            }
        }

        public int getSelectedIndex() {
            return selectedIndex;
        }
    }
}

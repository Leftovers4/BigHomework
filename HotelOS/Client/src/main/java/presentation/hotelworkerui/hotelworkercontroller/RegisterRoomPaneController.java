package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.RoomListButtonCell;
import presentation.util.alert.AlertController;
import util.RoomType;
import vo.hotel.RoomVO;
import vo.hotel.ViewVOHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class RegisterRoomPaneController {

    //按钮
    @FXML private Button addRoomBtn;
    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;

    //点击增加按钮后显示出来的组件
    @FXML private HBox addHBox;
    @FXML private ComboBox roomBox;
    @FXML private TextField roomAmountField;
    @FXML private TextField roomPriceField;

    //列表
    @FXML private TableView roomTable;
    @FXML private TableColumn roomTypeCol;



    @FXML private TableColumn roomAmountCol;
    @FXML private TableColumn roomPriceCol;
    @FXML private TableColumn roomOpCol;

    private Stage stage;
    private ObservableList<RoomVO> roomVoList;
    private HotelBLService_Stub hotelBLServiceStub;
    private RoomListButtonCell roomListButtonCell;

    //提示框控制器
    private AlertController alertController;

    //是修改操作还是添加操作
    private Boolean isAdd;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        hotelBLServiceStub = new HotelBLService_Stub();
        alertController = new AlertController();
        initData();
    }

    private void initData() {
        roomVoList = getRoomVoList();

        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomAmountCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        roomPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        roomOpCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                roomListButtonCell = new RoomListButtonCell(roomTable,RegisterRoomPaneController.this);
                return roomListButtonCell;
            }
        });
        roomTable.setItems(roomVoList);
    }

    private ObservableList getRoomVoList(){
        ObservableList<RoomVO> list = FXCollections.observableArrayList(hotelBLServiceStub.findRoomsByHotelID(123456));
        return list;
    }

    @FXML
    private void addRoom(){
        isAdd = true;
        setAddComponentsVisible(true);
    }

    @FXML
    private void confirmAdd(){
        if(roomAmountField.getText().equals("") || roomPriceField.getText().equals(""))
            alertController.showInputWrongAlert("请输入客房数量和价格","添加失败");
        else {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9.]*$");
            Matcher matcherAmount = pattern.matcher(roomAmountField.getText());
            Matcher matcherPrice = pattern.matcher(roomPriceField.getText());

            if(matcherAmount.matches() && matcherPrice.matches()){

                int roomAmount = Integer.valueOf(roomAmountField.getText());
                double roomPrice = Double.valueOf(roomPriceField.getText());

                if(roomAmount > 0 && roomPrice > 0){
                    if(isAdd){
                        //添加客房
                        RoomVO roomVO = new ViewVOHelper().create(123456,RoomType.Single,roomAmount,roomPrice);
                        roomTable.getItems().add(roomVO);
                        hotelBLServiceStub.addRoom(roomVO);
                    }else {
                        //修改客房
                        roomTable.setDisable(false);
                        roomBox.setDisable(false);
                        ((RoomVO) roomTable.getItems().get(roomListButtonCell.getSelectedIndex())).total = roomAmount;
                        ((RoomVO) roomTable.getItems().get(roomListButtonCell.getSelectedIndex())).price = roomPrice;
                        roomTable.refresh();
                    }

                    roomAmountField.clear();
                    roomPriceField.clear();
                    setAddComponentsVisible(false);

                }else alertController.showInputWrongAlert("客房数量和价格输入格式有误，请重新输入","添加失败");
            }else alertController.showInputWrongAlert("客房数量和价格输入格式有误，请重新输入","添加失败");
        }
    }

    @FXML
    private void cancelAdd(){
        if(!isAdd) {
            roomTable.setDisable(false);
            roomBox.setDisable(false);
        }
        roomAmountField.clear();
        roomPriceField.clear();

        setAddComponentsVisible(false);
    }

    public void setAddComponentsVisible(Boolean isVisible){
        addHBox.setVisible(isVisible);
        confirmBtn.setVisible(isVisible);
        cancelBtn.setVisible(isVisible);

        addRoomBtn.setVisible(!isVisible);
    }

    public void setAdd(Boolean add) {
        isAdd = add;
    }

    public ComboBox getRoomBox() {
        return roomBox;
    }

    public TextField getRoomAmountField() {
        return roomAmountField;
    }

    public TextField getRoomPriceField() {
        return roomPriceField;
    }

    public AlertController getAlertController() {
        return alertController;
    }

}

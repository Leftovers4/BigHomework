package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentation.util.ConfirmAlert;
import presentation.util.InputWrongAlert;
import presentation.util.UnselectedAlert;
import util.RoomType;
import vo.hotel.RoomVO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class RegisterRoomPaneController {

    //按钮
    @FXML private Button addBtn;
    @FXML private Button modifyBtn;
    @FXML private Button deleteBtn;
    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;

    //点击增加按钮后显示出来的组件
    @FXML private HBox addHBox;
    @FXML private ComboBox roomBox;
    @FXML private TextField roomAmountField;
    @FXML private TextField roomPriceField;

    //列表
    @FXML private TableView roomTable;
    @FXML private TableColumn typeCol;
    @FXML private TableColumn amountCol;
    @FXML private TableColumn priceCol;

    private Stage stage;
    private ObservableList<RoomVO> roomVoList;
    private HotelBLService_Stub hotelBLServiceStub;
    //是修改操作还是添加操作
    private Boolean isAdd;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        this.hotelBLServiceStub = new HotelBLService_Stub();
        initData();
    }

    private void initData() {
        roomVoList = getRoomVoList();

        typeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("available"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        roomTable.setItems(roomVoList);
    }

    private ObservableList getRoomVoList(){
        ObservableList<RoomVO> list = FXCollections.observableArrayList(hotelBLServiceStub.findRoomsByHotelID(123456));
        return list;
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void addRoom(){
        isAdd = true;
        setAddComponentsVisible(true);
    }

    @FXML
    private void modifyRoom(){
        isAdd = false;
        RoomVO modifiedItem = (RoomVO) roomTable.getSelectionModel().getSelectedItem();

        if(modifiedItem == null){
            showUnSelectItemAlert("请先选择要修改的客房","修改失败");
        }else {
            roomTable.setDisable(true);
            setAddComponentsVisible(true);
            roomAmountField.setText(String.valueOf(modifiedItem.available));
            roomPriceField.setText(String.valueOf(modifiedItem.price));
        }
    }

    @FXML
    private void deleteRoom(){
        RoomVO deletedItem = (RoomVO) roomTable.getSelectionModel().getSelectedItem();

        if(deletedItem == null)
            showUnSelectItemAlert("请先选择要删除的客房","删除失败");
        else
            showConfirmDeleteAlert(deletedItem);
    }



    @FXML
    private void confirmAdd(){
        if(roomAmountField.getText().equals("") || roomPriceField.getText().equals("")) showInputNullAlert();
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
                        RoomVO roomVO = new RoomVO(0,123456,RoomType.Single,0,roomAmount,roomPrice);
                        roomTable.getItems().add(roomVO);
                        hotelBLServiceStub.addRoom(roomVO);
                    }else {
                        //修改客房
                        roomTable.setDisable(false);
                        ((RoomVO) roomTable.getSelectionModel().getSelectedItem()).available = roomAmount;
                        ((RoomVO) roomTable.getSelectionModel().getSelectedItem()).price = roomPrice;
                        roomTable.refresh();
                    }

                    roomAmountField.clear();
                    roomPriceField.clear();
                    setAddComponentsVisible(false);

                }else showFormatWrongAlert();
            }else showFormatWrongAlert();
        }
    }

    @FXML
    private void cancelAdd(){
        if(!isAdd) roomTable.setDisable(false);
        roomAmountField.clear();
        roomPriceField.clear();

        setAddComponentsVisible(false);
    }

    private void setAddComponentsVisible(Boolean isVisible){
        addHBox.setVisible(isVisible);
        confirmBtn.setVisible(isVisible);
        cancelBtn.setVisible(isVisible);

        addBtn.setVisible(!isVisible);
        modifyBtn.setVisible(!isVisible);
        deleteBtn.setVisible(!isVisible);
    }

    private void showFormatWrongAlert(){
        InputWrongAlert inputWrongAlert = new InputWrongAlert("客房数量和价格输入格式有误，请重新输入","添加失败");
        inputWrongAlert.showAndWait();
    }

    private void showInputNullAlert(){
        InputWrongAlert inputWrongAlert = new InputWrongAlert("请输入客房数量和价格","添加失败");
        inputWrongAlert.showAndWait();
    }
    private void showConfirmDeleteAlert(RoomVO deletedItem){
        ConfirmAlert confirmAlert = new ConfirmAlert("您确定要删除此类客房吗？","确认删除");
        confirmAlert.showAndWait();
        final ButtonType rtn = confirmAlert.getResult();
        if (rtn == ButtonType.OK) {
            roomTable.getItems().remove(deletedItem);
        }
    }

    private void showUnSelectItemAlert(String contentText, String title) {
        UnselectedAlert unselectedAlert = new UnselectedAlert(contentText,title);
        unselectedAlert.showAndWait();
    }
}

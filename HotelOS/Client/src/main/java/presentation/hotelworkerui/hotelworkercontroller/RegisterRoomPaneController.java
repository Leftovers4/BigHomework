package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import util.RoomType;
import vo.hotel.RoomVO;

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

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
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
        ObservableList<RoomVO> list= FXCollections.observableArrayList();
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
        setAddComponentsVisible(true);
    }

    @FXML
    private void modifyRoom(){}

    @FXML
    private void deleteRoom(){
        RoomVO deletedItem = (RoomVO) roomTable.getSelectionModel().getSelectedItem();
        roomTable.getItems().remove(deletedItem);
    }

    @FXML
    private void confirmAdd(){
        RoomVO roomVO = new RoomVO(0,123456,RoomType.Single,0,Integer.valueOf(roomAmountField.getText()),Double.valueOf(roomPriceField.getText()));
        roomTable.getItems().add(roomVO);

        roomAmountField.clear();
        roomPriceField.clear();

        setAddComponentsVisible(false);
    }

    @FXML
    private void cancelAdd(){}

    private void setAddComponentsVisible(Boolean isVisible){
        addHBox.setVisible(isVisible);
        confirmBtn.setVisible(isVisible);
        cancelBtn.setVisible(isVisible);

        addBtn.setVisible(!isVisible);
        modifyBtn.setVisible(!isVisible);
        deleteBtn.setVisible(!isVisible);
    }
}

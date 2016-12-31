package presentation.webmarketerui.webmarketercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.util.buttoncell.WebMarketListButtonCell;
import presentation.util.other.DisableColumnChangeListener;
import util.OrderType;
import vo.hotel.HotelVO;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class OrderListPaneController {

    //列表
    @FXML
    private TableView orderTable;
    //列表栏
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn userCol;
    @FXML
    private TableColumn hotelCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn opCol;
    @FXML
    private ComboBox hotelBox;
    @FXML
    private ComboBox orderTypeBox;
    @FXML
    private TextField searchField;


    private Pane mainPane;
    private OrderBLService orderBLService;
    private HotelBLService hotelBLService;

    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;

        alertController = new AlertController();

        initService();
        initBox();
        initTable();
        initData();
    }

    private void initService() {
        try {
            orderBLService = new OrderBlServiceImpl();
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    private void initBox() {
        orderTypeBox.getItems().addAll("所有订单", "未执行订单", "已执行订单", "异常订单", "撤销订单");
        addOrderBoxListener();

        HashMap<String, Long> nameToIdMap = null;
        try {
            ArrayList<HotelVO> list = (ArrayList<HotelVO>) hotelBLService.viewFullHotelList();
            nameToIdMap = new HashMap<>();
            hotelBox.getItems().add("所有酒店");
            for (HotelVO hotelVO: list) {
                hotelBox.getItems().add(hotelVO.hotelName);
                nameToIdMap.put(hotelVO.hotelName, hotelVO.hotelID);
            }
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }

        addHotelBoxListener(nameToIdMap);
    }

    private void initTable() {

        hotelCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        //操作列添加按钮
        opCol.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param) {
                return new WebMarketListButtonCell(mainPane,orderTable);
            }
        });

        final TableColumn[] columns = {hotelCol, idCol, userCol, typeCol, opCol};
        orderTable.getColumns().addListener(new DisableColumnChangeListener(orderTable, columns));
    }


    private void initData() {
        orderTable.setItems(getOrderVoList());
    }

    private ObservableList<OrderVO> getOrderVoList() {
        ObservableList<OrderVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBLService.viewFullOrderList());
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
        return list;
    }

    /**
     * 设置组合框的监听
     */
    private void addOrderBoxListener() {
        orderTypeBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    try {
                        switch ((String) newValue) {
                            case "所有订单":
                                orderTable.setItems(getOrderVoList());
                                break;
                            case "未执行订单":
                                orderTable.setItems(FXCollections.observableArrayList(orderBLService.viewTypeOrderList(OrderType.Unexecuted)));
                                break;
                            case "已执行订单":
                                orderTable.setItems(FXCollections.observableArrayList(orderBLService.viewTypeOrderList(OrderType.Executed)));
                                break;
                            case "异常订单":
                                orderTable.setItems(FXCollections.observableArrayList(orderBLService.viewTypeOrderList(OrderType.Abnormal)));
                                break;
                            case "撤销订单":
                                orderTable.setItems(FXCollections.observableArrayList(orderBLService.viewTypeOrderList(OrderType.Canceled)));
                                break;
                        }
                    } catch (RemoteException e) {
                        alertController.showNetConnectAlert();
                    }
                });
    }

    private void addHotelBoxListener(HashMap<String, Long> nameToIdMap) {
        hotelBox.getSelectionModel().selectedItemProperty().addListener(
                (o , oldValue, newValue) -> {
                    try {
                        if(newValue == "所有酒店")  orderTable.setItems(getOrderVoList());
                        else orderTable.setItems(FXCollections.observableArrayList(orderBLService.viewFullHotelOrderList((nameToIdMap.get(newValue)))));
                    } catch (RemoteException e) {
                        alertController.showNetConnectAlert();
                    }
                }
        );
    }


    @FXML
    private void searchOrderByID(){
        OrderVO orderVO = null;
        ObservableList<OrderVO> list = FXCollections.observableArrayList();
        try {
            orderVO = orderBLService.searchOrderByID(searchField.getText());
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
        if(orderVO != null) list.add(orderVO);
        orderTable.setItems(list);
    }

}

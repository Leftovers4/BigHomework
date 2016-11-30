//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Group;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
///**
// * Created by:Hitiger
// * Date: 2016/11/6   Time: 11:30
// * Description:
// */
//public class Controller implements Initializable{
//
//    ObservableList<String> orderPoList;
//
//    Stage stage;
//    @FXML private ComboBox comboBox;
//
//    @FXML private TableView tableView;
//
//    @FXML private TableColumn orderIDColumn;
//    @FXML private TableColumn userColumn;
//    @FXML private TableColumn orderCreatedTimeColumn;
//    @FXML private TableColumn orderStatusColumn;
//    @FXML private TableColumn detailsColumn;
//
//    public void setStage(Stage primaryStage) {
//        stage = primaryStage;
//    }
//
//    @FXML
//    public void initialize(URL location, ResourceBundle resources) {
//        orderPoList = getOrderPO();
//
//        //TODO 初始化订单类型（写成方法）
//        comboBox.getItems().removeAll(comboBox.getItems());
//        comboBox.getItems().addAll("所有订单", "未执行订单", "已执行订单","异常订单");
//        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue observable, String oldValue, String newValue) {
//                switch (newValue){
//                    case "所有订单" :
//                        showAllOrders();
//                        break;
//                    case "未执行订单" :
//                        showUnexecutedOrders();
//                        break;
//                    case "已执行订单" :
//                        showExecutedOrders();
//                        break;
//                    case "异常订单" :
//                        showAbnormalOrders();
//                        break;
//                }
//            }
//        });
//
//        //TODO 初始化订单列表（写成方法）
//        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
//        userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
//        orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("orderType"));
//        detailsColumn.setCellFactory(new DetailsCell());
//        tableView.setItems(orderPoList);
//
//        addItemListener(tableView);
////
//    }
//    /*添加item监听事件
//    * **/
//    private void addItemListener(TableView tableView){
//        //TODO 添加item监听事件
//        tableView.getSelectionModel().selectedItemProperty().addListener(
//
//                (v,oldValue,newValue) -> {
//                    OrderPO testPO = (OrderPO) tableView.getSelectionModel().getSelectedItem();
//                    System.out.println(testPO.getPersonAmount());
//                }
//        );
//    }
//
//    private void showAbnormalOrders() {
//        ObservableList<OrderPO> list= FXCollections.observableArrayList();
//        for (OrderPO orderPo : orderPoList){
//            if(orderPo.getOrderType() == OrderType.ABNORMAL){
//                list.add(orderPo);
//            }
//        }
//        tableView.setItems(list);
//        addItemListener(tableView);
//    }
//    private void showUnexecutedOrders() {
//        ObservableList<OrderPO> list= FXCollections.observableArrayList();
//        for (OrderPO orderPo : orderPoList){
//            if(orderPo.getOrderType() == OrderType.UNEXECUTED){
//                list.add(orderPo);
//            }
//        }
//        tableView.setItems(list);
//        addItemListener(tableView);
//    }
//    private void showExecutedOrders() {
//        ObservableList<OrderPO> list= FXCollections.observableArrayList();
//        for (OrderPO orderPo : orderPoList){
//            if(orderPo.getOrderType() == OrderType.EXECUTED){
//                list.add(orderPo);
//            }
//        }
//        tableView.setItems(list);
//        addItemListener(tableView);
//    }
//    private void showAllOrders() {
//        tableView.setItems(orderPoList);
//        addItemListener(tableView);
//    }
//
//    private ObservableList<String> getOrderPO(){
//        ObservableList<String> list= FXCollections.observableArrayList();
//        OrderPO order1=new OrderPO("12345678912345678",0,"user1",null,null,1,false,null,null);
//        order1.setOrderType(OrderType.EXECUTED);
//        OrderPO order2=new OrderPO("12345678912345679",0,"user2",null,null,1,false,null,null);
//        order2.setOrderType(OrderType.ABNORMAL);
//        OrderPO order3=new OrderPO("12345678912345670",0,"user3",null,null,1,false,null,null);
//        order3.setOrderType(OrderType.UNEXECUTED);
//        list.add(order1);
//        list.add(order2);
//        list.add(order3);
//        return list;
//    }
////    @FXML
////    public void test() {
////        System.out.println("666");
////        stage.setScene(new Scene(new Group(),600,400));
////
////    }
////
//    class DetailsCell implements Callback<TableColumn<OrderPO, String>, TableCell<OrderPO, String>> {
//
//        @Override
//        public TableCell<OrderPO, String> call(TableColumn<OrderPO, String> param) {
//
//            TableCell<OrderPO,String> cell = new TableCell<OrderPO, String>() {
//
//                Button btn = new Button( "查看详情" );
//
//
//
//                @Override
//                public void updateItem( String item, boolean empty ) {
//                    super.updateItem( item, empty );
//                    if ( empty ) {
//                        setGraphic( null );
//                        setText( null );
//                    } else {
//                        btn.setOnAction(e -> {
//                            stage.setScene(new DetailsScene(new Pane()));
//                        });
//                        setGraphic( btn );
//                        setText( null );
//                    }
//                }
//            };
//            return cell;
//        }
//    }

//
//    /*
//    *查看详情界面
//    **/
//}

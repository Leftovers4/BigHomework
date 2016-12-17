package presentation.hotelworkerui.hotelworkercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import presentation.hotelworkerui.hotelworkerscene.InfoPane;
import presentation.util.alert.AlertController;
import presentation.util.other.DisableColumnChangeListener;
import vo.order.ReviewVO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

import java.rmi.RemoteException;


/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class ReviewPaneController {

    @FXML private TableView reviewTable;

    @FXML private TableColumn reviewContentCol;
    @FXML private TableColumn reviewRatingCol;
    @FXML private TableColumn roomTypeCol;
    @FXML private TableColumn reviewTimeCol;
    @FXML private TableColumn userNameCol;
    @FXML private Label ratingLabel;
    @FXML private ComboBox rankBox;

    private Pane mainPane;
    private OrderBLService orderBLService;
    private AlertController alertController;
    private long hotelID;

    public void launch(Pane mainPane, String rating, long hotelID) {
        this.mainPane = mainPane;
        this.hotelID = hotelID;

        alertController = new AlertController();

        initService();
        initLabel(rating);
        initTable();
        initBox();
        initData();
    }

    private void initService() {
        try {
            orderBLService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initLabel(String rating) {
        ratingLabel.setText(rating);
    }

    private void initBox() {
        rankBox.getItems().addAll("所有","5","4","3","2","1");
        addBoxListener();
    }

    private void initTable() {
        reviewContentCol.setCellValueFactory(new PropertyValueFactory<>("review"));
        reviewRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        reviewTimeCol.setCellValueFactory(new PropertyValueFactory<>("reviewTime"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        reviewContentCol.setCellFactory(new Callback<TableColumn<ReviewVO, String>, TableCell<ReviewVO, String>>() {

            @Override
            public TableCell<ReviewVO, String> call(TableColumn<ReviewVO, String> param) {
                TableCell<ReviewVO, String> cell = new TableCell<>();
                Text text = new Text();
                text.setLineSpacing(5);
                text.setFill(Color.GRAY);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(reviewContentCol.widthProperty().divide(1.1));
                text.textProperty().bind(cell.itemProperty());
                cell.setPadding(new Insets(20,10,20,10));
                cell.setGraphic(text);
                return cell ;
            }

        });

        final TableColumn[] columns = {reviewContentCol, reviewRatingCol, roomTypeCol, reviewTimeCol, userNameCol};
        reviewTable.getColumns().addListener(new DisableColumnChangeListener(reviewTable, columns));

    }

    private void initData() {
        reviewTable.setItems(getReviewVoList());
    }

    private ObservableList<ReviewVO> getReviewVoList() {
        ObservableList<ReviewVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBLService.viewHotelReviewList(hotelID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 设置组合框的监听
     */
    private void addBoxListener() {
        rankBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    try {
                        String temp = newValue.toString();
                        if(temp.equals("所有")) reviewTable.setItems(getReviewVoList());
                        else reviewTable.setItems(FXCollections.observableArrayList(orderBLService.viewHotelReviewListByRating(hotelID, Integer.parseInt(temp))));
                    }catch (RemoteException e){
                        e.printStackTrace();
                    }
                });
    }
    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size() - 1);
    }
}

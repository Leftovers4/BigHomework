package presentation.hotelworkerui.hotelworkercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    @FXML private ImageView reviewstar1;
    @FXML private ImageView reviewstar2;
    @FXML private ImageView reviewstar3;
    @FXML private ImageView reviewstar4;
    @FXML private ImageView reviewstar5;
    @FXML private Label reviewperson;
    @FXML private ProgressBar star5bar;
    @FXML private ProgressBar star4bar;
    @FXML private ProgressBar star3bar;
    @FXML private ProgressBar star2bar;
    @FXML private ProgressBar star1bar;
    @FXML private Label star5person;
    @FXML private Label star4person;
    @FXML private Label star3person;
    @FXML private Label star2person;
    @FXML private Label star1person;


    private Pane mainPane;
    private String rating;
    private OrderBLService orderBLService;
    private AlertController alertController;
    private long hotelID;

    public void launch(Pane mainPane, String rating, long hotelID) {
        this.mainPane = mainPane;
        this.hotelID = hotelID;
        this.rating = rating;

        alertController = new AlertController();

        initService();
        initialReviewData();
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

    private void initialReviewData() {
        try {
            List<ReviewVO> list = orderBLService.viewHotelReviewList(hotelID);

            int reviewnum = list.size();
            reviewperson.setText(String.valueOf(reviewnum));

            List<ReviewVO> star1list = orderBLService.viewHotelReviewListByRating(hotelID, 1);
            List<ReviewVO> star2list = orderBLService.viewHotelReviewListByRating(hotelID, 2);
            List<ReviewVO> star3list = orderBLService.viewHotelReviewListByRating(hotelID, 3);
            List<ReviewVO> star4list = orderBLService.viewHotelReviewListByRating(hotelID, 4);
            List<ReviewVO> star5list = orderBLService.viewHotelReviewListByRating(hotelID, 5);
            star1person.setText(String.valueOf(star1list.size()));
            star2person.setText(String.valueOf(star2list.size()));
            star3person.setText(String.valueOf(star3list.size()));
            star4person.setText(String.valueOf(star4list.size()));
            star5person.setText(String.valueOf(star5list.size()));

            long rate = Math.round(Double.valueOf(rating));
            ArrayList<ImageView> starlist = new ArrayList<>(Arrays.asList(reviewstar1, reviewstar2, reviewstar3, reviewstar4, reviewstar5));
            Image image = new Image("/img/hotelworker/yellowstar.png");
            for (int i = 0; i<rate; i++) {
                starlist.get(i).setImage(image);
            }

            if(reviewnum > 0) {
                double i1 = star1list.size()/(double) reviewnum;
                double i2 = star2list.size()/(double) reviewnum;
                double i3 = star3list.size()/(double) reviewnum;
                double i4 = star4list.size()/(double) reviewnum;
                double i5 = star5list.size()/(double) reviewnum;
                star1bar.setProgress(i1);
                star2bar.setProgress(i2);
                star3bar.setProgress(i3);
                star4bar.setProgress(i4);
                star5bar.setProgress(i5);
            }
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

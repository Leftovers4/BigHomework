package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.beans.binding.Bindings;
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
import presentation.hotelworkerui.hotelworkerscene.ReviewPane;
import presentation.userui.userscene.UserGenerateOrderPane;
import presentation.util.buttoncell.UserHotelOrderListButtonCell;
import presentation.util.other.ToolTipShow;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;
import vo.order.OrderVO;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyj on 2016/12/11.
 */
public class UserHotelInfoController {

    private Stage stage;
    private Pane mainPane;
    private String userID;
    private Long hotelID;

    @FXML private TableView hotelOrderList;
    @FXML private TableColumn orderidCol;
    @FXML private TableColumn ordertimeCol;
    @FXML private TableColumn ordertypeCol;
    @FXML private TableColumn btnCol;

    @FXML private Label hotelNameLabel;
    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;
    @FXML private Label hotelRatingLabel;
    @FXML private Label addressLabel;
    @FXML private Label simpleIntroLabel;
    @FXML private Label hotelServiceLabel;

    @FXML private TableView hotelRoomList;
    @FXML private TableColumn roomtypeCol;
    @FXML private TableColumn roomnumCol;
    @FXML private TableColumn roompriceCol;
    @FXML private TableColumn generateBtnCol;

    @FXML private ImageView hotelphoto;

    private UserHotelOrderListButtonCell userHotelOrderListButtonCell;
    private HotelBlServiceImpl hotelBlService;

    private String rating;

    private ArrayList<ImageView> star;
    private String newpath = "C:/Leftovers/client/user/hotelImg/";

    public void launch(Stage stage, Pane mainPane, String userID, Long hotelID) {
        this.stage = stage;
        this.mainPane = mainPane;
        this.userID = userID;
        this.hotelID = hotelID;

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        star = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
        for (int i = 0; i<star.size(); i++) {
            star.get(i).setVisible(false);
        }

        initPhoto(hotelID);
        initialHotelRoomTable();
        initialOrderTable();
        initialData();
    }

    private void initPhoto(long hotelID) {
        try {
            HotelVO hotelVO = hotelBlService.viewBasicHotelInfo(hotelID);

            if (hotelVO.image != null) {
                String path = newpath + hotelID + ".jpg";
                File file = new File(path);

                if (file.exists()) {
                    Image image = new Image("file:///"+path);
                    hotelphoto.setImage(image);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initialData() {
        HotelVO hotelVO = null;
        try {
            hotelVO = hotelBlService.viewDetailedHotelInfo(hotelID, userID);

            hotelNameLabel.setText(hotelVO.hotelName);
            showStar(hotelVO.star);
            rating = String.valueOf(hotelVO.rating);
            hotelRatingLabel.setText(String.valueOf(hotelVO.rating));
            addressLabel.setText(hotelVO.address);
            simpleIntroLabel.setText(hotelVO.description);
            hotelServiceLabel.setText(hotelVO.service);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    private void showStar(int starNum) {
        for (int i = 0; i<starNum; i++) {
            star.get(i).setVisible(true);
        }
    }

    private void initialOrderTable() {

        System.out.println(hotelID);
        System.out.println(userID);

        orderidCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ordertimeCol.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
        ordertypeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userHotelOrderListButtonCell = new UserHotelOrderListButtonCell(stage, mainPane, hotelOrderList, userID);
                return userHotelOrderListButtonCell;
            }
        });
        hotelOrderList.setItems(getUserHotelOrderList());

        hotelOrderList.setFixedCellSize(50);
        hotelOrderList.prefHeightProperty().bind(hotelOrderList.fixedCellSizeProperty().multiply(Bindings.size(hotelOrderList.getItems()).add(1.01)));
        hotelOrderList.minHeightProperty().bind(hotelOrderList.prefHeightProperty());
        hotelOrderList.maxHeightProperty().bind(hotelOrderList.prefHeightProperty());
    }
    private ObservableList getUserHotelOrderList() {

        ObservableList<OrderVO> list = null;
        try {
            HotelVO hotelVO = hotelBlService.viewDetailedHotelInfo(hotelID, userID);

            list = FXCollections.observableArrayList(hotelVO.ordersByUserAndHotel);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    private void initialHotelRoomTable() {

        roomtypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomnumCol.setCellValueFactory(new PropertyValueFactory<>("available"));
        roompriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        generateBtnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new UserHotelRoomButtonCell();
            }
        });
        hotelRoomList.setItems(getHotelRoomList());

        hotelRoomList.setFixedCellSize(50);
        hotelRoomList.prefHeightProperty().bind(hotelRoomList.fixedCellSizeProperty().multiply(Bindings.size(hotelRoomList.getItems()).add(1.01)));
        hotelRoomList.minHeightProperty().bind(hotelRoomList.prefHeightProperty());
        hotelRoomList.maxHeightProperty().bind(hotelRoomList.prefHeightProperty());
    }
    private ObservableList getHotelRoomList() {
        ObservableList<RoomVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.viewAllHotelRooms(hotelID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * Created by wyj on 2016/12/14.
     */
    private class UserHotelRoomButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button bookBtn = new Button();
        private int selectedIndex;

        public UserHotelRoomButtonCell() {

            Image image = new Image("/img/user/generateOrder.png");
            ImageView bookimgview = new ImageView(image);
            bookBtn.setGraphic(bookimgview);
            bookBtn.getStyleClass().add("TableCreateButtonCell");

            bookBtn.setTooltip(ToolTipShow.setTool("立即预订"));
            bookBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                RoomVO roomVO = (RoomVO) hotelRoomList.getItems().get(selectedIndex);
                mainPane.getChildren().add(new UserGenerateOrderPane(stage, mainPane, userID, hotelID, roomVO.roomType));
            });
        }

        public int getSelectedIndex() {
            return selectedIndex;
        }



        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                btnBox.getChildren().clear();
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setPadding(new Insets(0, 0, 0, 13));
                btnBox.getChildren().add(bookBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }
    }



    @FXML
    private void checkHotelReview() {
        mainPane.getChildren().add(new ReviewPane(mainPane, rating, hotelID));
    }

    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size() - 1);
    }
}

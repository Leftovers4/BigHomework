package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.UserHotelOrderListButtonCell;
import vo.hotel.HotelVO;
import vo.order.OrderVO;

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

    private UserHotelOrderListButtonCell userHotelOrderListButtonCell;
    private HotelBlServiceImpl hotelBlService;

    private ArrayList<ImageView> star;

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

        initialTable();
        initialData();
    }

    private void initialData() {
        HotelVO hotelVO = null;
        try {
            hotelVO = hotelBlService.viewDetailedHotelInfo(hotelID, userID);

            hotelNameLabel.setText(hotelVO.hotelName);
            showStar(hotelVO.star);
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

    private void initialTable() {

        System.out.println(hotelID);
        System.out.println(userID);

        orderidCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ordertimeCol.setCellValueFactory(new PropertyValueFactory<>("orderTimeVO"));
        ordertypeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userHotelOrderListButtonCell = new UserHotelOrderListButtonCell(stage, mainPane, hotelOrderList, userID);
                return userHotelOrderListButtonCell;
            }
        });
        hotelOrderList.setItems(getUserHotelOrderList());
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
}

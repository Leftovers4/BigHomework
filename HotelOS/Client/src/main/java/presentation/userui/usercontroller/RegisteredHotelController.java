package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.RegisteredHotelListButtonCell;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/22.
 */
public class RegisteredHotelController {

    private Stage stage;
    private Pane mainPane;
    private String userID;

    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn hotelAddressCol;
    @FXML private TableColumn hoteltracingCol;
    @FXML private TableColumn btnCol;
    @FXML private TableView registeredHotelList;

    private RegisteredHotelListButtonCell registeredHotelListButtonCell;
    private HotelBlServiceImpl hotelBlService;

    public void launch(Stage primaryStage, Pane pane, String userID) {
        this.stage = primaryStage;
        this.mainPane = pane;
        this.userID = userID;

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }


    private void initialData() {
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        hoteltracingCol.setCellValueFactory(new PropertyValueFactory<>("tradingArea"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                registeredHotelListButtonCell = new RegisteredHotelListButtonCell(stage, mainPane, registeredHotelList, userID);
                return registeredHotelListButtonCell;
            }
        });

        registeredHotelList.setItems(getRegisteredHotelList());
    }

    private ObservableList getRegisteredHotelList() {
        ObservableList<HotelVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.viewOrderedHotelList(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

}

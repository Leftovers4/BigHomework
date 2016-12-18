package presentation.userui.usercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.beans.binding.Bindings;
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
import presentation.util.buttoncell.HotelPhotoButtonCell;
import presentation.util.buttoncell.RegisteredHotelListButtonCell;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/22.
 * description: 查看预订过的酒店
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

    private int index;

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
        index = -1;

        hotelNameCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                index++;
                return new HotelPhotoButtonCell(getRegisteredHotelList(), index, hotelBlService);
            }
        });
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

        registeredHotelList.setFixedCellSize(170);
        registeredHotelList.prefHeightProperty().bind(registeredHotelList.fixedCellSizeProperty().multiply(Bindings.size(registeredHotelList.getItems()).add(1.01)));
        registeredHotelList.minHeightProperty().bind(registeredHotelList.prefHeightProperty());
        registeredHotelList.maxHeightProperty().bind(registeredHotelList.prefHeightProperty());
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

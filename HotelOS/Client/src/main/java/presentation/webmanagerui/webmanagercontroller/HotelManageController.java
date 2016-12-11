package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.WebManHotelListButtonCell;
import presentation.webmanagerui.webmanagerscene.AddHotelPane;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelManageController {

    private Stage stage;
    private Pane pane;

    @FXML private Button hoteldetailBtn;
    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;
    @FXML private Button searchhotelBtn;
    @FXML private Button newhotelBtn;
    @FXML private Button edithotelBtn;
    @FXML private Button deletehotelBtn;
    @FXML private TextField hotelidinput;
    @FXML private TextField hotelnameinput;

    @FXML private TableView hotelList;
    @FXML private TableColumn hotelIDCol;
    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn hotelCityCol;
    @FXML private TableColumn hotelBusinessCol;
    @FXML private TableColumn btnCol;

    private HotelBlServiceImpl hotelBlService;
    private WebManHotelListButtonCell webManHotelListButtonCell;


    public void launch(Stage primaryStage, Pane mainPane) {
        this.pane = mainPane;
        this.stage = primaryStage;

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialTable();
    }


    private void initialTable() {
        hotelIDCol.setCellValueFactory(new PropertyValueFactory<>("hotelID"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelCityCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        hotelBusinessCol.setCellValueFactory(new PropertyValueFactory<>("tradingArea"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManHotelListButtonCell = new WebManHotelListButtonCell(stage, pane, hotelList);
                return webManHotelListButtonCell;
            }
        });
        hotelList.setItems(getHotelList());
    }
    private ObservableList getHotelList() {
        ObservableList<HotelVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.viewFullHotelList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }







    /**
     * 添加酒店
     */
    @FXML
    private void newHotel() {
        pane.getChildren().remove(0);
        pane.getChildren().add(new AddHotelPane(stage));
    }







//    /**
//     * 修改酒店信息
//     */
//    @FXML
//    private void modifyHotel() {
//        hoteldetailBtn.setVisible(false);
//        hotelnameinput.setVisible(true);
//        hotelidinput.setVisible(true);
//        confirmBtn.setVisible(true);
//        cancelBtn.setVisible(true);
//
////        hotelidinput.setText();
//    }
}

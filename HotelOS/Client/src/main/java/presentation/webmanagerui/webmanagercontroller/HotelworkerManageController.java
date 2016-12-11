package presentation.webmanagerui.webmanagercontroller;

import bl.personnelbl.impl.PersonnelBLServiceImpl;
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
import presentation.util.buttoncell.WebManHotelworkerButtonCell;
import presentation.webmanagerui.webmanagerscene.AddHotelWorkerPane;
import util.PersonnelType;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelworkerManageController {

    private Stage stage;
    private Pane pane;

    @FXML private TableView hotelworkerList;
    @FXML private TableColumn hotelIDCol;
    @FXML private TableColumn hotelworkerIDCol;
    @FXML private TableColumn hotelworkerNameCol;
    @FXML private TableColumn btnCol;

    private PersonnelBLServiceImpl personnelBLService;
    private WebManHotelworkerButtonCell webManHotelworkerButtonCell;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.pane = mainPane;

        try {
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


    private void initialData() {
        hotelIDCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelworkerIDCol.setCellValueFactory(new PropertyValueFactory<>("personnelID"));
        hotelworkerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManHotelworkerButtonCell = new WebManHotelworkerButtonCell(stage, pane, hotelworkerList);
                return webManHotelworkerButtonCell;
            }
        });
        hotelworkerList.setItems(getHotelWorkerList());
    }
    private ObservableList getHotelWorkerList() {
        ObservableList<PersonnelVO> list = null;
        try {
            list = FXCollections.observableArrayList(personnelBLService.viewTypePersonnelList(PersonnelType.HotelWorker));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }



    @FXML
    private void toaddHotelWorker() {
        pane.getChildren().remove(0);
        pane.getChildren().add(new AddHotelWorkerPane(stage));
    }
}

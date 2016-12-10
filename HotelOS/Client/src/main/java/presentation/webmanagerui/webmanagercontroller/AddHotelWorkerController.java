package presentation.webmanagerui.webmanagercontroller;

import bl.personnelbl.impl.PersonnelBLServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.rmi.RemoteException;


/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelWorkerController {

    private Stage stage;
    @FXML private Pane addhotelworkerPane;
    @FXML private TableView hotelworkerlist;

    @FXML private TableColumn hotelnameCol;
    @FXML private TableColumn workeridCol;
    @FXML private TableColumn workerphoneCol;
    @FXML private TableColumn workernameCol;
    @FXML private TableColumn btnCol;

    @FXML private TextField workernameField;
    @FXML private TextField workerphoneField;

    private PersonnelBLServiceImpl personnelBLService;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void fillHotelWorkerInfo() {
        addhotelworkerPane.setVisible(true);
        hotelworkerlist.setPrefHeight(150);
    }

    @FXML
    private void confirmToAdd() {
        addhotelworkerPane.setVisible(false);
        hotelworkerlist.setPrefHeight(370);
    }
}

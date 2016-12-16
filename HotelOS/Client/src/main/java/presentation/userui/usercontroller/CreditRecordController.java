package presentation.userui.usercontroller;

import bl.userbl.impl.UserBlServiceImpl;
import blservice_stub.UserBLService_Stub;
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
import presentation.userui.userscene.InfoPane;
import presentation.util.buttoncell.CreditTabelButtonCell;
import util.CreditChangedCause;
import vo.user.CreditRecordVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by wyj on 2016/11/25.
 */
public class CreditRecordController {


    private Stage stage;
    private Pane mainPane;
    private String userID;

    @FXML private TableView creditRecordTable;

    @FXML private TableColumn timeCol;
    @FXML private TableColumn orderidCol;
    @FXML private TableColumn causeCol;
    @FXML private TableColumn changeNumCol;
    @FXML private TableColumn finalNumCol;
    @FXML private TableColumn optCol;

    private CreditTabelButtonCell creditTabelButtonCell;

    private UserBlServiceImpl userBlService;


    public void launch(Stage primaryStage, Pane mainPane, String userID) {
        this.mainPane = mainPane;
        this.stage = primaryStage;
        this.userID = userID;

        try {
            userBlService = new UserBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        timeCol.setCellValueFactory(new PropertyValueFactory<>("changedTime"));
        orderidCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        causeCol.setCellValueFactory(new PropertyValueFactory<>("creditChangedCause"));
        changeNumCol.setCellValueFactory(new PropertyValueFactory<>("changedCredit"));
        finalNumCol.setCellValueFactory(new PropertyValueFactory<>("currentCredit"));

        try {
            List<CreditRecordVO> creditRecordVOS = userBlService.getCreditRecordsByUsername(userID);

            for (int i = 0; i<creditRecordVOS.size(); i++) {
                if (creditRecordVOS.get(i).creditChangedCause != CreditChangedCause.Recharge) {
                    optCol.setCellFactory(new Callback<TableColumn, TableCell>() {
                        @Override
                        public TableCell call(TableColumn param) {
                            creditTabelButtonCell = new CreditTabelButtonCell(stage, mainPane, creditRecordTable, userID);
                            return creditTabelButtonCell;
                        }
                    });
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        creditRecordTable.setItems(getCreditRecordList());
    }

    private ObservableList getCreditRecordList() {
        ObservableList<CreditRecordVO> list = null;
        try {
            list = FXCollections.observableArrayList(userBlService.getCreditRecordsByUsername(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

    @FXML
    private void back(){
        //TODO
    }
}
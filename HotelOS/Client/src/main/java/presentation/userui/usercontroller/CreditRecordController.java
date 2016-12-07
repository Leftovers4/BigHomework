package presentation.userui.usercontroller;

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
import presentation.util.buttoncell.CreditTabelButtonCell;
import vo.user.CreditRecordVO;

/**
 * Created by wyj on 2016/11/25.
 */
public class CreditRecordController {


    private Stage stage;
    private Pane mainPane;

    @FXML private TableView creditRecordTable;

    @FXML private TableColumn timeCol;
    @FXML private TableColumn orderidCol;
    @FXML private TableColumn causeCol;
    @FXML private TableColumn changeNumCol;
    @FXML private TableColumn finalNumCol;
    @FXML private TableColumn optCol;

    private CreditTabelButtonCell creditTabelButtonCell;

    private UserBLService_Stub userBLService_stub;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.mainPane = mainPane;
        this.stage = primaryStage;
        userBLService_stub = new UserBLService_Stub();
        initialData();
    }

    private void initialData() {
        timeCol.setCellValueFactory(new PropertyValueFactory<>("changedTime"));
        orderidCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        causeCol.setCellValueFactory(new PropertyValueFactory<>("creditChangedCause"));
        changeNumCol.setCellValueFactory(new PropertyValueFactory<>("changedCredit"));
        finalNumCol.setCellValueFactory(new PropertyValueFactory<>("currentCredit"));
        optCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                creditTabelButtonCell = new CreditTabelButtonCell(stage, mainPane, creditRecordTable);
                return creditTabelButtonCell;
            }
        });

        creditRecordTable.setItems(getCreditRecordList());
    }

    private ObservableList getCreditRecordList() {
        ObservableList<CreditRecordVO> list = FXCollections.observableArrayList(userBLService_stub.getCreditRecordsByUsername("leftovers01"));
        return list;
    }


}
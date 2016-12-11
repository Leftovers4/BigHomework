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
import presentation.util.buttoncell.WebManMarketerButtonCell;
import util.PersonnelType;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmarketerManageController {

    private Stage stage;
    private Pane mainPane;

    @FXML private Pane addwebmarketerPane;
    @FXML private TableView webmarketerlist;

    @FXML private TableColumn webmarketerIDCol;
    @FXML private TableColumn webmarketerNameCol;
    @FXML private TableColumn btnCol;

    private PersonnelBLServiceImpl personnelBLService;
    private WebManMarketerButtonCell webManMarketerButtonCell;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        try {
            personnelBLService = new PersonnelBLServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }


    private void initialData() {
        webmarketerIDCol.setCellValueFactory(new PropertyValueFactory<>("personnelID"));
        webmarketerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManMarketerButtonCell = new WebManMarketerButtonCell(stage, mainPane, webmarketerlist);
                return webManMarketerButtonCell;
            }
        });
        webmarketerlist.setItems(getWebMarketerList());
    }
    private ObservableList getWebMarketerList() {
        ObservableList<PersonnelVO> list = null;
        try {
            list = FXCollections.observableArrayList(personnelBLService.viewTypePersonnelList(PersonnelType.WebMarketer));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 添加网站管理人员
     */
    @FXML
    private void addWebMarketerEvent() {
        addwebmarketerPane.setVisible(true);
        webmarketerlist.setPrefHeight(200);
    }

    /**
     * 保存添加
     */
    @FXML
    private void saveWebMarketerInfo() {
        addwebmarketerPane.setVisible(false);
        webmarketerlist.setPrefHeight(400);
    }
}

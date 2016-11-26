package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.InfoPane;
import presentation.util.AlertController;
import vo.order.ReviewVO;

import java.time.LocalDateTime;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class ReviewPaneController {

    @FXML private TableView reviewTable;

    @FXML private TableColumn reviewContentCol;
    @FXML private TableColumn reviewRatingCol;
    @FXML private TableColumn roomTypeCol;
    @FXML private TableColumn reviewTimeCol;
    @FXML private TableColumn userNameCol;


    private Stage stage;
    private Pane mainPane;
    private OrderBLService_Stub orderBLServiceStub;
    private AlertController alertController;
    private ObservableList<ReviewVO> reviewVoList;

    public void launch(Stage primaryStage,Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        orderBLServiceStub = new OrderBLService_Stub();
        alertController = new AlertController();

        initTable();
    }

    private void initTable() {
        reviewVoList = getReviewVoList();

        reviewContentCol.setCellValueFactory(new PropertyValueFactory<>("review"));
        reviewRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        reviewTimeCol.setCellValueFactory(new PropertyValueFactory<>("reviewTime"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));


        reviewTable.setItems(reviewVoList);
    }

    public ObservableList<ReviewVO> getReviewVoList() {
        ObservableList<ReviewVO> list = FXCollections.observableArrayList();
       for (int i =0; i<50;i++){
           list.add(new ReviewVO("user",123456, LocalDateTime.now(),5,"很好啊"));
       }
        return list;
    }
    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void back(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new InfoPane(stage,mainPane));
    }


}

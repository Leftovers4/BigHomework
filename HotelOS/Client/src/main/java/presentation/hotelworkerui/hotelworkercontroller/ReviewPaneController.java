package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import presentation.hotelworkerui.hotelworkerscene.InfoPane;
import presentation.util.AlertController;
import presentation.util.DisableColumnChangeListener;
import vo.order.ReviewVO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;


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

    @FXML private ComboBox rankBox;

    private Pane mainPane;
    private OrderBLService_Stub orderBLServiceStub;
    private AlertController alertController;
    private ObservableList<ReviewVO> reviewVoList;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;

        orderBLServiceStub = new OrderBLService_Stub();
        alertController = new AlertController();

        initTable();
        initBox();
    }

    private void initBox() {
        rankBox.getItems().addAll("5","4","3","2","1");
    }

    private void initTable() {
        reviewVoList = getReviewVoList();

        reviewContentCol.setCellValueFactory(new PropertyValueFactory<>("review"));
        reviewRatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        reviewTimeCol.setCellValueFactory(new PropertyValueFactory<>("reviewTime"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        reviewContentCol.setCellFactory(new Callback<TableColumn<ReviewVO, String>, TableCell<ReviewVO, String>>() {

            @Override
            public TableCell<ReviewVO, String> call(TableColumn<ReviewVO, String> param) {
                TableCell<ReviewVO, String> cell = new TableCell<>();
                Text text = new Text();
                text.setLineSpacing(5);
                text.setFill(Color.GRAY);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(reviewContentCol.widthProperty().divide(1.1));
                text.textProperty().bind(cell.itemProperty());
                cell.setPadding(new Insets(20,10,20,10));
                cell.setGraphic(text);
                return cell ;
            }

        });


        reviewTable.setItems(reviewVoList);


//        reviewTable.setFixedCellSize(reviewContentCol.);
//        reviewTable.prefHeightProperty().bind(reviewTable.fixedCellSizeProperty().multiply(Bindings.size(reviewTable.getItems()).add(1.01)));
//        reviewTable.minHeightProperty().bind(reviewTable.prefHeightProperty());
//        reviewTable.maxHeightProperty().bind(reviewTable.prefHeightProperty());

        final TableColumn[] columns = {reviewContentCol, reviewRatingCol, roomTypeCol, reviewTimeCol, userNameCol};
        reviewTable.getColumns().addListener(new DisableColumnChangeListener(reviewTable, columns));

    }

    public ObservableList<ReviewVO> getReviewVoList() {
        ObservableList<ReviewVO> list = FXCollections.observableArrayList();
       for (int i =0; i<2;i++){
           ReviewVO reviewVO = new ReviewVO();
           reviewVO.orderID = "12345678912345678";
           reviewVO.rating = 5;
           reviewVO.review = "据科学测定，一个成年人的全身总血量相当于体重的8%左右，即50公斤体重的人，体内血液总量为4000毫升。每次献血200毫升，只占全身血量的5%左右；人体中平时只有80%的血液在全身循环，还有20%（约有800毫升）的血液储存在肝脏、脾脏、皮肤等小血库中备用。献血后，这些储备中的血液会很快释放到血液循环中来。另外，献血后骨髓造血速度也会加快。因此，按规定献血不会影响健康";
           reviewVO.username = "路人";
           list.add(reviewVO);
       }
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.orderID = "12345678912345678";
        reviewVO.rating = 5;
        reviewVO.review = "made";
        reviewVO.username = "路人";
        list.add(reviewVO);
        return list;
    }

    /**
     * TODO
     * 设置组合框的监听
     */
    private void addBoxListener() {
        rankBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    switch ((String) newValue) {
                        case "5":
                            break;
                        case "4":
                            break;
                        case "3":
                            break;
                        case "2":
                            break;
                        case "1":
                            break;
                    }
                });
    }
    @FXML
    private void back(){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new InfoPane(mainPane));
    }
}

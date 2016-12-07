package presentation.webmanagerui.webmanagercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagerscene.AddHotelPane;

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


    public void launch(Stage primaryStage, Pane mainPane) {
        this.pane = mainPane;
        this.stage = primaryStage;
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

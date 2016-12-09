package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.EvaluateOrderPane;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/25.
 */
public class OrderDetailUserController {

    private Stage stage;
    private Pane mainPane;
    private String orderID;

    @FXML private Label checkIndateLabeldet;
    @FXML private Label checkInTimeLabeldet;
    @FXML private Label checkOutDateLabeldet;
    @FXML private Label checkOutTimeLabeldet;
    @FXML private Label roomTypeLabeldet;
    @FXML private Label roomNumLabeldet;
    @FXML private Label peopleNumLabeldet;
    @FXML private Label childdet;
    @FXML private Label bestpromotionLabel;
    @FXML private Label finalpriceLabel;
    @FXML private Label ordertypeLabel;
    @FXML private Button evaluateBtn;

    private OrderBlServiceImpl orderBlService;

    public void launch(Stage primaryStage, Pane mainPane, String orderID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.orderID = orderID;

        try {
            orderBlService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    private void initialData() {
        
    }


    @FXML
    private void evaluateOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new EvaluateOrderPane(stage));
    }
}

package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.InfoPane;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class ReviewPaneController {

    private Stage stage;
    private Pane mainPane;
    private OrderBLService_Stub orderBLServiceStub;

    public void launch(Stage primaryStage,Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        orderBLServiceStub = new OrderBLService_Stub();

        initData();
    }

    private void initData() {

    }

    @FXML
    private void closeWindow(){
        stage.close();
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

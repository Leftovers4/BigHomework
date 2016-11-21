package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderDetailPaneController {


    private Stage stage;
    private Pane mainPane;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
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
        mainPane.getChildren().add(new FindOrderPane(stage,mainPane));
    }
}

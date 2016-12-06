package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.CreditRecordController;
import presentation.userui.usercontroller.InfoPaneController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/25.
 * Description: 查看信用历史记录
 */
public class CreditRecordPane extends Pane {

    public CreditRecordPane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage, mainPane);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/creditRecord.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CreditRecordController creditRecordController = fxmlLoader.getController();
        creditRecordController.launch(primaryStage, mainPane);
    }
}

package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmarketerui.webmarketercontroller.AppealOrderPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AppealOrderPane extends Pane{
    public AppealOrderPane(Pane mainPane) {
        loadFxml(mainPane);
    }

    private void loadFxml(Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/webmarketer/weborderappeal.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppealOrderPaneController appealOrderPaneController = fxmlLoader.getController();
        appealOrderPaneController.launch(mainPane);
    }
}

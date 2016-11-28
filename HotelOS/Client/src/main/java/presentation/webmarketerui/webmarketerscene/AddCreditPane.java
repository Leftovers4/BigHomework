package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmarketerui.webmarketercontroller.AddCreditPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AddCreditPane extends Pane{
    public AddCreditPane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage,mainPane);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/webmarketer/webaddcredit.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddCreditPaneController addCreditPaneController = fxmlLoader.getController();
        addCreditPaneController.launch(primaryStage,mainPane);
    }
}

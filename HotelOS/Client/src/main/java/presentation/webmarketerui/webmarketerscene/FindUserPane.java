package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmarketerui.webmarketercontroller.FindUserPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindUserPane extends Pane{

    public FindUserPane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage,mainPane);
    }

    private void loadFxml(Stage primaryStage,Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/webmarketer/webfinduser.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FindUserPaneController findUserPaneController = fxmlLoader.getController();
        findUserPaneController.launch(primaryStage,mainPane);
    }
}

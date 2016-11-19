package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.InfoPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户查看基本信息界面
 */
public class InfoPane extends Pane{

    public InfoPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/userinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InfoPaneController infoPaneController = fxmlLoader.getController();
        infoPaneController.launch(primaryStage);
    }
}

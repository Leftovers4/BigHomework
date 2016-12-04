package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.InfoPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户查看基本信息界面
 */
public class InfoPane extends Pane{

    public InfoPane(Stage primaryStage, Pane mainPane, ImageView topbarphoto) {
        loadFxml(primaryStage, mainPane, topbarphoto);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, ImageView topbarphoto) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/userInfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InfoPaneController infoPaneController = fxmlLoader.getController();
        infoPaneController.launch(primaryStage, mainPane, topbarphoto);
    }
}

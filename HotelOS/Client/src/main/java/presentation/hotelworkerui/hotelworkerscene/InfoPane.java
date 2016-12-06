package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.InfoPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/16.
 * Description : 酒店工作人员查看酒店信息界面
 */
public class InfoPane extends Pane{


    public InfoPane(Pane mainPane) {
        loadFxml(mainPane);
    }

    private void loadFxml(Pane mainPane) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InfoPaneController infoPaneController = fxmlLoader.getController();
        infoPaneController.launch(mainPane);
    }
}

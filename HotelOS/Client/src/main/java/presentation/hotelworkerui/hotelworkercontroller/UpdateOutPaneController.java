package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOfflinePane;
import presentation.util.alert.AlertController;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class UpdateOutPaneController {


    //选择入住方式的组件
    @FXML Button outOnlineBtn;
    @FXML Button outOfflineBtn;

    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void outOnline(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new FindOrderPane(mainPane,false));
    }

    @FXML
    private void outOffline(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UpdateOfflinePane(mainPane,false));
    }
}

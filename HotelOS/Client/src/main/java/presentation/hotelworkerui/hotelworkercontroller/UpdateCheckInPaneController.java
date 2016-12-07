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
public class UpdateCheckInPaneController {

    //选择入住方式的组件
    @FXML Button checkinOnlineBtn;
    @FXML Button checkinOfflineBtn;

    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }


    /**
    * 线上入住
    */
    @FXML
    private void checkinOnline(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new FindOrderPane(mainPane,true));
    }

    /**
     * 线下入住
     */
    @FXML
    private void checkinOffline(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UpdateOfflinePane(mainPane,true));
    }

}

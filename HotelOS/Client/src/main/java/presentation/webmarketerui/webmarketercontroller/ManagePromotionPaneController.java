package presentation.webmarketerui.webmarketercontroller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.util.MySlider;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class ManagePromotionPaneController {
    //会员优惠
    @FXML private VBox memberVBox;
    @FXML private HBox addMemPromotionHBox;
    //特定期间优惠
    @FXML private Button  timeBtn;
    @FXML private VBox timeVBox;
    @FXML private HBox addTimeHBox;
    //滑块
    @FXML private Label sliderPromotionLabel;

    private Stage stage;
    private AlertController alertController;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        alertController = new AlertController();


        //设置特定期间优惠按钮默认被选中
        makeTimeFocused();
    }

    private void makeTimeFocused() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timeBtn.requestFocus();
            }
        });
    }

    @FXML
    private void addTimePromotion() {
    }

    @FXML
    private void modifyTimePromotion() {
    }

    @FXML
    private void deleteTimePromotion() {
    }

    @FXML
    private void confirmTimeAdd() {
    }

    @FXML
    private void cancelTimeAdd() {
    }

    @FXML
    private void addMemPromotion() {
    }

    @FXML
    private void modifyMemPromotion() {
    }

    @FXML
    private void deleteMemPromotion() {
    }

    @FXML
    private void confirmMemAdd() {
    }

    @FXML
    private void cancelMemAdd() {
    }

    @FXML
    private void showTimePromotion(){
        timeVBox.setVisible(true);
        memberVBox.setVisible(false);
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,36);
    }

    @FXML
    private void showMemberPromotion(){
        memberVBox.setVisible(true);
        timeVBox.setVisible(false);
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,168);
    }

}

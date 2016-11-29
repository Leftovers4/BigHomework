package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentation.util.AlertController;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class ManagePromotionPaneController {

    //生日优惠
    @FXML private Button addBirthBtn;
    @FXML private Button modifyBirthBtn;
    @FXML private Button deleteBirthBtn;
    @FXML private Button confirmBirthBtn;
    @FXML private Button cancelBirthBtn;
    @FXML private HBox   addBirthHBox;
    //多间预订优惠
    @FXML private Button addRoomsBtn;
    @FXML private Button modifyRoomsBtn;
    @FXML private Button deleteRoomsBtn;
    @FXML private Button confirmRoomsBtn;
    @FXML private Button cancelRoomsBtn;
    @FXML private HBox   addRoomsHBox;
    //特定期间优惠
    @FXML private Button addTimeBtn;
    @FXML private Button modifyTimeBtn;
    @FXML private Button deleteTimeBtn;
    @FXML private Button confirmTimeBtn;
    @FXML private Button cancelTimeBtn;
    @FXML private HBox   addTimeHBox;
    //合作企业优惠
    @FXML private Button addComBtn;
    @FXML private Button modifyComBtn;
    @FXML private Button deleteComBtn;
    @FXML private Button confirmComBtn;
    @FXML private Button cancelComBtn;
    @FXML private HBox   addComHBox;

    private Stage stage;
    private AlertController alertController;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        alertController = new AlertController();
    }

    @FXML
    private void addBirthPromotion(){
        setAddBirthComponentsVisible(true);
        setOriBirthComponentsVisible(false);
    }

    @FXML
    private void confirmBirthAdd(){
        setAddBirthComponentsVisible(false);
        setOriBirthComponentsVisible(true);
    }

    @FXML
    private void cancelBirthAdd(){
        setAddBirthComponentsVisible(false);
        setOriBirthComponentsVisible(true);
    }

    @FXML
    private void modifyBirthPromotion(){

    }

    @FXML
    private void deleteBirthPromotion(){

    }

    private void setAddBirthComponentsVisible(Boolean isVisible){
        addBirthHBox.setVisible(isVisible);
        confirmBirthBtn.setVisible(isVisible);
        cancelBirthBtn.setVisible(isVisible);
    }
    private void setOriBirthComponentsVisible(Boolean isVisible){
        addBirthBtn.setVisible(isVisible);
        modifyBirthBtn.setVisible(isVisible);
        deleteBirthBtn.setVisible(isVisible);
    }

    @FXML
    private void addRoomsPromotion(){
        setAddRoomsComponentsVisible(true);
        setOriRoomsComponentsVisible(false);
    }

    @FXML
    private void confirmRoomsAdd(){
        setAddRoomsComponentsVisible(false);
        setOriRoomsComponentsVisible(true);
    }

    @FXML
    private void cancelRoomsAdd(){
        setAddRoomsComponentsVisible(false);
        setOriRoomsComponentsVisible(true);
    }

    @FXML
    private void modifyRoomsPromotion(){

    }

    @FXML
    private void deleteRoomsPromotion(){

    }

    private void setAddRoomsComponentsVisible(Boolean isVisible){
        addRoomsHBox.setVisible(isVisible);
        confirmRoomsBtn.setVisible(isVisible);
        cancelRoomsBtn.setVisible(isVisible);
    }
    private void setOriRoomsComponentsVisible(Boolean isVisible){
        addRoomsBtn.setVisible(isVisible);
        modifyRoomsBtn.setVisible(isVisible);
        deleteRoomsBtn.setVisible(isVisible);
    }

    @FXML
    private void addTimePromotion(){
        setAddTimeComponentsVisible(true);
        setOriTimeComponentsVisible(false);
    }

    @FXML
    private void confirmTimeAdd(){
        setAddTimeComponentsVisible(false);
        setOriTimeComponentsVisible(true);
    }

    @FXML
    private void cancelTimeAdd(){
        setAddTimeComponentsVisible(false);
        setOriTimeComponentsVisible(true);
    }

    @FXML
    private void modifyTimePromotion(){

    }

    @FXML
    private void deleteTimePromotion(){

    }

    private void setAddTimeComponentsVisible(Boolean isVisible){
        addTimeHBox.setVisible(isVisible);
        confirmTimeBtn.setVisible(isVisible);
        cancelTimeBtn.setVisible(isVisible);
    }
    private void setOriTimeComponentsVisible(Boolean isVisible){
        addTimeBtn.setVisible(isVisible);
        modifyTimeBtn.setVisible(isVisible);
        deleteTimeBtn.setVisible(isVisible);
    }

    @FXML
    private void addComPromotion(){
        setAddComComponentsVisible(true);
        setOriComComponentsVisible(false);
    }

    @FXML
    private void confirmComAdd(){
        setAddComComponentsVisible(false);
        setOriComComponentsVisible(true);
    }

    @FXML
    private void cancelComAdd(){
        setAddComComponentsVisible(false);
        setOriComComponentsVisible(true);
    }

    @FXML
    private void modifyComPromotion(){

    }

    @FXML
    private void deleteComPromotion(){

    }

    private void setAddComComponentsVisible(Boolean isVisible){
        addComHBox.setVisible(isVisible);
        confirmComBtn.setVisible(isVisible);
        cancelComBtn.setVisible(isVisible);
    }
    private void setOriComComponentsVisible(Boolean isVisible){
        addComBtn.setVisible(isVisible);
        modifyComBtn.setVisible(isVisible);
        deleteComBtn.setVisible(isVisible);
    }
}

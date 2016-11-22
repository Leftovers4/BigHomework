package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class ManagePromotionPaneController {

    //生日优惠
    @FXML Button addBirthBtn;
    @FXML Button modifyBirthBtn;
    @FXML Button deleteBirthBtn;
    @FXML Button confirmBirthBtn;
    @FXML Button cancelBirthBtn;
    @FXML HBox   addBirthHBox;
    //多间预订优惠
    @FXML Button addRoomsBtn;
    @FXML Button modifyRoomsBtn;
    @FXML Button deleteRoomsBtn;
    @FXML Button confirmRoomsBtn;
    @FXML Button cancelRoomsBtn;
    @FXML HBox   addRoomsHBox;
    //特定期间优惠
    @FXML Button addTimeBtn;
    @FXML Button modifyTimeBtn;
    @FXML Button deleteTimeBtn;
    @FXML Button confirmTimeBtn;
    @FXML Button cancelTimeBtn;
    @FXML HBox   addTimeHBox;
    //合作企业优惠
    @FXML Button addComBtn;
    @FXML Button modifyComBtn;
    @FXML Button deleteComBtn;
    @FXML Button confirmComBtn;
    @FXML Button cancelComBtn;
    @FXML HBox   addComHBox;

    private Stage stage;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML void back(){

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

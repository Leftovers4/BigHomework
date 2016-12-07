package presentation.hotelworkerui.hotelworkercontroller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presentation.util.alert.AlertController;
import presentation.util.other.MySlider;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class ManagePromotionPaneController {

    //生日优惠
    @FXML private Button birthBtn;
    @FXML private Button addBirthBtn;
    @FXML private Button modifyBirthBtn;
    @FXML private Button deleteBirthBtn;
    @FXML private Button confirmBirthBtn;
    @FXML private Button cancelBirthBtn;
    @FXML private VBox   birthVBox;
    @FXML private HBox   addBirthHBox;
    @FXML private TableView birthTable;
    @FXML private TableColumn birthRoomTypeCol;
    @FXML private TableColumn birthDiscountCol;
    @FXML private TableColumn birthPriceCol;

    //多间预订优惠
    @FXML private Button addRoomBtn;
    @FXML private Button modifyRoomBtn;
    @FXML private Button deleteRoomBtn;
    @FXML private Button confirmRoomBtn;
    @FXML private Button cancelRoomBtn;
    @FXML private VBox   roomVBox;
    @FXML private HBox   addRoomHBox;
    @FXML private TableView roomTable;
    @FXML private TableColumn roomTypeCol;
    @FXML private TableColumn roomLeastCol;
    @FXML private TableColumn roomDiscountCol;
    @FXML private TableColumn roomPriceCol;

    //特定期间优惠
    @FXML private Button addTimeBtn;
    @FXML private Button modifyTimeBtn;
    @FXML private Button deleteTimeBtn;
    @FXML private Button confirmTimeBtn;
    @FXML private Button cancelTimeBtn;
    @FXML private VBox   timeVBox;
    @FXML private HBox   addTimeHBox;
    @FXML private TableView timeTable;
    @FXML private TableColumn timeRoomTypeCol;
    @FXML private TableColumn timeStartCol;
    @FXML private TableColumn timeEndCol;
    @FXML private TableColumn timeDiscountCol;
    @FXML private TableColumn timePriceCol;

    //合作企业优惠
    @FXML private Button addComBtn;
    @FXML private Button modifyComBtn;
    @FXML private Button deleteComBtn;
    @FXML private Button confirmComBtn;
    @FXML private Button cancelComBtn;
    @FXML private VBox   comVBox;
    @FXML private HBox   addComHBox;
    @FXML private TableView comTable;
    @FXML private TableColumn comNameCol;
    @FXML private TableColumn comRoomTypeCol;
    @FXML private TableColumn comDiscountCol;
    @FXML private TableColumn comPriceCol;

    //滑块
    @FXML private Label sliderPromotionLabel;


    private AlertController alertController;
    private ArrayList<VBox> vBoxes;
    //TODO 如果已添加促销策略 则不再显示添加按钮
    private Boolean isExistBirth = false;
    private Boolean isExistRoom = false;
    private Boolean isExistTime = false;
    private Boolean isExistCom = false;

    public void launch() {
        alertController = new AlertController();
        vBoxes = new ArrayList<>(Arrays.asList(birthVBox,roomVBox,timeVBox,comVBox));

        //设置生日优惠按钮默认被选中
        makeBirthFocused();
    }

    private void makeBirthFocused() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                birthBtn.requestFocus();
            }
        });
    }

    @FXML
    private void addBirthPromotion(){
        setAddBirthComponentsVisible(true);
        setOriBirthComponentsVisible(false);
    }

    @FXML
    private void confirmBirthAdd(){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        isExistBirth = true;
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
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistBirth)addBirthBtn.setVisible(isVisible);
        else {
            modifyBirthBtn.setVisible(isVisible);
            deleteBirthBtn.setVisible(isVisible);
        }
    }

    @FXML
    private void addRoomPromotion(){
        setAddRoomsComponentsVisible(true);
        setOriRoomsComponentsVisible(false);
    }

    @FXML
    private void confirmRoomAdd(){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        isExistRoom = true;
        setAddRoomsComponentsVisible(false);
        setOriRoomsComponentsVisible(true);
    }

    @FXML
    private void cancelRoomAdd(){
        setAddRoomsComponentsVisible(false);
        setOriRoomsComponentsVisible(true);
    }

    @FXML
    private void modifyRoomPromotion(){

    }

    @FXML
    private void deleteRoomPromotion(){

    }

    private void setAddRoomsComponentsVisible(Boolean isVisible){
        addRoomHBox.setVisible(isVisible);
        confirmRoomBtn.setVisible(isVisible);
        cancelRoomBtn.setVisible(isVisible);
    }
    private void setOriRoomsComponentsVisible(Boolean isVisible){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistRoom)addRoomBtn.setVisible(isVisible);
        else {
            modifyRoomBtn.setVisible(isVisible);
            deleteRoomBtn.setVisible(isVisible);
        }
    }

    @FXML
    private void addTimePromotion(){
        setAddTimeComponentsVisible(true);
        setOriTimeComponentsVisible(false);
    }

    @FXML
    private void confirmTimeAdd(){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        isExistTime =true;
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
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistTime)addTimeBtn.setVisible(isVisible);
        else {
            modifyTimeBtn.setVisible(isVisible);
            deleteTimeBtn.setVisible(isVisible);
        }
    }

    @FXML
    private void addComPromotion(){
        setAddComComponentsVisible(true);
        setOriComComponentsVisible(false);
    }

    @FXML
    private void confirmComAdd(){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        isExistCom = true;
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
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistCom)addComBtn.setVisible(isVisible);
        else {
            modifyComBtn.setVisible(isVisible);
            deleteComBtn.setVisible(isVisible);
        }
    }



    @FXML
    private void showBirth(){
        showVBox(birthVBox);
        setAddBirthComponentsVisible(false);
        setOriBirthComponentsVisible(true);

        MySlider.moveSliderLabel(sliderPromotionLabel,36);
    }

    @FXML
    private void showRoom(){
        showVBox(roomVBox);
        setAddRoomsComponentsVisible(false);
        setOriRoomsComponentsVisible(true);

        MySlider.moveSliderLabel(sliderPromotionLabel,168);
    }

    @FXML
    private void showTime(){
        showVBox(timeVBox);
        setAddTimeComponentsVisible(false);
        setOriTimeComponentsVisible(true);

        MySlider.moveSliderLabel(sliderPromotionLabel,300);
    }

    @FXML
    private void showCom(){
        showVBox(comVBox);
        setAddComComponentsVisible(false);
        setOriComComponentsVisible(true);

        MySlider.moveSliderLabel(sliderPromotionLabel,432);
    }

    private void showVBox(VBox visibleBox){
        for (VBox vbox: vBoxes) {
            if(vbox == visibleBox) vbox.setVisible(true);
            else vbox.setVisible(false);
        }
    }

}

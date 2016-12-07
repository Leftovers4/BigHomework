package presentation.webmarketerui.webmarketercontroller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import presentation.util.other.DisableColumnChangeListener;
import presentation.util.other.MySlider;
import vo.promotion.PromotionVO;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class ManagePromotionPaneController {
    //特定期间优惠
    @FXML private Button timeBtn;
    @FXML private Button addTimeBtn;
    @FXML private Button confirmTimeBtn;
    @FXML private Button cancelTimeBtn;
    @FXML private Button modifyTimeBtn;
    @FXML private Button deleteTimeBtn;
    @FXML private VBox timeVBox;
    @FXML private HBox addTimeHBox;
    @FXML private TableView proTimeTable;
    @FXML private TableColumn proStartTimeCol;
    @FXML private TableColumn proEndTimeCol;
    @FXML private TableColumn proTimeDiscountCol;
    //会员优惠
    @FXML private Button addMemBtn;
    @FXML private Button confirmMemBtn;
    @FXML private Button cancelMemBtn;
    @FXML private Button modifyMemBtn;
    @FXML private Button deleteMemBtn;
    @FXML private Button manageMemRankBtn;
    @FXML private Button confirmManageBtn;
    @FXML private Button cancelManageBtn;

    @FXML private GridPane manageGridPane;

    @FXML private VBox memberVBox;
    @FXML private HBox addMemHBox;
    @FXML private TableView proMemTable;
    @FXML private TableColumn proAreaCol;
    @FXML private TableColumn proRankCol;
    @FXML private TableColumn proMemDiscountCol;

    //滑块
    @FXML private Label sliderPromotionLabel;

    private Stage stage;
    private AlertController alertController;
    //TODO 如果已添加促销策略 则不再显示添加按钮
    private Boolean isExistTime = false;
    private Boolean isExistMem = false;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        alertController = new AlertController();


        //设置特定期间优惠按钮默认被选中
        makeTimeFocused();
        initTable();
    }

    private void initTable() {
        proStartTimeCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proEndTimeCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proTimeDiscountCol.setCellValueFactory(new PropertyValueFactory<>(""));
        final TableColumn[] proTimeColumns = {proStartTimeCol, proEndTimeCol, proTimeDiscountCol};
        proTimeTable.getColumns().addListener(new DisableColumnChangeListener(proTimeTable, proTimeColumns));
        proTimeTable.setItems(getTimeProVoList());

        proAreaCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proRankCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proMemDiscountCol.setCellValueFactory(new PropertyValueFactory<>(""));
        final TableColumn[] proMemColumns = {proAreaCol, proRankCol, proMemDiscountCol};
        proMemTable.getColumns().addListener(new DisableColumnChangeListener(proMemTable, proMemColumns));
        proMemTable.setItems(getMemProVoList());
    }

    private ObservableList<PromotionVO> getTimeProVoList() {
        return null;
    }

    private ObservableList<PromotionVO> getMemProVoList() {
        return null;
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
    private void addMemPromotion() {
        setAddMemComponentsVisible(true);
        setOriMemComponentsVisible(false);
    }

    @FXML
    private void modifyMemPromotion() {
    }

    @FXML
    private void deleteMemPromotion() {
    }

    @FXML
    private void confirmMemAdd() {
        //TODO 如果已添加促销策略 则不再显示添加按钮
        isExistMem =true;
        setAddMemComponentsVisible(false);
        setOriMemComponentsVisible(true);
    }

    @FXML
    private void cancelMemAdd() {
        setAddMemComponentsVisible(false);
        setOriMemComponentsVisible(true);
    }

    private void setAddMemComponentsVisible(Boolean isVisible){
        addMemHBox.setVisible(isVisible);
        confirmMemBtn.setVisible(isVisible);
        cancelMemBtn.setVisible(isVisible);
    }
    private void setOriMemComponentsVisible(Boolean isVisible){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistMem)addMemBtn.setVisible(isVisible);
        else {
            modifyMemBtn.setVisible(isVisible);
            deleteMemBtn.setVisible(isVisible);
        }
        manageMemRankBtn.setVisible(isVisible);
    }


    /**
     * 制定会员等级
     */
    @FXML
    private void manageRank(){
        setManageComponentsVisible(true);
        setOriMemComponentsVisible(false);
    }

    @FXML
    private void cancelManage(){
        setManageComponentsVisible(false);
        setOriMemComponentsVisible(true);
    }

    @FXML
    private void confirmManage(){
        setManageComponentsVisible(false);
        setOriMemComponentsVisible(true);
    }

    private void setManageComponentsVisible(Boolean isVisible){
        manageMemRankBtn.setVisible(!isVisible);
        confirmManageBtn.setVisible(isVisible);
        cancelManageBtn.setVisible(isVisible);
        manageGridPane.setVisible(isVisible);
    }

    @FXML
    private void showTimePromotion(){
        timeVBox.setVisible(true);
        memberVBox.setVisible(false);
        setAddTimeComponentsVisible(false);
        setOriTimeComponentsVisible(true);

        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,36);
    }

    @FXML
    private void showMemberPromotion(){
        memberVBox.setVisible(true);
        timeVBox.setVisible(false);
        setAddMemComponentsVisible(false);
        setOriMemComponentsVisible(true);
        setManageComponentsVisible(false);

        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,168);
    }

}

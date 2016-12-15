package presentation.webmarketerui.webmarketercontroller;

import bl.promotionbl.PromotionBLService;
import bl.promotionbl.impl.PromotionBlServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.util.other.*;
import util.AddTradProducer;
import util.IDProducer;
import util.PromotionType;
import util.TradingArea;
import vo.promotion.PromotionMRVO;
import vo.promotion.PromotionVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class ManagePromotionPaneController {
    //特定期间优惠
    @FXML private VBox timeVBox;
    @FXML private Button timeBtn;
    @FXML private Button addTimeBtn;
    @FXML private Button confirmTimeBtn;
    @FXML private Button cancelTimeBtn;
    @FXML private HBox addTimeHBox;
    @FXML private TableView proTimeTable;
    @FXML private TableColumn proStartTimeCol;
    @FXML private TableColumn proEndTimeCol;
    @FXML private TableColumn proTimeDiscountCol;
    @FXML private TableColumn proTimeOpCol;
    @FXML private DatePicker startTimeDatePicker;
    @FXML private DatePicker endTimeDatePicker;
    @FXML private ComboBox startHourBox;
    @FXML private ComboBox startMinBox;
    @FXML private ComboBox endHourBox;
    @FXML private ComboBox endMinBox;
    @FXML private TextField timeDiscountField;
    //VIP商圈优惠
    @FXML private VBox memberAreaVBox;
    @FXML private Button addMemBtn;
    @FXML private Button confirmMemBtn;
    @FXML private Button cancelMemBtn;
    @FXML private HBox addMemHBox;
    @FXML private TableView proMemTable;
    @FXML private TableColumn proAreaCol;
    @FXML private TableColumn proAreaDiscountCol;
    @FXML private TableColumn proAreaOpCol;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox areaBox;
    @FXML private TextField areaDiscountField;

    //会员优惠
    @FXML private Pane memberManagePane;
    @FXML private Button manageMemRankBtn;
    @FXML private Button confirmManageBtn;
    @FXML private Button cancelManageBtn;
    @FXML private GridPane editGridPane;
    @FXML private TextField lv1CreditField;
    @FXML private TextField lv2CreditField;
    @FXML private TextField lv3CreditField;
    @FXML private TextField lv4CreditField;
    @FXML private TextField lv5CreditField;
    @FXML private TextField lv6CreditField;
    @FXML private TextField lv1DiscountField;
    @FXML private TextField lv2DiscountField;
    @FXML private TextField lv3DiscountField;
    @FXML private TextField lv4DiscountField;
    @FXML private TextField lv5DiscountField;
    @FXML private TextField lv6DiscountField;
    @FXML private GridPane showGridPane;
    @FXML private Label lv1CreditLabel;
    @FXML private Label lv2CreditLabel;
    @FXML private Label lv3CreditLabel;
    @FXML private Label lv4CreditLabel;
    @FXML private Label lv5CreditLabel;
    @FXML private Label lv6CreditLabel;
    @FXML private Label lv1DiscountLabel;
    @FXML private Label lv2DiscountLabel;
    @FXML private Label lv3DiscountLabel;
    @FXML private Label lv4DiscountLabel;
    @FXML private Label lv5DiscountLabel;
    @FXML private Label lv6DiscountLabel;
    //滑块
    @FXML private Label sliderPromotionLabel;

    private AlertController alertController;
    private PromotionBLService promotionBLService;
    //是添加还是修改
    private Boolean isTimeAdd = false;
    private Boolean isAreaAdd = false;
    private ProListButtonCell proTimeListButtonCell;
    private ProListButtonCell proAreaListButtonCell;

    public void launch() {
        alertController = new AlertController();

        initService();
        showTimePromotion();
        //设置特定期间优惠按钮默认被选中
        makeTimeFocused();
    }

    private void initService() {
        try {
            promotionBLService = new PromotionBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showTimePromotion(){
        timeVBox.setVisible(true);
        memberAreaVBox.setVisible(false);
        memberManagePane.setVisible(false);


        initTimeTable();
        setTimeComponentsVisible(false);
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,36);
    }

    private void initTimeTable() {
        proStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("beginTime"));
        proEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        proTimeDiscountCol.setCellValueFactory(new PropertyValueFactory<>("discount"));
        proTimeOpCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                proTimeListButtonCell = new ProListButtonCell(proTimeTable, PromotionType.SpecialTimePromotion);
                return proTimeListButtonCell;
            }
        });
        final TableColumn[] proTimeColumns = {proStartTimeCol, proEndTimeCol, proTimeDiscountCol, proTimeOpCol};
        proTimeTable.getColumns().addListener(new DisableColumnChangeListener(proTimeTable, proTimeColumns));

        initData(proTimeTable, PromotionType.SpecialTimePromotion);
    }

    private void initTimeBOX() {
        MyComboBox.initHourBox(startHourBox);
        MyComboBox.initMinBox(startMinBox);
        MyComboBox.initHourBox(endHourBox);
        MyComboBox.initMinBox(endMinBox);
    }

    private void iniDatePicker(){
        startTimeDatePicker.setValue(LocalDate.now());
        startTimeDatePicker.setDayCellFactory(new CancelDateBefore(startTimeDatePicker, LocalDate.now()));
        startTimeDatePicker.setOnAction(event -> {
            endTimeDatePicker.setDayCellFactory(new CancelDateBefore(endTimeDatePicker,startTimeDatePicker.getValue()));
        });
        endTimeDatePicker.setValue(LocalDate.now());
        endTimeDatePicker.setDayCellFactory(new CancelDateBefore(endTimeDatePicker, LocalDate.now()));
    }

    @FXML
    private void showMemberAreaPromotion(){
        memberAreaVBox.setVisible(true);
        timeVBox.setVisible(false);
        memberManagePane.setVisible(false);

        initAreaTable();
        setMemComponentsVisible(false);
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,168);
    }

    private void initAreaTable() {
        proAreaCol.setCellValueFactory(new PropertyValueFactory<>("tradingArea"));
        proAreaDiscountCol.setCellValueFactory(new PropertyValueFactory<>("traDiscount"));
        proAreaOpCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                proAreaListButtonCell = new ProListButtonCell(proMemTable, PromotionType.VIPSpecialAreaPromotion);
                return proAreaListButtonCell;
            }
        });
        final TableColumn[] proMemColumns = {proAreaCol, proAreaDiscountCol, proAreaOpCol};
        proMemTable.getColumns().addListener(new DisableColumnChangeListener(proMemTable, proMemColumns));

        initData(proMemTable, PromotionType.VIPSpecialAreaPromotion);
    }


    private void initData(TableView tableView, PromotionType promotionType) {
        try {
            tableView.setItems(FXCollections.observableArrayList(promotionBLService.viewPromotionList(IDProducer.produceHotelIDForWP(), promotionType)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showMemberPromotion(){
        memberManagePane.setVisible(true);
        memberAreaVBox.setVisible(false);
        timeVBox.setVisible(false);

        setManageComponentsVisible(false);

        initLabel();
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,300);
    }

    private void initLabel() {

        List<PromotionVO> list = null;
        try {
            list = promotionBLService.viewPromotionList(IDProducer.produceHotelIDForWP(),PromotionType.UserLevelPromotion);
            if(list.isEmpty()){
                showGridPane.setVisible(false);
                editGridPane.setVisible(false);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(!list.isEmpty()){
            PromotionVO promotionVO = list.get(0);
            lv1CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(0).credit));
            lv2CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(1).credit));
            lv3CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(2).credit));
            lv4CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(3).credit));
            lv5CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(4).credit));
            lv6CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(5).credit));
            lv1DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(0).memberDiscount));
            lv2DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(1).memberDiscount));
            lv3DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(2).memberDiscount));
            lv4DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(3).memberDiscount));
            lv5DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(4).memberDiscount));
            lv6DiscountLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(5).memberDiscount));
        }

    }




    /**
     * 制定特定期间优惠
     */
    @FXML
    private void addTimePromotion(){
        isTimeAdd = true;
        setTimeComponentsVisible(true);
        initTimeBOX();
        iniDatePicker();
    }

    @FXML
    private void confirmTimeAdd(){
        if(!JudgeInput.judgeDiscount(timeDiscountField)) return;
        PromotionVO promotionVO = new PromotionVO();
        try {
            LocalDate startTimeDate = startTimeDatePicker.getValue();
            LocalDate endTimeDate = endTimeDatePicker.getValue();
            int startHour = (int) (startHourBox.getValue());
            int startMin = (int) (startMinBox.getValue());
            int endHour = (int) (endHourBox.getValue());
            int endMin = (int) (endMinBox.getValue());
            double timeDiscount = Double.parseDouble(timeDiscountField.getText());
            promotionVO.promotionTimeVO.beginTime = LocalDateTime.of(startTimeDate, LocalTime.of(startHour, startMin));
            promotionVO.promotionTimeVO.endTime = LocalDateTime.of(endTimeDate, LocalTime.of(endHour, endMin));
            promotionVO.discount = timeDiscount;
            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            if(isTimeAdd){
                promotionVO.promotionType = PromotionType.SpecialTimePromotion;
                promotionBLService.create(promotionVO);
            }else{
                proTimeTable.setDisable(false);
                promotionVO.promotionID = ((PromotionVO) proTimeTable.getItems().get(proTimeListButtonCell.getSelectedIndex())).promotionID;
                promotionBLService.update(promotionVO);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initData(proTimeTable, PromotionType.SpecialTimePromotion);
        setTimeComponentsVisible(false);
    }

    @FXML
    private void cancelTimeAdd(){
        proTimeTable.setDisable(false);
        setTimeComponentsVisible(false);
    }

    private void setTimeComponentsVisible(Boolean isVisible){
        addTimeHBox.setVisible(isVisible);
        confirmTimeBtn.setVisible(isVisible);
        cancelTimeBtn.setVisible(isVisible);

        addTimeBtn.setVisible(!isVisible);
    }


    /**
     * 制定VIP商圈优惠
     */
    @FXML
    private void addMemPromotion() {
        isAreaAdd = true;
        setMemComponentsVisible(true);
        MyComboBox.initAreaBox(cityBox,areaBox);
    }


    @FXML
    private void confirmMemAdd() {
        if(!JudgeInput.judgeDiscount(areaDiscountField)) return;
        PromotionVO promotionVO = new PromotionVO();
        try {
            promotionVO.promotionTraAreaVOs.get(0).tradingArea = String.valueOf(areaBox.getValue());
            promotionVO.promotionTraAreaVOs.get(0).traDiscount = Double.parseDouble(areaDiscountField.getText());
            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            if(isAreaAdd){
                promotionVO.promotionType = PromotionType.VIPSpecialAreaPromotion;
                promotionBLService.create(promotionVO);
            }else{
                proMemTable.setDisable(false);
                promotionVO.promotionID = ((PromotionVO) proMemTable.getItems().get(proAreaListButtonCell.getSelectedIndex())).promotionID;
                promotionBLService.update(promotionVO);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initData(proMemTable, PromotionType.VIPSpecialAreaPromotion);
        setMemComponentsVisible(false);
    }

    @FXML
    private void cancelMemAdd() {
        proMemTable.setDisable(false);
        setMemComponentsVisible(false);
    }

    private void setMemComponentsVisible(Boolean isVisible){
        addMemHBox.setVisible(isVisible);
        confirmMemBtn.setVisible(isVisible);
        cancelMemBtn.setVisible(isVisible);

        addMemBtn.setVisible(!isVisible);
    }


    /**
     * 制定会员等级
     */
    @FXML
    private void manageRank(){
        setManageComponentsVisible(true);
    }

    @FXML
    private void cancelManage(){
        setManageComponentsVisible(false);
    }

    @FXML
    private void confirmManage(){
        if(judgeInput()){
            PromotionVO promotionVO = new PromotionVO();

            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            promotionVO.promotionType = PromotionType.UserLevelPromotion;
            promotionVO.promotionMRVOs.get(0).credit = Double.parseDouble(lv1CreditField.getText());
            promotionVO.promotionMRVOs.get(1).credit = Double.parseDouble(lv2CreditField.getText());
            promotionVO.promotionMRVOs.get(2).credit = Double.parseDouble(lv4CreditField.getText());
            promotionVO.promotionMRVOs.get(3).credit = Double.parseDouble(lv3CreditField.getText());
            promotionVO.promotionMRVOs.get(4).credit = Double.parseDouble(lv5CreditField.getText());
            promotionVO.promotionMRVOs.get(5).credit = Double.parseDouble(lv6CreditField.getText());
            promotionVO.promotionMRVOs.get(0).memberDiscount = Double.parseDouble(lv1DiscountField.getText());
            promotionVO.promotionMRVOs.get(1).memberDiscount = Double.parseDouble(lv2DiscountField.getText());
            promotionVO.promotionMRVOs.get(2).memberDiscount = Double.parseDouble(lv3DiscountField.getText());
            promotionVO.promotionMRVOs.get(3).memberDiscount = Double.parseDouble(lv4DiscountField.getText());
            promotionVO.promotionMRVOs.get(4).memberDiscount = Double.parseDouble(lv5DiscountField.getText());
            promotionVO.promotionMRVOs.get(5).memberDiscount = Double.parseDouble(lv6DiscountField.getText());

            try {
                promotionBLService.create(promotionVO);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            initLabel();
            setManageComponentsVisible(false);
        }
    }

    private boolean judgeInput() {
            //用正则表达式判断输入格式，非数字报错
            Pattern pattern = Pattern.compile("^[0-9].*$");
            Matcher matcherCredit1 = pattern.matcher(lv1CreditField.getText());
            Matcher matcherCredit2 = pattern.matcher(lv2CreditField.getText());
            Matcher matcherCredit3 = pattern.matcher(lv4CreditField.getText());
            Matcher matcherCredit4 = pattern.matcher(lv3CreditField.getText());
            Matcher matcherCredit5 = pattern.matcher(lv5CreditField.getText());
            Matcher matcherCredit6 = pattern.matcher(lv6CreditField.getText());
            Matcher matcherDiscount1 = pattern.matcher(lv1DiscountField.getText());
            Matcher matcherDiscount2 = pattern.matcher(lv2DiscountField.getText());
            Matcher matcherDiscount3 = pattern.matcher(lv3DiscountField.getText());
            Matcher matcherDiscount4 = pattern.matcher(lv4DiscountField.getText());
            Matcher matcherDiscount5 = pattern.matcher(lv5DiscountField.getText());
            Matcher matcherDiscount6 = pattern.matcher(lv6DiscountField.getText());
            if(!matcherCredit1.matches() || !matcherCredit2.matches() ||
               !matcherCredit3.matches() || !matcherCredit4.matches() ||
               !matcherCredit5.matches() || !matcherCredit6.matches() ||
               !matcherDiscount1.matches() || !matcherDiscount2.matches() ||
               !matcherDiscount3.matches() || !matcherDiscount4.matches() ||
               !matcherDiscount5.matches() || !matcherDiscount6.matches())
            {
                alertController.showInputWrongAlert("信用值和折扣必须为数字，请重新输入","制定失败");
                return false;
            }else if((Integer.parseInt(lv1DiscountField.getText()) > 1) ||
                   (Integer.parseInt(lv2DiscountField.getText())> 1) ||
                   (Integer.parseInt(lv3DiscountField.getText()) > 1) ||
                   (Integer.parseInt(lv4DiscountField.getText()) > 1 ||
                   (Integer.parseInt(lv5DiscountField.getText()) > 1) ||
                   (Integer.parseInt(lv6DiscountField.getText()) > 1)))
                {
                    alertController.showInputWrongAlert("折扣必须小于1，请重新输入","制定失败");
                    return false;
                }
        return true;
    }

    private void setManageComponentsVisible(Boolean isVisible){
        manageMemRankBtn.setVisible(!isVisible);
        confirmManageBtn.setVisible(isVisible);
        cancelManageBtn.setVisible(isVisible);

        editGridPane.setVisible(isVisible);
        showGridPane.setVisible(!isVisible);
    }


    /**
     * 让特定期间按钮被选中
     */
    private void makeTimeFocused() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timeBtn.requestFocus();
            }
        });
    }

    /**
     * 操作栏按钮
     */
    private class ProListButtonCell extends TableCell<PromotionVO, Boolean> {
        final private HBox btnBox = new HBox();
        final private Button modifyButton = new Button();
        final private Button deleteButton = new Button();
        private TableView table;
        private PromotionType proType;
        private int selectedIndex;

        public ProListButtonCell(TableView tableView, PromotionType promotionType) {
            this.table = tableView;
            this.proType = promotionType;
            Image modifyImage = new Image("/img/hotelworker/modifyroom.png");
            modifyButton.setGraphic(new ImageView(modifyImage));
            modifyButton.getStyleClass().add("TableButtonCell");

            Image deleteImage = new Image("/img/hotelworker/deleteroom.png");
            deleteButton.setGraphic(new ImageView(deleteImage));
            deleteButton.getStyleClass().add("TableButtonCell");

            modifyButton.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                if(proType == PromotionType.SpecialTimePromotion){
                    //特定期间
                    isTimeAdd = false;
                    proTimeTable.setDisable(true);
                    setTimeComponentsVisible(true);
                    initTimeBOX();
                    iniDatePicker();
                }else if(proType == PromotionType.VIPSpecialAreaPromotion){
                    //商圈优惠
                    isAreaAdd = false;
                    proMemTable.setDisable(true);
                    setMemComponentsVisible(true);
                    MyComboBox.initAreaBox(cityBox,areaBox);
                }
            });

            deleteButton.setOnAction(event -> {
                if (alertController.showConfirmDeleteAlert("您确定要删除此优惠吗？", "确认删除")) {
                    selectedIndex = getTableRow().getIndex();
                    long promotionID = ((PromotionVO) table.getItems().get(selectedIndex)).promotionID;
                    try {
                        promotionBLService.delete(promotionID);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    initData(table, proType);
                }
            });

            btnBox.setSpacing(10);
            btnBox.setAlignment(Pos.CENTER);
            btnBox.setPadding(new Insets(0, 10, 0, 20));
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                btnBox.getChildren().clear();
                btnBox.getChildren().addAll(modifyButton, deleteButton);
                setGraphic(btnBox);
                setText(null);
            }
        }

        public int getSelectedIndex() {
            return selectedIndex;
        }
    }
}

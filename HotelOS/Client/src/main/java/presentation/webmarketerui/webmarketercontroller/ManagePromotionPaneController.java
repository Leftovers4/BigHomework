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
 * Description : 网站营销人员制定促销策略界面控制器
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
    @FXML private Label alertLabel;

    private AlertController alertController;
    private PromotionBLService promotionBLService;
    //是添加还是修改
    private Boolean isTimeAdd = false;
    private Boolean isAreaAdd = false;
    private Boolean isExistMemberPro = false;
    private long promotionID = 0;
    private ProListButtonCell proTimeListButtonCell;
    private ProListButtonCell proAreaListButtonCell;
    private int modifyChooseIndex;

    public void launch() {
        alertController = new AlertController();
        modifyChooseIndex = 0;
        initService();
        showTimePromotion();
        //设置特定期间优惠按钮默认被选中
        makeTimeFocused();
    }

    private void initService() {
        try {
            promotionBLService = new PromotionBlServiceImpl();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    /**
     * 显示特定期间优惠界面
     */
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

    /**
     * 初始化特定期间列表
     */
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

    /**
     * 显示特定商圈优惠界面
     */
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

    /**
     * 初始化商圈列表
     */
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
            alertController.showNetConnectAlert();
        }
    }

    /**
     * 显示制定会员等级界面
     */
    @FXML
    private void showMemberPromotion(){
        memberManagePane.setVisible(true);
        memberAreaVBox.setVisible(false);
        timeVBox.setVisible(false);



        initLabel();

        setManageComponentsVisible(false);
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
            alertController.showNetConnectAlert();
        }
        if(!list.isEmpty()){
            isExistMemberPro = true;
            alertLabel.setVisible(false);

            PromotionVO promotionVO = list.get(0);
            promotionID = promotionVO.promotionID;
            lv1CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(0).credit));
            lv2CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(1).credit));
            lv3CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(2).credit));
            lv4CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(3).credit));
            lv5CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(4).credit));
            lv6CreditLabel.setText(String.valueOf(promotionVO.promotionMRVOs.get(5).credit));
            lv1DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(0).memberDiscount*100)));
            lv2DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(1).memberDiscount*100)));
            lv3DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(2).memberDiscount*100)));
            lv4DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(3).memberDiscount*100)));
            lv5DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(4).memberDiscount*100)));
            lv6DiscountLabel.setText(String.valueOf(Math.round(promotionVO.promotionMRVOs.get(5).memberDiscount*100)));
        }else {
            isExistMemberPro = false;
            alertLabel.setVisible(true);
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
        LocalDate startTimeDate = startTimeDatePicker.getValue();
        LocalDate endTimeDate = endTimeDatePicker.getValue();
        int startHour = (int) (startHourBox.getValue());
        int startMin = (int) (startMinBox.getValue());
        int endHour = (int) (endHourBox.getValue());
        int endMin = (int) (endMinBox.getValue());
        LocalDateTime startTime = LocalDateTime.of(startTimeDate, LocalTime.of(startHour, startMin));
        LocalDateTime endTime = LocalDateTime.of(endTimeDate, LocalTime.of(endHour, endMin));
        if(!JudgeInput.judgeDiscount(timeDiscountField) || !JudgeInput.judgeDateSeq(startTime,endTime)) return;
        PromotionVO promotionVO = new PromotionVO();
        try {

            double timeDiscount = Double.parseDouble(timeDiscountField.getText());
            promotionVO.promotionTimeVO.beginTime = startTime;
            promotionVO.promotionTimeVO.endTime = endTime;
            promotionVO.discount = timeDiscount/100.0;
            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            if(isTimeAdd){
                promotionVO.promotionType = PromotionType.SpecialTimePromotion;
                promotionBLService.create(promotionVO);
            }else{
                proTimeTable.setDisable(false);
                promotionVO.promotionID = ((PromotionVO) proTimeTable.getItems().get(modifyChooseIndex)).promotionID;
                promotionBLService.update(promotionVO);
            }


            initData(proTimeTable, PromotionType.SpecialTimePromotion);
            setTimeComponentsVisible(false);
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }


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
        if(areaBox.getValue() == null) {
            alertController.showInputWrongAlert("请选择商圈", "添加失败");
            return;
        }
        PromotionVO promotionVO = new PromotionVO();
        try {
            promotionVO.promotionTraAreaVOs.get(0).tradingArea = String.valueOf(areaBox.getValue());
            promotionVO.promotionTraAreaVOs.get(0).traDiscount = Double.parseDouble(areaDiscountField.getText())/100.0;
            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            if(isAreaAdd){
                promotionVO.promotionType = PromotionType.VIPSpecialAreaPromotion;
                promotionBLService.create(promotionVO);
            }else{
                proMemTable.setDisable(false);
                promotionVO.promotionID = ((PromotionVO) proMemTable.getItems().get(modifyChooseIndex)).promotionID;
                promotionBLService.update(promotionVO);
            }


            initData(proMemTable, PromotionType.VIPSpecialAreaPromotion);
            setMemComponentsVisible(false);
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }


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
        alertLabel.setVisible(false);
        setManageComponentsVisible(true);
        if(isExistMemberPro){
            lv1CreditField.setText(lv1CreditLabel.getText());
            lv2CreditField.setText(lv2CreditLabel.getText());
            lv4CreditField.setText(lv3CreditLabel.getText());
            lv3CreditField.setText(lv4CreditLabel.getText());
            lv5CreditField.setText(lv5CreditLabel.getText());
            lv6CreditField.setText(lv6CreditLabel.getText());
            lv1DiscountField.setText(lv1DiscountLabel.getText());
            lv2DiscountField.setText(lv2DiscountLabel.getText());
            lv3DiscountField.setText(lv3DiscountLabel.getText());
            lv4DiscountField.setText(lv4DiscountLabel.getText());
            lv5DiscountField.setText(lv5DiscountLabel.getText());
            lv6DiscountField.setText(lv6DiscountLabel.getText());
        }
    }

    @FXML
    private void cancelManage(){
        setManageComponentsVisible(false);
        alertLabel.setVisible(!isExistMemberPro);
    }

    @FXML
    private void confirmManage(){
        if(judgeInput()){
            PromotionVO promotionVO = new PromotionVO();

            promotionVO.hotelID = IDProducer.produceHotelIDForWP();
            promotionVO.promotionType = PromotionType.UserLevelPromotion;
            promotionVO.promotionMRVOs.get(0).credit = Double.parseDouble(lv1CreditField.getText());
            promotionVO.promotionMRVOs.get(1).credit = Double.parseDouble(lv2CreditField.getText());
            promotionVO.promotionMRVOs.get(2).credit = Double.parseDouble(lv3CreditField.getText());
            promotionVO.promotionMRVOs.get(3).credit = Double.parseDouble(lv4CreditField.getText());
            promotionVO.promotionMRVOs.get(4).credit = Double.parseDouble(lv5CreditField.getText());
            promotionVO.promotionMRVOs.get(5).credit = Double.parseDouble(lv6CreditField.getText());
            promotionVO.promotionMRVOs.get(0).memberDiscount = Double.parseDouble(lv1DiscountField.getText())/100.0;
            promotionVO.promotionMRVOs.get(1).memberDiscount = Double.parseDouble(lv2DiscountField.getText())/100.0;
            promotionVO.promotionMRVOs.get(2).memberDiscount = Double.parseDouble(lv3DiscountField.getText())/100.0;
            promotionVO.promotionMRVOs.get(3).memberDiscount = Double.parseDouble(lv4DiscountField.getText())/100.0;
            promotionVO.promotionMRVOs.get(4).memberDiscount = Double.parseDouble(lv5DiscountField.getText())/100.0;
            promotionVO.promotionMRVOs.get(5).memberDiscount = Double.parseDouble(lv6DiscountField.getText())/100.0;

            try {
                if(isExistMemberPro){
                    //更新
                    promotionVO.promotionID = promotionID;
                    promotionBLService.update(promotionVO);
                }else {
                    //生成
                    promotionBLService.create(promotionVO);
                }


                initLabel();
                setManageComponentsVisible(false);
            } catch (RemoteException e) {
                alertController.showNetConnectAlert();
            }


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
            }else if((Double.parseDouble(lv1DiscountField.getText()) >= 100) ||
                   (Double.parseDouble(lv2DiscountField.getText()) >= 100) ||
                   (Double.parseDouble(lv3DiscountField.getText()) >= 100) ||
                   (Double.parseDouble(lv4DiscountField.getText()) >= 100 ||
                   (Double.parseDouble(lv5DiscountField.getText()) >= 100) ||
                   (Double.parseDouble(lv6DiscountField.getText()) >= 100)))
                {
                    alertController.showInputWrongAlert("折扣必须小于100，请重新输入","制定失败");
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

        if(!isExistMemberPro) showGridPane.setVisible(false);
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
            modifyButton.getStyleClass().add("TableEditButtonCell");

            Image deleteImage = new Image("/img/hotelworker/deleteroom.png");
            deleteButton.setGraphic(new ImageView(deleteImage));
            deleteButton.getStyleClass().add("TableDeleteButtonCell");

            modifyButton.setTooltip(ToolTipShow.setTool("修改"));
            modifyButton.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
                modifyChooseIndex = selectedIndex;
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
//                    MyComboBox.initAreaBox(cityBox,areaBox);
                }
            });

            deleteButton.setTooltip(ToolTipShow.setTool("删除"));
            deleteButton.setOnAction(event -> {
                if (alertController.showConfirmDeleteAlert("您确定要删除此优惠吗？", "确认删除")) {
                    selectedIndex = getTableRow().getIndex();
                    long promotionID = ((PromotionVO) table.getItems().get(selectedIndex)).promotionID;
                    try {
                        promotionBLService.delete(promotionID);

                        initData(table, proType);
                    } catch (RemoteException e) {
                        alertController.showNetConnectAlert();
                    }


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

    }
}

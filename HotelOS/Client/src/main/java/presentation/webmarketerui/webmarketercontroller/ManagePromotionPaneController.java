package presentation.webmarketerui.webmarketercontroller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import presentation.util.other.DisableColumnChangeListener;
import presentation.util.other.MySlider;
import vo.promotion.PromotionTimeVO;
import vo.promotion.PromotionVO;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
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
    @FXML private Button modifyMemBtn;
    @FXML private Button deleteMemBtn;
    @FXML private HBox addMemHBox;
    @FXML private TableView proMemTable;
    @FXML private TableColumn proAreaCol;
    @FXML private TableColumn proAreaDiscountCol;
    @FXML private TableColumn proAreaOpCol;

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
    //TODO 如果已添加促销策略 则不再显示添加按钮
    private Boolean isExistTime = false;
    private Boolean isExistMem = false;
    private ProListButtonCell proTimeListButtonCell;
    private ProListButtonCell proAreaListButtonCell;

    public void launch() {
        alertController = new AlertController();

        //设置特定期间优惠按钮默认被选中
        makeTimeFocused();
    }

    @FXML
    private void showTimePromotion(){
        timeVBox.setVisible(true);
        memberAreaVBox.setVisible(false);
        memberManagePane.setVisible(false);

        setAddTimeComponentsVisible(false);
        setOriTimeComponentsVisible(true);

        initTimeTable();
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
                proTimeListButtonCell = new ProListButtonCell();
                return proTimeListButtonCell;
            }
        });
        final TableColumn[] proTimeColumns = {proStartTimeCol, proEndTimeCol, proTimeDiscountCol, proTimeOpCol};
        proTimeTable.getColumns().addListener(new DisableColumnChangeListener(proTimeTable, proTimeColumns));
        proTimeTable.setItems(getTimeProVoList());

    }

    private ObservableList<PromotionVO> getTimeProVoList() {
        ObservableList<PromotionVO> list = FXCollections.observableArrayList();
        PromotionTimeVO promotionTimeVO = new PromotionTimeVO();
        promotionTimeVO.beginTime = LocalDateTime.now();
        promotionTimeVO.endTime = LocalDateTime.now();
        PromotionVO promotionVO = new PromotionVO();
        promotionVO.promotionTimeVO = promotionTimeVO;
        promotionVO.discount = 0.9;
        list.add(promotionVO);
        return list;
    }

    @FXML
    private void showMemberAreaPromotion(){
        memberAreaVBox.setVisible(true);
        timeVBox.setVisible(false);
        memberManagePane.setVisible(false);

        setAddMemComponentsVisible(false);
        setOriMemComponentsVisible(true);

        initAreaTable();
        //移动滑块
        MySlider.moveSliderLabel(sliderPromotionLabel,168);
    }

    private void initAreaTable() {
        proAreaCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proAreaDiscountCol.setCellValueFactory(new PropertyValueFactory<>(""));
        proAreaOpCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                proAreaListButtonCell = new ProListButtonCell();
                return proAreaListButtonCell;
            }
        });
        final TableColumn[] proMemColumns = {proAreaCol, proAreaDiscountCol, proAreaOpCol};
        proMemTable.getColumns().addListener(new DisableColumnChangeListener(proMemTable, proMemColumns));
        proMemTable.setItems(getMemProVoList());
    }

    private ObservableList<PromotionVO> getMemProVoList() {
        return null;
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
//        lv1CreditLabel.setText();
//        lv2CreditLabel.setText();
//        lv3CreditLabel.setText();
//        lv4CreditLabel.setText();
//        lv5CreditLabel.setText();
//        lv6CreditLabel.setText();
//        lv1DiscountLabel.setText();
//        lv2DiscountLabel.setText();
//        lv3DiscountLabel.setText();
//        lv4DiscountLabel.setText();
//        lv5DiscountLabel.setText();
//        lv6DiscountLabel.setText();
    }




    /**
     * 制定特定期间优惠
     */
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

    private void setAddTimeComponentsVisible(Boolean isVisible){
        addTimeHBox.setVisible(isVisible);
        confirmTimeBtn.setVisible(isVisible);
        cancelTimeBtn.setVisible(isVisible);
    }
    private void setOriTimeComponentsVisible(Boolean isVisible){
        //TODO 如果已添加促销策略 则不再显示添加按钮
        if (!isExistTime)addTimeBtn.setVisible(isVisible);
    }


    /**
     * 制定VIP商圈优惠
     */
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

    private void setOriMemComponentsVisible(Boolean isVisible) {

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
        if(judgeInput()){}
        double lv1Credit = Double.parseDouble(lv1CreditField.getText());
        double lv2Credit = Double.parseDouble(lv2CreditField.getText());
        double lv4Credit = Double.parseDouble(lv4CreditField.getText());
        double lv3Credit = Double.parseDouble(lv3CreditField.getText());
        double lv5Credit = Double.parseDouble(lv5CreditField.getText());
        double lv6Credit = Double.parseDouble(lv6CreditField.getText());
        double lv1Discount = Double.parseDouble(lv1DiscountField.getText());
        double lv2Discount = Double.parseDouble(lv2DiscountField.getText());
        double lv3Discount = Double.parseDouble(lv3DiscountField.getText());
        double lv4Discount = Double.parseDouble(lv4DiscountField.getText());
        double lv5Discount = Double.parseDouble(lv5DiscountField.getText());
        double lv6Discount = Double.parseDouble(lv6DiscountField.getText());
        //TODO
        initLabel();
        setManageComponentsVisible(false);
    }

    private boolean judgeInput() {
//        if(lv1CreditField.getText().equals("") ||
//           lv2CreditField.getText().equals("") ||
//           lv4CreditField.getText().equals("") ||
//           lv3CreditField.getText().equals("") ||
//           lv5CreditField.getText().equals("") ||
//           lv6CreditField.getText().equals("") ||
//           lv1DiscountField.getText().equals("") ||
//           lv2DiscountField.getText().equals("") ||
//           lv3DiscountField.getText().equals("") ||
//           lv4DiscountField.getText().equals("") ||
//           lv5DiscountField.getText().equals("") ||
//           lv6DiscountField.getText().equals(""))
//        {
//            alertController.showInputWrongAlert("请填写全部的信用值和折扣","制定失败");
//            return false;
//        }else {
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
            if(!matcherCredit1.matches() ||
               !matcherCredit2.matches() ||
               !matcherCredit3.matches() ||
               !matcherCredit4.matches() ||
               !matcherCredit5.matches() ||
               !matcherCredit6.matches() ||
               !matcherDiscount1.matches() ||
               !matcherDiscount2.matches() ||
               !matcherDiscount3.matches() ||
               !matcherDiscount4.matches() ||
               !matcherDiscount5.matches() ||
               !matcherDiscount6.matches())
            {
                alertController.showInputWrongAlert("信用值和折扣必须为数字，请重新输入","制定失败");
                return false;
            }
//        }
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
        private int selectedIndex;

        public ProListButtonCell() {
            Image modifyImage = new Image("/img/hotelworker/modifyroom.png");
            modifyButton.setGraphic(new ImageView(modifyImage));
            modifyButton.getStyleClass().add("TableButtonCell");

            Image deleteImage = new Image("/img/hotelworker/deleteroom.png");
            deleteButton.setGraphic(new ImageView(deleteImage));
            deleteButton.getStyleClass().add("TableButtonCell");

            modifyButton.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();
            });

            deleteButton.setOnAction(event -> {
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

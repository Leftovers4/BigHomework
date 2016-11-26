package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.util.ConfirmAlert;
import presentation.hotelworkerui.hotelworkerscene.ReviewPane;
import vo.hotel.HotelVO;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 酒店基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {
    //查看评价、酒店名称、工作人员、编号
    @FXML private Hyperlink showReviewLink;
    @FXML private Label hotelNameLabel;
    @FXML private Label hotelWorkerNameLabel;
    @FXML private Label hotelRatingLabel;

    //地址
    @FXML private Label    cityLabel;
    @FXML private ComboBox cityBox;

    //商圈
    @FXML private ComboBox tradeAreaBox;
    @FXML private Label tradeAreaLabel;

    //简介
    @FXML private TextArea simpleIntroArea;
    @FXML private Label simpleIntroLabel;

    //服务
    @FXML private TextArea hotelServiceArea;
    @FXML private Label hotelServiceLabel;

    //按钮
    @FXML private Button editBtn;
    @FXML private Button saveEditBtn;
    @FXML private Button cancelEditBtn;
    @FXML private Button backBtn;

    private HotelBLService_Stub hotelBLServiceStub;
    private Stage stage;
    private Pane mainPane;
    //提示框控制器
    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        hotelBLServiceStub = new HotelBLService_Stub();
        alertController = new AlertController();
        //初始化数据
        initData();
        //显示查看信息界面
        setCheckInfoComponentsVisible(true);
    }

    private void initData() {
        HotelVO hotelVO = hotelBLServiceStub.findHotelByID(123456);

        hotelNameLabel.setText(hotelVO.hotelName);
        hotelWorkerNameLabel.setText(hotelVO.hotelWorkerName);
        hotelRatingLabel.setText(String.valueOf(hotelVO.rating));
        cityLabel.setText(String.valueOf(hotelVO.address)+"市");
        tradeAreaLabel.setText(String.valueOf(hotelVO.tradingArea));
        simpleIntroLabel.setText(hotelVO.description);
        hotelServiceLabel.setText(hotelVO.service);
    }

    /**
     * 编辑酒店基本信息
     */
    @FXML
    private void editHotelInfo(){
        setCheckInfoComponentsVisible(false);
        setEditInfoComponentsVisible(true);
        cityBox.setValue(cityLabel.getText().substring(0,cityLabel.getText().length()-1));
        tradeAreaBox.setValue(tradeAreaLabel.getText());
    }

    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void back(){
        setCheckInfoComponentsVisible(true);
        setEditInfoComponentsVisible(false);
    }

    @FXML
    private void saveEdit(){
        //组件隐藏与显示
        setCheckInfoComponentsVisible(true);
        setEditInfoComponentsVisible(false);

        //将编辑的内容显示到查看信息界面
        cityLabel.setText(cityBox.getValue()+"市");
        tradeAreaLabel.setText(tradeAreaBox.getValue()+"");
        simpleIntroLabel.setText(simpleIntroArea.getText());
        hotelServiceLabel.setText(hotelServiceArea.getText());
        simpleIntroArea.clear();
        hotelServiceArea.clear();
    }

    @FXML
    private void cancelEdit(){
        if(alertController.showConfirmCancelAlert()){
            simpleIntroArea.clear();
            hotelServiceArea.clear();
            setCheckInfoComponentsVisible(true);
            setEditInfoComponentsVisible(false);
        }
    }

    @FXML
    private void showReview(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new ReviewPane(stage,mainPane));
    }

    private void setEditInfoComponentsVisible(Boolean isVisible){
        cityBox.setVisible(isVisible);
        tradeAreaBox.setVisible(isVisible);
        simpleIntroArea.setVisible(isVisible);
        hotelServiceArea.setVisible(isVisible);
        saveEditBtn.setVisible(isVisible);
        cancelEditBtn.setVisible(isVisible);
        backBtn.setVisible(isVisible);
    }

    private void setCheckInfoComponentsVisible(Boolean isVisible){
        cityLabel.setVisible(isVisible);
        tradeAreaLabel.setVisible(isVisible);
        simpleIntroLabel.setVisible(isVisible);
        hotelServiceLabel.setVisible(isVisible);
        editBtn.setVisible(isVisible);
        showReviewLink.setVisible(isVisible);
    }

}

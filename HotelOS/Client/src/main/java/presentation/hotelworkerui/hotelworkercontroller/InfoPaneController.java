package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    @FXML private Label hotelName;
    @FXML private Label hotelWorkerName;

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

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        hotelBLServiceStub = new HotelBLService_Stub();

        //初始化数据
        initData();
        setCheckInfoComponentsVisible(true);
    }

    private void initData() {
        HotelVO hotelVO = hotelBLServiceStub.findHotelByID(123456);

        hotelName.setText(hotelVO.hotelName);

        cityLabel.setText(String.valueOf(hotelVO.address));
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
    }

    @FXML
    private void closeWindow(){
        //提示框
        ConfirmAlert confirmAlert = new ConfirmAlert("您确定要退出系统吗？","确认退出");
        confirmAlert.showAndWait();
        final ButtonType rtn = confirmAlert.getResult();
        if (rtn == ButtonType.OK) {
            Platform.exit();
        }
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
        cityLabel.setText(cityBox.getPromptText()+"市");
        tradeAreaLabel.setText(tradeAreaBox.getPromptText());
        simpleIntroLabel.setText(simpleIntroArea.getText());
        hotelServiceLabel.setText(hotelServiceArea.getText());
        cityBox.setValue(cityLabel.getText());
        tradeAreaBox.setValue(tradeAreaLabel.getText());
        simpleIntroArea.clear();
        hotelServiceArea.clear();
    }

    @FXML
    private void cancelEdit(){
        simpleIntroArea.clear();
        hotelServiceArea.clear();

        setCheckInfoComponentsVisible(true);
        setEditInfoComponentsVisible(false);
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

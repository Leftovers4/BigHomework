package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.HotelBLService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 酒店基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {
    //查看评价、酒店名称、工作人员、编号
    @FXML private Hyperlink showReviewLink;
    @FXML private Label hotelName;
    @FXML private Label hotelWorkerName;
    @FXML private Label hotelID;

    //地址
    @FXML private Label cityLabel;
    @FXML private Label townLabel;
    @FXML private Label detailPosLabel;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox townBox;
    @FXML private TextField detailPosField;

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

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        hotelBLServiceStub = new HotelBLService_Stub();

        //初始化数据
        setCheckInfoComponentsVisible(true);
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
        stage.close();
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
        setCheckInfoComponentsVisible(true);
        setEditInfoComponentsVisible(false);
    }

    @FXML
    private void cancelEdit(){}

    @FXML
    private void showReview(){}

    private void setEditInfoComponentsVisible(Boolean isVisible){
        cityBox.setVisible(isVisible);
        townBox.setVisible(isVisible);
        detailPosField.setVisible(isVisible);
        tradeAreaBox.setVisible(isVisible);
        simpleIntroArea.setVisible(isVisible);
        hotelServiceArea.setVisible(isVisible);
        saveEditBtn.setVisible(isVisible);
        cancelEditBtn.setVisible(isVisible);
        backBtn.setVisible(isVisible);
    }

    private void setCheckInfoComponentsVisible(Boolean isVisible){
        cityLabel.setVisible(isVisible);
        townLabel.setVisible(isVisible);
        detailPosLabel.setVisible(isVisible);
        tradeAreaLabel.setVisible(isVisible);
        simpleIntroLabel.setVisible(isVisible);
        hotelServiceLabel.setVisible(isVisible);
        editBtn.setVisible(isVisible);
        showReviewLink.setVisible(isVisible);
        backBtn.setVisible(!isVisible);
    }



}

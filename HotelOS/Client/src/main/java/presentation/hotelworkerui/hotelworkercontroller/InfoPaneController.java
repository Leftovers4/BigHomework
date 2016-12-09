package presentation.hotelworkerui.hotelworkercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.hotelworkerui.hotelworkerscene.ReviewPane;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

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
    @FXML private Label    addressLabel;
    @FXML private ComboBox cityBox;

    //商圈
    @FXML private ComboBox tradeAreaBox;

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

    private HotelBLService hotelBLService;
    private Pane mainPane;
    private String city;
    private String tradeArea;
    //提示框控制器
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;


        alertController = new AlertController();
        //初始化接口
        initService();
        initBox();
        //初始化数据
        initData();
        //显示查看信息界面
        setCheckInfoComponentsVisible(true);
    }


    private void initService() {
        try {
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    private void initBox() {
        cityBox.getItems().addAll("南京","苏州","无锡");
        tradeAreaBox.getItems().addAll("仙林商圈","新街口商圈");
    }

    private void initData() {
        HotelVO hotelVO;
        try {
            //TODO 更换hotelID
            hotelVO = hotelBLService.viewBasicHotelInfo(522000);

            city = String.valueOf(hotelVO.address);
            tradeArea = String.valueOf(hotelVO.tradingArea);
            hotelNameLabel.setText(hotelVO.hotelName);
            hotelWorkerNameLabel.setText(hotelVO.hotelWorkerName);
            hotelRatingLabel.setText(String.valueOf(hotelVO.rating));
            addressLabel.setText(city+tradeArea);
            simpleIntroLabel.setText(hotelVO.description);
            hotelServiceLabel.setText(hotelVO.service);
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    /**
     * 编辑酒店基本信息
     */
    @FXML
    private void editHotelInfo(){
        setCheckInfoComponentsVisible(false);
        setEditInfoComponentsVisible(true);
        cityBox.setValue(city);
        tradeAreaBox.setValue(tradeArea);
    }



    @FXML
    private void saveEdit(){
        //组件隐藏与显示
        setCheckInfoComponentsVisible(true);
        setEditInfoComponentsVisible(false);

        HotelVO hotelVO = new HotelVO();
        hotelVO.hotelID = 522000;
        hotelVO.address = cityBox.getValue()+"";
        hotelVO.tradingArea = tradeAreaBox.getValue()+"";
        hotelVO.description = simpleIntroArea.getText();
        hotelVO.service = hotelServiceArea.getText();

        try {
            hotelBLService.updateBasicHotelInfo(hotelVO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //将编辑的内容显示到查看信息界面
        initData();
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
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new ReviewPane(mainPane, hotelRatingLabel.getText()));
    }

    private void setEditInfoComponentsVisible(Boolean isVisible){
        cityBox.setVisible(isVisible);
        tradeAreaBox.setVisible(isVisible);
        simpleIntroArea.setVisible(isVisible);
        hotelServiceArea.setVisible(isVisible);
        saveEditBtn.setVisible(isVisible);
        cancelEditBtn.setVisible(isVisible);
    }

    private void setCheckInfoComponentsVisible(Boolean isVisible){
        addressLabel.setVisible(isVisible);
        simpleIntroLabel.setVisible(isVisible);
        hotelServiceLabel.setVisible(isVisible);
        editBtn.setVisible(isVisible);
        showReviewLink.setVisible(isVisible);
    }

}

package presentation.hotelworkerui.hotelworkercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import presentation.hotelworkerui.hotelworkerscene.ReviewPane;
import presentation.util.other.ChangePhoto;
import presentation.util.other.MyComboBox;
import util.ResultMessage;
import vo.hotel.HotelVO;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import static presentation.util.other.ChangePhoto.updatePhoto;

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

    //星级
    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;

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

    private String newpath = "C:/Leftovers/client/hotel/hotelImg/";

    private Stage stage;
    @FXML private ImageView hotelphoto;

    //提示框控制器
    private AlertController alertController;

    public void launch(Stage stage, Pane mainPane) {
        this.mainPane = mainPane;
        this.stage = stage;


        alertController = new AlertController();
        //初始化接口
        initService();
        //初始化数据
        initData();
        //显示查看信息界面
        setCheckInfoComponentsVisible(true);

        initialPhoto();
    }

    private void initialPhoto() {
        String path = newpath + String.valueOf(ComWorkerSceneController.hotelID) + "/" + ComWorkerSceneController.hotelID + ".jpg";
        File file = new File(newpath + String.valueOf(ComWorkerSceneController.hotelID) + "/");


        if (file.exists()) {
            Image image = new Image("file:///" + path);
            hotelphoto.setImage(image);
        }
    }


    private void initService() {
        try {
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    private void initData() {
        HotelVO hotelVO;
        try {
            hotelVO = hotelBLService.viewBasicHotelInfo(ComWorkerSceneController.hotelID);

            city = String.valueOf(hotelVO.address);
            tradeArea = String.valueOf(hotelVO.tradingArea);
            hotelNameLabel.setText(hotelVO.hotelName);
            hotelWorkerNameLabel.setText(hotelVO.hotelWorkerName);
            hotelRatingLabel.setText(String.valueOf(hotelVO.rating));
            addressLabel.setText(city+tradeArea);
            simpleIntroLabel.setText(hotelVO.description);
            hotelServiceLabel.setText(hotelVO.service);

            //初始化星级
            initStar(hotelVO.star);
        } catch (RemoteException e) {
            alertController.showNetConnectAlert();
        }
    }

    private void initStar(int star) {
        ArrayList<ImageView> starLists = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
        for (int i = 0; i < star; i++){
            starLists.get(i).setVisible(true);
        }
    }

    /**
     * 编辑酒店基本信息
     */
    @FXML
    private void editHotelInfo(){
        MyComboBox.initAreaBox(cityBox,tradeAreaBox);
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
        hotelVO.hotelID = ComWorkerSceneController.hotelID;
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
        mainPane.getChildren().add(new ReviewPane(mainPane, hotelRatingLabel.getText(), ComWorkerSceneController.hotelID));
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


    /**
     * 更换账号头像
     */
    @FXML
    private void changePhoto() {
        long hotelID = ComWorkerSceneController.hotelID;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择图片");
        File selectedDirectory = fileChooser.showOpenDialog(stage);

        if (selectedDirectory!=null) {
            try {

                String fileName = selectedDirectory.getAbsolutePath();


                File file = new File(fileName);

                byte[] imgbyte = ChangePhoto.toBytesFromFile(file);

                ResultMessage resultMessage = hotelBLService.setHotelImage(hotelID, imgbyte);

                ChangePhoto.setImage(newpath + String.valueOf(hotelID) + "/", hotelID, imgbyte);
////                Image image = new Image("file:///"+fileName);
////                userPhoto.setImage(image);
                updatePhoto(hotelphoto, newpath + String.valueOf(hotelID) + "/" + String.valueOf(hotelID) +".jpg");
////                topBarPhoto.setImage(image);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

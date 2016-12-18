package presentation.userui.usercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyj on 2016/11/25.
 */
public class EvaluateOrderController {

    private Stage stage;
    private String orderID;
    private String userID;

    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;

    @FXML private TextArea reviewField;

    @FXML private ImageView hotelPhoto;

    private ArrayList<ImageView> starGroup;
    private boolean isClicked = false;
    private OrderBLService orderBlService;
    private HotelBLService hotelBLService;

    private AlertController alertController;
    private Pane mainPane;
    private int rate;

    public void launch(Stage primaryStage, String orderID, String userID, Pane mainPane) {
        this.stage = primaryStage;
        this.orderID = orderID;
        this.userID = userID;
        this.mainPane = mainPane;
        try {
            orderBlService = new OrderBlServiceImpl();
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        starGroup = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
        alertController = new AlertController();

        initPhoto();
    }


    private void initPhoto() {
        String newpath = "C:/Leftovers/client/user/hotelImg/";

        try {
            long hotelID = (orderBlService.searchExtraOrderByID(orderID)).hotelID;

            HotelVO hotelVO = hotelBLService.viewBasicHotelInfo(hotelID);

            if (hotelVO != null) {
                if (hotelVO.image != null) {
                    String path = newpath + hotelID + ".jpg";
                    File file = new File(path);

                    if (file.exists()) {
                        Image image = new Image("file:///"+path);
                        hotelPhoto.setImage(image);
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private void starHover(ImageView star) {
        isClicked = false;
        Image image = new Image("/img/user/yellowStar.png");
        star.setImage(image);
    }
    private void starOut() {
        Image image = new Image("/img/user/blankStar.png");
        if (!isClicked) {
            star1.setImage(image);
            star2.setImage(image);
            star3.setImage(image);
            star4.setImage(image);
            star5.setImage(image);
        }
    }
    private void starEvent(ImageView star) {
        isClicked = true;
        Image imageYellow = new Image("/img/user/yellowStar.png");
        Image imageBlank = new Image("/img/user/blankStar.png");
        int pos = starGroup.indexOf(star);
        System.out.print(pos);
        for(int i = 0; i<=pos; i++) {
            starGroup.get(i).setImage(imageYellow);
        }

        for(int i = starGroup.size()-1; i>pos; i--) {
            starGroup.get(i).setImage(imageBlank);
        }
    }


    @FXML
    private void star1hover() {
        starHover(star1);
    }
    @FXML
    private void star1out() {
        starOut();
    }
    @FXML
    private void star1event() {
        starEvent(star1);
        rate = 1;
    }

    @FXML
    private void star2hover() {
        starHover(star1);
        starHover(star2);
    }
    @FXML
    private void star2out() {
        starOut();
    }
    @FXML
    private void star2event() {
        starEvent(star2);
        rate = 2;
    }

    @FXML
    private void star3hover() {
        starHover(star1);
        starHover(star2);
        starHover(star3);
    }
    @FXML
    private void star3out() {
        starOut();
    }
    @FXML
    private void star3event() {
        starEvent(star3);
        rate = 3;
    }

    @FXML
    private void star4hover() {
        starHover(star1);
        starHover(star2);
        starHover(star3);
        starHover(star4);
    }
    @FXML
    private void star4out() {
        starOut();
    }
    @FXML
    private void star4event() {
        starEvent(star4);
        rate = 4;
    }

    @FXML
    private void star5hover() {
        starHover(star1);
        starHover(star2);
        starHover(star3);
        starHover(star4);
        starHover(star5);
    }
    @FXML
    private void star5out() {
        starOut();
    }
    @FXML
    private void star5event() {
        starEvent(star5);
        rate = 5;
    }

    /**
     * 确认提交评价
     */
    @FXML
    private void confirmSubmit() {
        ReviewVO reviewVO = new ReviewVO();

        reviewVO.username = userID;
        reviewVO.orderID = orderID;
        reviewVO.rating = rate;
        reviewVO.review = reviewField.getText();

        try {
            ResultMessage resultMessage = orderBlService.reviewOrder(reviewVO);

            if (resultMessage == ResultMessage.Success) {
                alertController.showUpdateSuccessAlert("评价成功！", "成功提示");
                System.out.println("review success");
            } else if (resultMessage ==ResultMessage.DataExisted){
                alertController.showInputWrongAlert("您已评价过", "失败提示");
                System.out.println("review failed");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size() - 1);
    }
}

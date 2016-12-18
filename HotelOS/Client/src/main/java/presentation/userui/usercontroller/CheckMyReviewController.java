package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import util.DateTimeFormat;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyj on 2016/12/13.
 */
public class CheckMyReviewController {

    private String orderID;

    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;

    @FXML private Label reviewContent;
    @FXML private Label reviewTimeLabel;

    private OrderBlServiceImpl orderBlService;
    private Pane mainPane;

    private ArrayList<ImageView> star;

    public void launch(String orderID, Pane mainPane) {
        this.orderID = orderID;
        this.mainPane = mainPane;

        star = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));

        try {
            orderBlService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        try {
            ReviewVO reviewVO = orderBlService.viewOrderReview(orderID);

            int starLevel = reviewVO.rating;
            for (int i = 0; i<starLevel; i++) {
                star.get(i).setImage(new Image("/img/user/yellowStar.png"));
            }

            reviewContent.setText(reviewVO.review.equals("") ? "无" : reviewVO.review);
            reviewTimeLabel.setText(reviewVO.reviewTime.format(DateTimeFormat.dateHourFormat));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    //TODO
    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size() - 1);
    }
}

package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import vo.order.OrderVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hitiger on 2016/12/6.
 * Description :
 */
public class UserReviewPaneController {

    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;

    @FXML private Label reviewLabel;
    @FXML private Label reviewTimeLabel;

    private Pane mainPane;
    private OrderVO orderVO;
    private Boolean isCheckIn;
    private Boolean isFromList;
    private ArrayList<ImageView> starLists;

    public void launch(Pane mainPane, Boolean isCheckIn, Boolean isFromList, OrderVO orderVO) {
        this.mainPane = mainPane;
        this.orderVO = orderVO;
        this.isCheckIn = isCheckIn;
        this.isFromList = isFromList;

        starLists = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));

        initStar(orderVO.reviewVO.rating);
        initReview(orderVO.reviewVO.reviewTime, orderVO.reviewVO.review);
    }

    private void initStar(int rating) {
        for (int i = 0; i < rating; i++){
            Image image = new Image("/img/user/yellowStar.png");
            starLists.get(i).setImage(image);
        }
    }

    private void initReview(LocalDateTime reviewTime, String review) {
        reviewTimeLabel.setText(reviewTime.toString());
        reviewLabel.setText(review);
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new OrderDetailPane(mainPane,isCheckIn, isFromList,orderVO));
    }
}

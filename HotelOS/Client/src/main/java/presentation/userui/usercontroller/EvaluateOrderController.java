package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyj on 2016/11/25.
 */
public class EvaluateOrderController {

    private Stage stage;

    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;

    private ArrayList<ImageView> starGroup;
    private boolean isClicked = false;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;

        starGroup = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
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
    }
}

package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyj on 2016/12/12.
 */
public class CheckHotelInfoController {

    private Pane mainPane;
    private long hotelID;

    @FXML private Label hotelNameLabel;
    @FXML private Label hotelWorkerNameLabel;
    @FXML private ImageView star1;
    @FXML private ImageView star2;
    @FXML private ImageView star3;
    @FXML private ImageView star4;
    @FXML private ImageView star5;
    @FXML private Label hotelRatingLabel;
    @FXML private Label addressLabel;
    @FXML private Label simpleIntroLabel;
    @FXML private Label hotelServiceLabel;

    private HotelBlServiceImpl hotelBlService;

    private ArrayList<ImageView> star;

    public void launch(Pane mainPane, long hotelID) {
        this.mainPane = mainPane;
        this.hotelID = hotelID;

        star = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
        for (int i = 0; i<star.size(); i++) {
            star.get(i).setVisible(false);
        }

        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        try {
            HotelVO hotelVO = hotelBlService.viewBasicHotelInfo(hotelID);

            hotelNameLabel.setText(hotelVO.hotelName);
            hotelWorkerNameLabel.setText(hotelVO.hotelWorkerName);
            showStar(hotelVO.star);
            hotelRatingLabel.setText(String.valueOf(hotelVO.rating));
            addressLabel.setText(hotelVO.address + hotelVO.tradingArea);
            simpleIntroLabel.setText(hotelVO.description);
            hotelServiceLabel.setText(hotelVO.service);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void showStar(int starNum) {
        for (int i = 0; i<starNum; i++) {
            star.get(i).setVisible(true);
        }
    }
}

package presentation.util.buttoncell;

import bl.hotelbl.HotelBLService;
import javafx.collections.ObservableList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/12/18.
 */
public class HotelPhotoButtonCell extends TableCell<HotelVO, Boolean> {

    final private Label hotel = new Label();
    private ImageView imageView = new ImageView();

    public HotelPhotoButtonCell(ObservableList<HotelVO> list, int index, HotelBLService hotelBlService) {
        String path = "C:/Leftovers/client/user/hotelImg/";
        imageView.setFitWidth(140);
        imageView.setFitHeight(140);
        try {
            if(index < list.size()){
                HotelVO hotelVO = hotelBlService.viewBasicHotelInfo(list.get(index).hotelID);

                if (hotelVO.image != null) {
                    Image image = new Image("file:///" + path + list.get(index).hotelID + ".jpg");
                    imageView.setImage(image);
                } else {
                    Image image = new Image("/img/common/initialPhoto.png");
                    imageView.setImage(image);
                }

                hotel.setText(hotelVO.hotelName);
                hotel.setGraphic(imageView);
                hotel.setContentDisplay(ContentDisplay.TOP);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            setGraphic(hotel);
            setText(null);
        }
    }
}
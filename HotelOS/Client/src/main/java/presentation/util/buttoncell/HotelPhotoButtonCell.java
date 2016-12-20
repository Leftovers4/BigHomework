package presentation.util.buttoncell;

import bl.hotelbl.HotelBLService;
import javafx.collections.ObservableList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/12/18.
 */
public class HotelPhotoButtonCell extends TableCell<HotelVO, Boolean> {

    private TableView tableView;
    final private Label hotel = new Label();
    private ImageView imageView = new ImageView();

    public HotelPhotoButtonCell(TableView tableView) {
        this.tableView = tableView;

    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            String path = "C:/Leftovers/client/user/hotelImg/";
            imageView.setFitWidth(140);
            imageView.setFitHeight(140);
            HotelVO hotelVO = (HotelVO) tableView.getItems().get(getTableRow().getIndex());

            if (hotelVO.image != null) {
                Image image = new Image("file:///" + path + hotelVO.hotelID + ".jpg");
                imageView.setImage(image);
            } else {
                Image image = new Image("/img/common/initialHotel.png");
                imageView.setImage(image);
            }

            hotel.setText(hotelVO.hotelName);
            hotel.setGraphic(imageView);
            hotel.setContentDisplay(ContentDisplay.TOP);
            setGraphic(hotel);
            setText(null);
        }
    }
}
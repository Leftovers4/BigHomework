package presentation.util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import presentation.hotelworkerui.hotelworkercontroller.RegisterRoomPaneController;
import vo.hotel.RoomVO;

/**
 * Created by Hitiger on 2016/12/1.
 * Description :
 */
public class RoomListButtonCell extends TableCell<RoomVO, Boolean> {
    final private HBox btnBox = new HBox();
    final private Button modifyButton = new Button();
    final private Button deleteButton = new Button();
    private int selectedIndex;

    public RoomListButtonCell(final TableView tableView, RegisterRoomPaneController controller) {
        this.getStylesheets().add(HotelListButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());

        Image modifyImage = new Image("/img/hotelworker/modifyroom.png");
        modifyButton.setGraphic(new ImageView(modifyImage));
        modifyButton.getStyleClass().add("TableButtonCell");

        Image deleteImage = new Image("/img/hotelworker/deleteroom.png");
        deleteButton.setGraphic(new ImageView(deleteImage));
        deleteButton.getStyleClass().add("TableButtonCell");

        modifyButton.setOnAction(event -> {
            selectedIndex = getTableRow().getIndex();
            RoomVO roomVO = (RoomVO) tableView.getItems().get(selectedIndex);

            controller.setAdd(false);
            tableView.setDisable(true);
            controller.setAddComponentsVisible(true);
            controller.getRoomBox().setValue(roomVO.roomType);
            controller.getRoomBox().setDisable(true);
            controller.getRoomAmountField().setText(String.valueOf(roomVO.total));
            controller.getRoomPriceField().setText(String.valueOf(roomVO.price));
        });

        deleteButton.setOnAction(event -> {
            selectedIndex = getTableRow().getIndex();
            if(controller.getAlertController().showConfirmDeleteAlert("您确定要删除此类客房吗？","确认删除"))
                tableView.getItems().remove(selectedIndex);
        });

        btnBox.setSpacing(10);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setPadding(new Insets(0,10,0,20));
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btnBox.getChildren().clear();
            btnBox.getChildren().addAll(modifyButton, deleteButton);
            setGraphic(btnBox);
            setText(null);
        }
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
}
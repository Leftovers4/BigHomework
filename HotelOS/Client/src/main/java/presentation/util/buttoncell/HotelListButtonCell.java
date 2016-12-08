package presentation.util.buttoncell;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOrderInfoPane;
import util.OrderType;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/30.
 * Description :
 */
public class HotelListButtonCell extends TableCell<OrderVO, Boolean> {
    final private HBox btnBox = new HBox();
    final private Button detailButton = new Button();
    final private Button checkInButton = new Button();
    private TableView tableView;

    public HotelListButtonCell(final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;

        this.getStylesheets().add(HotelListButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());
        Image detailImage = new Image("/img/hotelworker/checkorderdetail.png");
        detailButton.setGraphic(new ImageView(detailImage));
        detailButton.getStyleClass().add("TableButtonCell");

        Image checkInImage = new Image("/img/hotelworker/checkin.png");
        checkInButton.setGraphic(new ImageView(checkInImage));
        checkInButton.getStyleClass().add("TableButtonCell");

        detailButton.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new OrderDetailPane(mainPane, false,true,orderVO));
        });

        checkInButton.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new UpdateOrderInfoPane(mainPane, true, true, orderVO));
        });

        btnBox.setSpacing(10);
        btnBox.setAlignment(Pos.CENTER);
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btnBox.getChildren().clear();
            if(((OrderVO)tableView.getItems().get(getTableRow().getIndex())).orderType == OrderType.Executed){
                btnBox.setAlignment(Pos.CENTER_LEFT);
                btnBox.setPadding(new Insets(0,0,0,13));
                btnBox.getChildren().add(detailButton);
            }else {
                btnBox.setPadding(new Insets(0,5,0,20));
                btnBox.getChildren().addAll(detailButton, checkInButton);
            }
            setGraphic(btnBox);
            setText(null);
        }
    }
}
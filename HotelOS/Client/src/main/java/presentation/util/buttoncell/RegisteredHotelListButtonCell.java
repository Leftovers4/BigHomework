package presentation.util.buttoncell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.OrderDetailUserPane;
import vo.hotel.HotelVO;

/**
 * Created by wyj on 2016/12/6.
 * Description: 预订过的酒店列表添加按钮的方法：查看酒店详情按钮
 */
public class RegisteredHotelListButtonCell extends TableCell<HotelVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button checkDetailBtn = new Button();
    private TableView tableView;

    public RegisteredHotelListButtonCell(final Stage stage, final Pane mainPane, final  TableView tableView) {
        this.tableView = tableView;

        this.getStylesheets().add(CreditTabelButtonCell.class.getResource("/css/user/userstyle.css").toExternalForm());
        Image detailimg = new Image("/img/user/checkdetail.png");
        checkDetailBtn.setGraphic(new ImageView(detailimg));
        checkDetailBtn.getStyleClass().add("tableCellBtn");

        checkDetailBtn.setOnAction(event -> {
//            int selectedIndex = getTableRow().getIndex();
//            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new OrderDetailUserPane(stage, mainPane));
        });
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btnBox.getChildren().add(checkDetailBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

package presentation.util.buttoncell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.UserGenerateOrderPane;
import presentation.userui.userscene.UserHotelInfoPane;
import vo.hotel.HotelVO;

/**
 * Created by wyj on 2016/12/6.
 * Description: 客户搜索酒店，酒店列表添加按钮的方法：预订按钮、查看酒店详情按钮
 */
public class UserHotelListButtonCell extends TableCell<HotelVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button checkDetailBtn = new Button();
    final private Button generateOrderBtn = new Button();
    private TableView tableView;

    public UserHotelListButtonCell(final Stage stage, final Pane mainPane, final TableView tableView, final String userID) {
        this.tableView = tableView;

        this.getStylesheets().add(UserHotelListButtonCell.class.getResource("/css/user/userstyle.css").toExternalForm());
        Image detailImg = new Image("/img/user/checkdetail.png");
        checkDetailBtn.setGraphic(new ImageView(detailImg));
        checkDetailBtn.getStyleClass().add("tableCellBtn");

        Image generateImg = new Image("/img/user/generateOrder.png");
        generateOrderBtn.setGraphic(new ImageView(generateImg));
        generateOrderBtn.getStyleClass().add("tableCellBtn");

        checkDetailBtn.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new UserHotelInfoPane(stage, mainPane, userID, hotelVO.hotelID));
        });

        generateOrderBtn.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new UserGenerateOrderPane(stage, mainPane, userID, hotelVO.hotelID));
        });
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btnBox.getChildren().clear();
            btnBox.getChildren().add(checkDetailBtn);
            btnBox.getChildren().add(generateOrderBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

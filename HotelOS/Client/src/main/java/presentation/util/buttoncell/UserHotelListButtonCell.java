package presentation.util.buttoncell;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.UserGenerateOrderPane;
import presentation.userui.userscene.UserHotelInfoPane;
import presentation.util.other.ToolTipShow;
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

        this.getStylesheets().add(UserHotelListButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());
        Image detailImg = new Image("/img/webmanager/information.png");
        checkDetailBtn.setGraphic(new ImageView(detailImg));
        checkDetailBtn.getStyleClass().add("TableInfoButtonCell");

        Image generateImg = new Image("/img/user/generateOrder.png");
        generateOrderBtn.setGraphic(new ImageView(generateImg));
        generateOrderBtn.getStyleClass().add("TableCreateButtonCell");

        checkDetailBtn.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().add(new UserHotelInfoPane(stage, mainPane, userID, hotelVO.hotelID));
        });

        generateOrderBtn.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().add(new UserGenerateOrderPane(stage, mainPane, userID, hotelVO.hotelID, null));
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
            btnBox.setSpacing(10);
            btnBox.setAlignment(Pos.CENTER);
            btnBox.setPadding(new Insets(0, 10, 0, 20));
            btnBox.setPadding(new Insets(0, 10, 0, 20));
            checkDetailBtn.setTooltip(ToolTipShow.setTool("详情"));
            generateOrderBtn.setTooltip(ToolTipShow.setTool("预订"));
            btnBox.getChildren().addAll(checkDetailBtn, generateOrderBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

package presentation.util.buttoncell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.hotel.HotelVO;

/**
 * Created by wyj on 2016/12/7.
 * Description: 网站管理人员工具类---客户列表按钮
 */
public class WebManUserButtonCell extends TableCell<HotelVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button editBtn = new Button();
    private TableView tableView;

    public WebManUserButtonCell(final Stage stage, final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;
        this.getStylesheets().add(WebManHotelListButtonCell.class.getResource("/css/webmanager/webManagerStyle.css").toExternalForm());

        Image editImg = new Image("/img/webmanager/edit.png");
        ImageView editimgview = new ImageView(editImg);
        editimgview.setFitHeight(20);
        editimgview.setFitWidth(20);
        editBtn.setGraphic(editimgview);
        editBtn.getStyleClass().add("tableCellBtn");

        editBtn.setOnAction(event -> {

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
            btnBox.getChildren().add(editBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

package presentation.util.buttoncell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagerscene.AddHotelPane;
import vo.hotel.HotelVO;

/**
 * Created by wyj on 2016/12/7.
 * Description: 网站管理人员工具类---酒店工作人员列表按钮
 */
public class WebManHotelworkerButtonCell extends TableCell<HotelVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button editBtn = new Button();
    final private Button deleteBtn = new Button();
    private TableView tableView;

    public WebManHotelworkerButtonCell(final Stage stage, final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;
        this.getStylesheets().add(WebManHotelListButtonCell.class.getResource("/css/webmanager/webManagerStyle.css").toExternalForm());

        Image editImg = new Image("/img/webmanager/edit.png");
        ImageView editimgview = new ImageView(editImg);
        editimgview.setFitHeight(20);
        editimgview.setFitWidth(20);
        editBtn.setGraphic(editimgview);
        editBtn.getStyleClass().add("tableCellBtn");
        Image deleteImg = new Image("/img/webmanager/delete.png");
        ImageView deleteimgview = new ImageView(deleteImg);
        deleteimgview.setFitWidth(20);
        deleteimgview.setFitHeight(20);
        deleteBtn.setGraphic(deleteimgview);
        deleteBtn.getStyleClass().add("tableCellBtn");


        editBtn.setOnAction(event -> {

        });

        deleteBtn.setOnAction(event -> {

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
            btnBox.getChildren().add(deleteBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

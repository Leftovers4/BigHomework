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
 * Description: 网站管理人员工具类---网站营销人员列表按钮
 */
public class WebManMarketerButtonCell extends TableCell<HotelVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button addBtn = new Button();
    final private Button editBtn = new Button();
    final private Button deleteBtn = new Button();
    private TableView tableView;

    public WebManMarketerButtonCell(final Stage stage, final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;
        this.getStylesheets().add(WebManHotelListButtonCell.class.getResource("/css/webmanager/webManagerStyle.css").toExternalForm());

        Image addImg = new Image("/img/webmanager/newhotel.png");
        addBtn.setGraphic(new ImageView(addImg));
        addBtn.getStyleClass().add("tableCellBtn");
        Image editImg = new Image("/img/webmanager/edit.png");
        editBtn.setGraphic(new ImageView(editImg));
        editBtn.getStyleClass().add("tableCellBtn");
        Image deleteImg = new Image("/img/webmanager/delete.png");
        deleteBtn.setGraphic(new ImageView(deleteImg));
        deleteBtn.getStyleClass().add("tableCellBtn");

        addBtn.setOnAction(event -> {
//            int selectedIndex = getTableRow().getIndex();
//            HotelVO hotelVO = (HotelVO) tableView.getItems().get(selectedIndex);
//            mainPane.getChildren().remove(0);
//            mainPane.getChildren().add(new AddHotelPane(stage));
        });

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
            btnBox.getChildren().add(addBtn);
            btnBox.getChildren().add(editBtn);
            btnBox.getChildren().add(deleteBtn);
            setGraphic(btnBox);
            setText(null);
        }
    }
}

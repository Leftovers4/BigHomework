package presentation.util;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.OrderDetailUserPane;
import vo.user.CreditVO;


/**
 * Created by wyj on 2016/12/2.
 * Description: 信用记录列表添加按钮的方法：查看订单详情按钮
 */
public class CreditTabelButtonCell extends TableCell<CreditVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button checkDetailBtn = new Button();
    private TableView tableView;

    public CreditTabelButtonCell(final Stage stage, final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;

        this.getStylesheets().add(CreditTabelButtonCell.class.getResource("/css/user/userstyle.css").toExternalForm());
        Image detailimg = new Image("/img/user/checkdetail.png");
        checkDetailBtn.setGraphic(new ImageView(detailimg));
        checkDetailBtn.getStyleClass().add("tableCellBtn");

        checkDetailBtn.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            CreditVO creditVO = (CreditVO) tableView.getItems().get(selectedIndex);
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

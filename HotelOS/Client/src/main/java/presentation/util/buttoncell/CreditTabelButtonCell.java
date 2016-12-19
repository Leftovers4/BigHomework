package presentation.util.buttoncell;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.OrderDetailUserPane;
import presentation.util.other.ToolTipShow;
import util.CreditChangedCause;
import vo.user.CreditRecordVO;
import vo.user.CreditVO;

import java.rmi.RemoteException;


/**
 * Created by wyj on 2016/12/2.
 * Description: 信用记录列表添加按钮的方法：查看订单详情按钮
 */
public class CreditTabelButtonCell extends TableCell<CreditRecordVO, Boolean> {

    final private HBox btnBox = new HBox();
    final private Button checkDetailBtn = new Button();
    private TableView tableView;
    private Stage stage;
    private Pane mainPane;
    private String userID;

    public CreditTabelButtonCell(final Stage stage, final Pane mainPane, final TableView tableView, final String userID) {
        this.tableView = tableView;
        this.stage = stage;
        this.mainPane = mainPane;
        this.userID = userID;

        this.getStylesheets().add(CreditTabelButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());

    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            Image detailimg = new Image("/img/hotelworker/checkorderdetail.png");
            checkDetailBtn.setGraphic(new ImageView(detailimg));
            checkDetailBtn.getStyleClass().add("TableDetailButtonCell");

            checkDetailBtn.setOnAction(event -> {
                int selectedIndex = getTableRow().getIndex();
                CreditRecordVO creditRecordVO = (CreditRecordVO) tableView.getItems().get(selectedIndex);
                mainPane.getChildren().add(new OrderDetailUserPane(stage, mainPane, userID, creditRecordVO.orderID));
            });

            CreditRecordVO recordVO = (CreditRecordVO) tableView.getItems().get(getTableRow().getIndex());

            btnBox.getChildren().clear();
            checkDetailBtn.setTooltip(ToolTipShow.setTool("查看详情"));
            btnBox.setAlignment(Pos.CENTER);
            btnBox.setPadding(new Insets(0, 0, 0, 20));
            if (recordVO.creditChangedCause != CreditChangedCause.Recharge) {
                btnBox.getChildren().add(checkDetailBtn);
            }
            setGraphic(btnBox);
            setText(null);
        }
    }
}

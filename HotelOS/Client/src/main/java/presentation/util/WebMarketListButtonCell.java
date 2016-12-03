package presentation.util;

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
import presentation.webmarketerui.webmarketerscene.AppealOrderPane;
import presentation.webmarketerui.webmarketerscene.OrderDetailPane;
import util.OrderType;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/30.
 * Description :
 */
public class WebMarketListButtonCell extends TableCell<OrderVO, Boolean> {
    final private HBox btnBox = new HBox();
    final private Button detailButton = new Button();
    final private Button appealButton = new Button();
    private TableView tableView;

    public WebMarketListButtonCell(final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;

        this.getStylesheets().add(WebMarketListButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());
        Image detailImage = new Image("/img/webmarketer/checkorderdetail.png");
        detailButton.setGraphic(new ImageView(detailImage));
        detailButton.getStyleClass().add("TableButtonCell");

        Image appealImage = new Image("/img/webmarketer/appealbutton.png");
        appealButton.setGraphic(new ImageView(appealImage));
        appealButton.setId("appealButton");
        appealButton.getStyleClass().add("TableButtonCell");

        detailButton.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new OrderDetailPane(mainPane,orderVO));
        });

        appealButton.setOnAction(event -> {
            int selectedIndex = getTableRow().getIndex();
            OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new AppealOrderPane(mainPane));
        });

        btnBox.setSpacing(10);
        btnBox.setAlignment(Pos.CENTER_LEFT);
        btnBox.setPadding(new Insets(0,10,0,10));
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btnBox.getChildren().clear();
            if(((OrderVO)tableView.getItems().get(getTableRow().getIndex())).orderType == OrderType.Abnormal){
                btnBox.getChildren().addAll(detailButton, appealButton);
            }else {
                btnBox.getChildren().add(detailButton);
            }
            setGraphic(btnBox);
            setText(null);
        }
    }
}
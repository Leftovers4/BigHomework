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
import presentation.webmarketerui.webmarketerscene.AppealOrderPane;
import presentation.webmarketerui.webmarketerscene.OrderDetailPane;
import util.OrderType;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/30.
 * Description :
 */
public class WebMarketListButtonCell extends TableCell<OrderVO, Boolean> {

    private TableView tableView;
    private Pane mainPane;

    public WebMarketListButtonCell(final Pane mainPane, final TableView tableView) {
        this.tableView = tableView;
        this.mainPane = mainPane;
        this.getStylesheets().add(WebMarketListButtonCell.class.getResource("/css/hotelworker/hotelworkerstyle.css").toExternalForm());
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            HBox btnBox = new HBox();
            Button detailButton = new Button();

            Image detailImage = new Image("/img/webmarketer/checkorderdetail.png");
            detailButton.setGraphic(new ImageView(detailImage));
            detailButton.getStyleClass().add("TableButtonCell");

            detailButton.setOnAction(event -> {
                int selectedIndex = getTableRow().getIndex();
                OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
                mainPane.getChildren().remove(0);
                mainPane.getChildren().add(new OrderDetailPane(mainPane,orderVO));
            });

            btnBox.setSpacing(10);
            btnBox.getChildren().clear();

            OrderVO temp = (OrderVO)tableView.getItems().get(getTableRow().getIndex());

            if(temp.orderType == OrderType.Abnormal){
                Button appealButton = new Button();

                Image appealImage = new Image("/img/webmarketer/appealbutton.png");
                appealButton.setGraphic(new ImageView(appealImage));
                appealButton.setId("appealButton");
                appealButton.getStyleClass().add("TableButtonCell");

                appealButton.setOnAction(event -> {
                    int selectedIndex = getTableRow().getIndex();
                    OrderVO orderVO = (OrderVO) tableView.getItems().get(selectedIndex);
                    mainPane.getChildren().remove(0);
                    mainPane.getChildren().add(new AppealOrderPane(mainPane,orderVO));
                });

                btnBox.setAlignment(Pos.CENTER);
                btnBox.setPadding(new Insets(0,5,0,20));
                btnBox.getChildren().addAll(detailButton, appealButton);
            }else {
                btnBox.setAlignment(Pos.CENTER_LEFT);
                btnBox.setPadding(new Insets(0,0,0,13));
                btnBox.getChildren().add(detailButton);
            }

            setGraphic(btnBox);
            setText(null);
        }
    }
}
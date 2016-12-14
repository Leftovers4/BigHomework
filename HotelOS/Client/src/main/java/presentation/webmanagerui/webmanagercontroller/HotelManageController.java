package presentation.webmanagerui.webmanagercontroller;

import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.webmanagerui.webmanagerscene.AddHotelPane;
import presentation.webmanagerui.webmanagerscene.CheckHotelInfoPane;
import presentation.webmanagerui.webmanagerscene.HotelManagePane;
import util.AddTradProducer;
import util.ResultMessage;
import vo.hotel.HotelVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelManageController {

    private Stage stage;
    private Pane pane;

    @FXML private Button confirmBtn;
    @FXML private Button cancelBtn;
    @FXML private Button searchhotelBtn;
    @FXML private Button newhotelBtn;
    @FXML private TextField hotelnameinput;
    @FXML private ComboBox cityCB;
    @FXML private ComboBox tracingareaCB;
    @FXML private ComboBox star;

    @FXML private HBox editBox;

    @FXML private TableView hotelList;
    @FXML private TableColumn hotelIDCol;
    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn hotelCityCol;
    @FXML private TableColumn hotelBusinessCol;
    @FXML private TableColumn btnCol;

    private HotelBlServiceImpl hotelBlService;
    private WebManHotelListButtonCell webManHotelListButtonCell;


    public void launch(Stage primaryStage, Pane mainPane) {
        this.pane = mainPane;
        this.stage = primaryStage;


        try {
            hotelBlService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
        initialTable();
    }


    private void initialData() {
        Iterator<String> cityList = AddTradProducer.getAllAddress();
        while (cityList.hasNext()) {
            cityCB.getItems().add(cityList.next());
        }

        for (int i = 1; i<=5; i++) {
            star.getItems().add(i);
        }

        cityCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    Iterator<String> tracingArea = AddTradProducer.getTradingAreasByAddress(newValue.toString());
                    while (tracingArea.hasNext()) {
                        tracingareaCB.getItems().add(tracingArea.next());
                    }
                }
            }
        });
    }


    private void initialTable() {
        hotelIDCol.setCellValueFactory(new PropertyValueFactory<>("hotelID"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        hotelCityCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        hotelBusinessCol.setCellValueFactory(new PropertyValueFactory<>("tradingArea"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                webManHotelListButtonCell = new WebManHotelListButtonCell();
                return webManHotelListButtonCell;
            }
        });
        hotelList.setItems(getHotelList());
    }
    private ObservableList getHotelList() {
        ObservableList<HotelVO> list = null;
        try {
            list = FXCollections.observableArrayList(hotelBlService.viewFullHotelList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 添加酒店
     */
    @FXML
    private void newHotel() {
        pane.getChildren().remove(0);
        pane.getChildren().add(new AddHotelPane(stage));
    }






    /**
     * Created by wyj on 2016/12/7.
     * Description: 网站管理人员工具类---酒店管理列表按钮
     */
    private class WebManHotelListButtonCell extends TableCell<HotelVO, Boolean> {

        final private HBox btnBox = new HBox();
        final private Button editBtn = new Button();
        final private Button deleteBtn = new Button();
        final private Button checkDetailBtn = new Button();

        private int selectedIndex;

        private HotelBlServiceImpl hotelBlService;

        public WebManHotelListButtonCell() {

            Image editImg = new Image("/img/webmanager/edit.png");
            ImageView editimgview = new ImageView(editImg);
            editimgview.setFitWidth(20);
            editimgview.setFitHeight(20);
            editBtn.setGraphic(editimgview);
            editBtn.getStyleClass().add("tableCellBtn");
            Image deleteImg = new Image("/img/webmanager/delete.png");
            ImageView deleteimgview = new ImageView(deleteImg);
            deleteimgview.setFitWidth(20);
            deleteimgview.setFitHeight(20);
            deleteBtn.setGraphic(deleteimgview);
            deleteBtn.getStyleClass().add("tableCellBtn");
            Image checkdetailimg = new Image("/img/user/checkdetail.png");
            ImageView checkdetailimgview = new ImageView(checkdetailimg);
            checkdetailimgview.setFitHeight(20);
            checkdetailimgview.setFitWidth(20);
            checkDetailBtn.setGraphic(checkdetailimgview);
            checkDetailBtn.getStyleClass().add("tableCellBtn");


            editBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                hotelList.setPrefHeight(300);
                editBox.setVisible(true);
            });


            deleteBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                HotelVO hotelVO = (HotelVO) hotelList.getItems().get(selectedIndex);
                try {
                    ResultMessage resultMessage = hotelBlService.deleteHotel(hotelVO.hotelID);

                    if (resultMessage == ResultMessage.Success) {
                        System.out.println("delete success");

                        pane.getChildren().remove(0);
                        pane.getChildren().add(new HotelManagePane(stage, pane));
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            checkDetailBtn.setOnAction(event -> {
                selectedIndex = getTableRow().getIndex();

                HotelVO hotelVO = (HotelVO) hotelList.getItems().get(selectedIndex);
                pane.getChildren().remove(0);
                pane.getChildren().add(new CheckHotelInfoPane(pane, hotelVO.hotelID));
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
                btnBox.getChildren().add(checkDetailBtn);
                setGraphic(btnBox);
                setText(null);
            }
        }


        public int getSelectedIndex() {
            return selectedIndex;
        }
    }


    /**
     * 确认修改酒店信息
     */
    @FXML
    private void confirmModify() {
        HotelVO hotelVO = (HotelVO) hotelList.getItems().get(webManHotelListButtonCell.getSelectedIndex());

        hotelVO.hotelName = hotelnameinput.getText();
        hotelVO.address = cityCB.getValue().toString();
        hotelVO.tradingArea = tracingareaCB.getValue().toString();
        hotelVO.star = Integer.parseInt(star.getValue().toString());

        try {
            ResultMessage resultMessage = hotelBlService.updateBasicHotelInfo(hotelVO);

            if (resultMessage == ResultMessage.Success) {
                System.out.println("update success");

                hotelList.setPrefHeight(400);
                editBox.setVisible(false);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消修改酒店信息
     */
    @FXML
    private void cancelModify() {
        hotelList.setPrefHeight(400);
        editBox.setVisible(false);
    }
}





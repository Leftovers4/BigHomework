package presentation.util.buttoncell;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import presentation.util.alert.AlertController;
import vo.hotel.HotelVO;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/12/19.
 * description: 网站管理人员管理酒店工作人员时，列表里加上工作人员所属酒店信息
 */
public class HotelNameCell extends TableCell<HotelVO, Boolean> {

    private long hotelID;
    private TableView tableView;

    public HotelNameCell(final TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            PersonnelVO personnelVO = (PersonnelVO) tableView.getItems().get(getTableRow().getIndex());
            hotelID = personnelVO.hotelID;
            try {
                HotelBLService hotelBLService = new HotelBlServiceImpl();
                HotelVO hotelVO = hotelBLService.viewBasicHotelInfo(hotelID);

                setGraphic(null);
                setText(hotelVO.hotelName);
            } catch (RemoteException e) {
                AlertController alertController = new AlertController();
                alertController.showNetConnectAlert();
            }
        }
    }
}

package bl.hotelbl;

import po.hotel.HotelPO;
import po.personnel.PersonnelPO;
import vo.hotel.HotelVO;

/**
 * Created by kevin on 2016/11/25.
 */
public class VoHelper {

    public HotelVO create(HotelPO hotelPO, PersonnelPO personnelPO, double rating) {
        HotelVO res;

        res = new HotelVO(hotelPO.getHotelID(), hotelPO.getHotelName(), personnelPO.getName(), hotelPO.getStar(),
                rating, hotelPO.getAddress(), hotelPO.getTradingArea(), hotelPO.getDescription(), hotelPO.getService());

        return res;
    }

}

package bl.hotelbl.impl;

import vo.hotel.HotelVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelList {

    private List<HotelVO> hotelVOs;

    public HotelList(){
        hotelVOs = new ArrayList<>();
    }

    public HotelList(List<HotelVO> hotelVOs){
        this.hotelVOs = hotelVOs;
    }

    public void sort(String key, int mode){
        int hotelVONum = hotelVOs.size();

        for (int i = 0; i < hotelVONum - 1; i++) {
            int chosenKeyValueIndex = 0;
            double chosenKeyValue = getSortKeyValue(hotelVOs.get(0), key);

            for (int j = 1; j < hotelVONum - i; j++) {
                double keyValue = getSortKeyValue(hotelVOs.get(j), key);

                boolean compareValue = mode == 0 ? chosenKeyValue < keyValue : chosenKeyValue > keyValue;

                if (compareValue == true){
                    chosenKeyValueIndex = j;
                    chosenKeyValue = keyValue;
                }
            }

            HotelVO tempHotelVO = hotelVOs.get(chosenKeyValueIndex);
            hotelVOs.remove(chosenKeyValueIndex);
            hotelVOs.add(hotelVONum - 1 - i, tempHotelVO);
        }
    }

    private double getSortKeyValue(HotelVO hotelVO, String key){
        switch (key){
            case "price":
                return hotelVO.price;
            case "star":
                return hotelVO.star;
            case "rating":
                return hotelVO.rating;
        }
        return 0;
    }

}

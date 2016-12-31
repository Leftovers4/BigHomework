package bl.hotelbl.impl;

import vo.hotel.HotelVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/2.
 */
public class HotelVOList extends ArrayList<HotelVO>{

    /**
     * Instantiates a new Hotel vo list.
     *
     * @param hotelVOList the hotel vo list
     */
    public HotelVOList(List<HotelVO> hotelVOList){
        for (int i = 0; i < hotelVOList.size(); i++) {
            this.add(hotelVOList.get(i));
        }
    }

    /**
     * Sort.
     *
     * @param key  the key
     * @param mode the mode
     */
    public void sort(String key, int mode){
        int hotelVONum = this.size();

        for (int i = 0; i < hotelVONum - 1; i++) {
            int chosenKeyValueIndex = 0;
            double chosenKeyValue = getSortKeyValue(this.get(0), key);

            for (int j = 1; j < hotelVONum - i; j++) {
                double keyValue = getSortKeyValue(this.get(j), key);

                boolean compareValue = mode == 0 ? chosenKeyValue < keyValue : chosenKeyValue > keyValue;

                if (compareValue == true){
                    chosenKeyValueIndex = j;
                    chosenKeyValue = keyValue;
                }
            }

            HotelVO tempHotelVO = this.get(chosenKeyValueIndex);
            this.remove(chosenKeyValueIndex);
            this.add(hotelVONum - 1 - i, tempHotelVO);
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

package bl.orderbl.impl;

import bl.hotelbl.impl.Timeline;
import po.order.OrderPO;
import util.RoomType;
import util.TableName;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderList extends ArrayList<OrderPO>{

    /**
     * Instantiates a new Order list.
     *
     * @param orderPOList the order po list
     */
    public OrderList(List<OrderPO> orderPOList){
        for (int i = 0; i < orderPOList.size(); i++) {
            this.add(orderPOList.get(i));
        }
        sortByTime();
    }

    /**
     * Get hotel rating double.
     *
     * @return the double
     */
    public double getHotelRating(){
        double sum = 0;

        for (OrderPO orderPO : this) {
            sum += orderPO.getReviewPO().getRating();
        }

        sum = this.size() == 0 ? sum : sum / this.size();

        return Math.round(sum * 100) / 100;
    }

    /**
     * Filter by different hotels order list.
     *
     * @return the order list
     */
    public OrderList filterByDifferentHotels(){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            boolean same = false;

            for (int j = 0; j < res.size(); j++) {
                if (this.get(i).getHotelID() == res.get(j).getHotelID()){
                    same = true;
                    break;
                }
            }

            if (!same)
                res.add(this.get(i));
        }

        return res;
    }

    /**
     * Filter by has review order list.
     *
     * @return the order list
     */
    public OrderList filterByHasReview(){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (new Order(this.get(i)).hasReview()) {
                res.add(this.get(i));
            }
        }

        return res;
    }

    /**
     * Filter by rating order list.
     *
     * @param rating the rating
     * @return the order list
     */
    public OrderList filterByRating(int rating){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getReviewPO().getRating() == rating){
                res.add(this.get(i));
            }
        }

        return res;
    }

    /**
     * Filter by room type order list.
     *
     * @param roomType the room type
     * @return the order list
     */
    public OrderList filterByRoomType(RoomType roomType){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getRoomType().equals(roomType)){
                res.add(this.get(i));
            }
        }

        return res;
    }

    /**
     * Filter by is not overdue order list.
     *
     * @return the order list
     */
    public OrderList filterByIsNotOverdue(){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (!new Order(this.get(i)).isOverdue()){
                res.add(this.get(i));
            }
        }

        return res;
    }

    /**
     * Fill timeline.
     *
     * @param timeline the timeline
     */
    public void fillTimeline(Timeline timeline){
        for (int i = 0; i < this.size(); i++) {
            timeline.addPeriod(new Order(this.get(i)).getOrderedPeriod(), this.get(i).getRoomAmount());
        }
    }

    /**
     * Sort by time order list.
     *
     * @return the order list
     */
    public OrderList sortByTime(){
        int num = this.size();

        for (int i = 0; i < num - 1; i++) {
            int chosenKeyValueIndex = 0;
            LocalDateTime chosenKeyValue = this.get(0).getOrderTimePO().getGenerateTime();

            for (int j = 1; j < num - i; j++) {
                LocalDateTime keyValue = this.get(j).getOrderTimePO().getGenerateTime();

                boolean compareValue = chosenKeyValue.isAfter(keyValue);

                if (compareValue == true){
                    chosenKeyValueIndex = j;
                    chosenKeyValue = keyValue;
                }
            }

            OrderPO tempOrderPO = this.get(chosenKeyValueIndex);
            this.remove(chosenKeyValueIndex);
            this.add(num - 1 - i, tempOrderPO);
        }

        return this;
    }

}

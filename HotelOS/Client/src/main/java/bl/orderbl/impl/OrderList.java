package bl.orderbl.impl;

import po.order.OrderPO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderList extends ArrayList<OrderPO>{

    public OrderList(List<OrderPO> orderPOList){
        for (int i = 0; i < orderPOList.size(); i++) {
            this.add(orderPOList.get(i));
        }
    }

    public double getHotelRating(){
        double sum = 0;

        for (OrderPO orderPO : this) {
            sum += orderPO.getReviewPO().getRating();
        }

        sum = this.size() == 0 ? sum : sum / this.size();

        return sum;
    }

    public OrderList filterByHasReview(){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (new Order(this.get(i)).hasReview()) {
                res.add(this.get(i));
            }
        }

        return res;
    }

    public OrderList filterByRating(int rating){
        OrderList res = new OrderList(new ArrayList<>());

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getReviewPO().getRating() == rating){
                res.add(this.get(i));
            }
        }

        return res;
    }

    //todo
    public int getHotelAvailabeRoomAmount(LocalDate localDate){
        return 0;
    }

}

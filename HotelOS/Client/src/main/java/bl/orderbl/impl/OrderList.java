package bl.orderbl.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderList extends ArrayList<Order>{

    public double getRating(){
        double sum = 0;

        for (Order order : this) {
            sum += order.getRating();
        }

        return sum /= this.size();
    }

}

package thread;

import data.dao.orderdata.OrderDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;
import main.Launcher;
import po.order.OrderPO;
import util.OrderType;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Hiki on 12/6/2016.
 * Description: 每隔五分钟查看数据库中所有未执行订单的最晚执行时间，如果超出最晚执行时间，自动置为异常订单，且扣除用户等于订单的总价值的信用值
 */
public class AbnormalOrderAutoChanger implements Runnable {

    private OrderDataService orderDataService;

    public AbnormalOrderAutoChanger(){
        orderDataService = new OrderDataServiceImpl();
    }


    @Override
    public void run() {
        while (Launcher.isRunning()) {
            try {
                // 在数据库中取出所有的未执行订单
                ArrayList<OrderPO> orderPOs = orderDataService.findByType(OrderType.Unexecuted);
                // 对每个选中的订单：
                for (OrderPO each : orderPOs) {
                    if (each.getOrderTimePO() != null && each.getOrderTimePO().getLastExecuteTime() != null) {
                        // 比较当前时间与最晚执行时间
                        if (LocalDateTime.now().isAfter(each.getOrderTimePO().getLastExecuteTime())) {
                            // 将订单置为异常订单
                            each.setOrderType(OrderType.Abnormal);
                            // 在数据库中更新订单
                            orderDataService.update(each);
                        }
                    }
                }

                // 设置为一分钟检查一次
                Thread.sleep(60000);

                System.out.println("Thread running...");

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }


}

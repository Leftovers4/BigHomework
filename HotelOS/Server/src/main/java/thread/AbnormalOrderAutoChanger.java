package thread;

import data.dao.orderdata.OrderDataServiceImpl;
import data.dao.userdata.UserDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserDataService;
import main.Launcher;
import po.order.OrderPO;
import po.user.CreditRecordPO;
import util.CreditChangedCause;
import util.IDProducer;
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

    private UserDataService userDataService;

    public AbnormalOrderAutoChanger(){
        orderDataService = new OrderDataServiceImpl();
        userDataService = new UserDataServiceImpl();
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

                            // 改变用户信用值
                            substractCredit(each);
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



    private void substractCredit(OrderPO orderPO) {
        // 取出用户名
        String username = orderPO.getUsername();
        // 取出订单ID
        String orderID = orderPO.getOrderID();
        // 取出订单实际价格
        double price = orderPO.getOrderPricePO().getActualPrice();
        // 获取用户当前记录
        ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();
        try {
            creditRecordPOs = userDataService.findCreditRecordsByUsername(username);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // 获取用户当前信用值
        double currentCredit = creditRecordPOs.get(creditRecordPOs.size()-1).getCurrentCredit();


        // 构造用户信用记录
        CreditRecordPO creditRecordPO = new CreditRecordPO();
        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(LocalDateTime.now());
        creditRecordPO.setUsername(username);
        creditRecordPO.setCreditChangedCause(CreditChangedCause.AbnormalOrder);
        creditRecordPO.setOrderID(orderID);
        creditRecordPO.setChangedCredit(-price);
        creditRecordPO.setCurrentCredit(currentCredit - price);

        // 增加用户信用记录
        try {
            userDataService.insertCreditRecord(creditRecordPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


}

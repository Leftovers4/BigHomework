package bl.userbl.impl;

import bl.promotionbl.impl.Context;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import rmi.RemoteHelper;
import util.Const;
import util.IDProducer;
import util.PromotionType;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/3.
 */
public class CreditRecordList extends ArrayList<CreditRecordPO> {

    public CreditRecordList(List<CreditRecordPO> creditRecordPOList){
        for (int i = 0; i < creditRecordPOList.size(); i++) {
            this.add(creditRecordPOList.get(i));
        }
        sortByTime();
    }

    public int getLevel() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException {
        List<PromotionPO> promotionPOList = RemoteHelper.getInstance().getPromotionDAO().findByHotelIDAndType(IDProducer.produceHotelIDForWP(), PromotionType.UserLevelPromotion);

        //没有等级策略的情况
        if (promotionPOList.isEmpty())
            return 0;

        //有等级策略的情况
        return new Context(promotionPOList.get(0)).getLevel(getCurrentCredit());
    }

    public double getCurrentCredit(){
        //表为空的情况
        if (this.size() == 0)
            return 0;

        //表不为空的情况
        double res = this.get(0).getCurrentCredit();
        LocalDateTime changedTime = this.get(0).getChangedTime();

        for (CreditRecordPO creditRecordPO : this) {
            if (creditRecordPO.getChangedTime().isAfter(changedTime)){
                res = creditRecordPO.getCurrentCredit();
                changedTime = creditRecordPO.getChangedTime();
            }
        }

        return res;
    }

    public CreditRecordList sortByTime(){
        int num = this.size();

        for (int i = 0; i < num - 1; i++) {
            int chosenKeyValueIndex = 0;
            LocalDateTime chosenKeyValue = this.get(0).getChangedTime();

            for (int j = 1; j < num - i; j++) {
                LocalDateTime keyValue = this.get(j).getChangedTime();

                boolean compareValue = chosenKeyValue.isAfter(keyValue);

                if (compareValue == true){
                    chosenKeyValueIndex = j;
                    chosenKeyValue = keyValue;
                }
            }

            CreditRecordPO tempCreditRecordPO = this.get(chosenKeyValueIndex);
            this.remove(chosenKeyValueIndex);
            this.add(num - 1 - i, tempCreditRecordPO);
        }

        return this;
    }

    public boolean canAddOrder(){
        return (getCurrentCredit() >= Const.AddOrderThreshold);
    }

    public boolean canRegisterMember(){
        return (getCurrentCredit() >= Const.MemberRegisterThreshold);
    }

}

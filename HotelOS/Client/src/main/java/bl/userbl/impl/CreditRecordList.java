package bl.userbl.impl;

import po.user.CreditRecordPO;

import java.lang.reflect.InvocationTargetException;
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
    }

    public int getLevel() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
       //todo return new PromotionData().findUserLevelPromotion().getLevel(getCurrentCredit());
        return 0;
    }

    public double getCurrentCredit(){
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

}

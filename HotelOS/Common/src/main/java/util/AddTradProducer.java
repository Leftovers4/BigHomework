package util;

import java.util.*;

/**
 * Created by Hiki on 2016/12/11.
 */
public class AddTradProducer {

    // 地址（城市）与商圈的对应关系
    private final static Map<String, ArrayList<String>> AddressToTradingArea = new HashMap<>();

    // 初始化Map表
    static{
        AddressToTradingArea.put("南京市", strsToList("珠江路商圈", "新街口商圈", "江东门商圈", "江北商圈", "夫子庙商圈", "河西商圈", "仙林商圈", "山西路商圈"));
        AddressToTradingArea.put("杭州市", strsToList("城北商圈", "吴山商圈", "武林商圈", "滨江商圈"));
        AddressToTradingArea.put("上海市", strsToList("淮海路商圈", "徐家汇商圈", "浦东商圈", "五角场商圈", "南京路商圈"));
        AddressToTradingArea.put("广州市", strsToList("珠江新城商圈", "东山商圈", "北京路商圈", "小北商圈", "番禺大北路商圈", "天河商圈", "流花商圈", "西关商圈"));
        AddressToTradingArea.put("北京市", strsToList("望京商圈", "北苑商圈", "回龙观商圈", "天通苑商圈", "朝青商圈", "亦庄商圈", "清河商圈", "亚运村商圈", "黄村北商圈"));

    }

    /**
     * 返回所有的地址
     * @return
     */
    public static Iterator<String> getAllAddress(){

        return AddressToTradingArea.keySet().iterator();

    }

    /**
     * 根据地址取得相应的商圈列表，若地址不存在，返回空的迭代器
     * @param address
     * @return
     */
    public static Iterator<String> getTradingAreasByAddress(String address){

        ArrayList<String> noOutput = new ArrayList<>();

        if(AddressToTradingArea.get(address) == null){
            return noOutput.iterator();
        }

        return AddressToTradingArea.get(address).iterator();

    }



    /**
     * 辅助方法，用于将strings转成ArrayList<String>
     * @param parameters
     * @return
     */
    private static ArrayList<String> strsToList(String... parameters){

        // 获取strings参数的个数
        int n = parameters.length;

        ArrayList<String> result = new ArrayList<String>();

        for(int i = 0; i < n; i++){
            result.add(parameters[i]);
        }

        return result;
    }
}

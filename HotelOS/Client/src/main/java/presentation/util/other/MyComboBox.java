package presentation.util.other;

import javafx.scene.control.ComboBox;
import util.AddTradProducer;

import java.time.LocalTime;
import java.util.Iterator;

/**
 * Created by Hitiger on 2016/12/11.
 * Description :
 */
public class MyComboBox {

    public static void initHourBox(ComboBox comboBox){
        for (int i = 0; i < 24; i++){
            comboBox.getItems().add(i);
        }
        comboBox.setValue(LocalTime.now().getHour());
    }

    public static void initMinBox(ComboBox comboBox){
        for (int i = 0; i < 60; i++){
            comboBox.getItems().add(i);
        }
        comboBox.setValue(LocalTime.now().getMinute());
    }

    public static void initAreaBox(ComboBox cityBox, ComboBox areaBox){
        cityBox.getItems().clear();
        Iterator<String> cityList = AddTradProducer.getAllAddress();
        while (cityList.hasNext()){
            cityBox.getItems().add(cityList.next());
        }
        cityBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) ->{
                    areaBox.getItems().clear();
                    String area = "";
                    Iterator<String> areaList = AddTradProducer.getTradingAreasByAddress(newValue.toString());
                    while (areaList.hasNext()){
                        if (area == ""){
                            area = areaList.next();
                            areaBox.getItems().add(area);
                        } else areaBox.getItems().add(areaList.next());
                    }

                    areaBox.setValue(area);
                }
        );
    }
}

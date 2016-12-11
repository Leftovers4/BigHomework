package presentation.util.other;

import javafx.scene.control.ComboBox;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
}

package presentation.util.other;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.util.alert.AlertController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hitiger on 2016/12/13.
 * Description :
 */
public class JudgeInput {

    public static Boolean judgeDiscount(TextField textField){
        AlertController alertController = new AlertController();
        Pattern pattern = Pattern.compile("^[0-9].*$");
        Matcher matcher = pattern.matcher(textField.getText());
        if(matcher.matches()){
            double discount = Double.parseDouble(textField.getText());
            if(discount >= 1) {
                alertController.showInputWrongAlert("折扣必须小于1，请重新输入","格式错误");
                return false;
            }
        }else {
            alertController.showInputWrongAlert("折扣应输入小数","格式错误");
            return false;
        }
        return true;
    }

    public static boolean judgePhoneNumber(String str) {
        boolean judge = true;

        int length = str.length();
        if (length != 11) {
            judge = false;
        }

        for(int i = 0; i<length; i++) {
            int temp = str.charAt(i) - '0';
            if (temp >= 0 && temp <= 9) {
                judge = judge && true;
            } else {
                judge = judge && false;
            }
        }
        return judge;
    }

    public static boolean judgeDateSeq(LocalDateTime start, LocalDateTime end){
        AlertController alertController = new AlertController();
        if(start.isAfter(end)) {
            alertController.showInputWrongAlert("开始日期需要小于结束日期，请重新输入","格式错误");
            return false;
        }
        return true;
    }
}

package presentation.util.other;

import javafx.scene.control.TextField;
import presentation.util.alert.AlertController;

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
            if(discount > 1) {
                alertController.showInputWrongAlert("折扣不能大于1，请重新输入","格式错误");
                return false;
            }
        }else {
            alertController.showInputWrongAlert("折扣应输入小数","格式错误");
            return false;
        }
        return true;
    }
}

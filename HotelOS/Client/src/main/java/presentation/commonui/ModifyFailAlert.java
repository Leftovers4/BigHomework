package presentation.commonui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Hitiger on 2016/11/25.
 * Description :
 */
public class ModifyFailAlert extends Alert{

    public ModifyFailAlert(){
        this(AlertType.ERROR,"您的信息填写不完整",ButtonType.OK);
    }

    public ModifyFailAlert(AlertType alertType, String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
        this.setHeaderText("");
        this.setTitle("修改失败");
    }
}

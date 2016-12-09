package presentation.util.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

/**
 * Created by Hitiger on 2016/12/9.
 * Description : 更新信息成功提示框
 */
public class UpdateSuccessAlert extends Alert{
    public UpdateSuccessAlert(String contentText,String title){
        this(AlertType.INFORMATION,contentText, ButtonType.OK);
        this.setTitle(title);
        this.setHeaderText("");
        this.initStyle(StageStyle.UTILITY);
    }

    public UpdateSuccessAlert(AlertType alertType, String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
    }
}

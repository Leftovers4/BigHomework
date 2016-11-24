package presentation.commonui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Hitiger on 2016/11/25.
 * Description :
 */
public class ExitAlert extends Alert{
    public ExitAlert(){
        this(AlertType.CONFIRMATION,"您确定要退出系统吗",ButtonType.OK,ButtonType.CANCEL);
    }
    public ExitAlert(AlertType alertType, String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
        this.setHeaderText("");
        this.setTitle("确认退出") ;
        this.initStyle(StageStyle.UTILITY);
    }
}

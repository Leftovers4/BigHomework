package presentation.util.alert;

import javafx.scene.control.ButtonType;

/**
 * Created by Hitiger on 2016/11/26.
 * Description : 各种提示框的控制器，供界面调用
 */
public class AlertController {

    /**
     * 确认取消编辑信息提示框
     * @return
     */
    public Boolean showConfirmCancelAlert(){
        ConfirmAlert confirmAlert = new ConfirmAlert("您确定要取消编辑信息吗？","确认取消");
        confirmAlert.showAndWait();
        final ButtonType rtn = confirmAlert.getResult();
        if (rtn == ButtonType.OK) {
            return true;
        }
        return false;
    }

    /**
     * 确认退出系统提示框
     * @return
     */
    public Boolean showConfirmExitAlert(){
        ConfirmAlert confirmAlert = new ConfirmAlert("您确定要退出系统吗？","确认退出");
        confirmAlert.showAndWait();
        final ButtonType rtn = confirmAlert.getResult();
        if (rtn == ButtonType.OK) {
            return true;
        }
        return false;
    }

    /**
     * 没有选择提示框
     * @param contentText 提示内容
     * @param title       提示标题
     */
    public void showUnSelectItemAlert(String contentText, String title) {
        UnselectedAlert unselectedAlert = new UnselectedAlert(contentText,title);
        unselectedAlert.showAndWait();
    }

    /**
     * 确认删除提示框
     * @param contentText 提示内容
     * @param title       提示标题
     * @return
     */
    public Boolean showConfirmDeleteAlert(String contentText, String title){
        ConfirmAlert confirmAlert = new ConfirmAlert(contentText,title);
        confirmAlert.showAndWait();
        final ButtonType rtn = confirmAlert.getResult();
        if (rtn == ButtonType.OK) {
            return true;
        }
        return false;
    }

    /**
     * 输入错误提示框
     * @param contentText 提示内容
     * @param title       提示标题
     */
    public void showInputWrongAlert(String contentText, String title){
        InputWrongAlert inputWrongAlert = new InputWrongAlert(contentText,title);
        inputWrongAlert.showAndWait();
    }
}

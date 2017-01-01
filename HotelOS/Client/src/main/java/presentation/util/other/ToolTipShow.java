package presentation.util.other;

import javafx.scene.control.Tooltip;

/**
 * Created by wyj on 2016/12/16.
 * description : 各种按钮鼠标悬停时显示的的提示语
 */
public class ToolTipShow {

    public static Tooltip setTool (String content) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText(content);
        return tooltip;
    }
}

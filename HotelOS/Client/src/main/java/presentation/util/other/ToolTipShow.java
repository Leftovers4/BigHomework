package presentation.util.other;

import javafx.scene.control.Tooltip;

/**
 * Created by wyj on 2016/12/16.
 */
public class ToolTipShow {

    public static Tooltip setTool (String content) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText(content);
        return tooltip;
    }
}

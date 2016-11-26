package presentation.util;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/16.
 * Description : 实现窗口可拖动
 */
public class EnableWindowDrag {

    private double xOffset = 0;
    private double yOffset = 0;
    /**
     * 实现窗口可拖动
     * @param root
     * @param primaryStage
     */
    public EnableWindowDrag(Parent root, Stage primaryStage) {
        root.setOnMousePressed((MouseEvent event) -> {
            event.consume();
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            event.consume();
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }
}

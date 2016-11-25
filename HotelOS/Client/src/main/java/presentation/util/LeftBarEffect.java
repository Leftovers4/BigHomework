package presentation.util;

import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Created by wyj on 2016/11/25.
 * Description: 左边栏按钮的各种效果
 */
public class LeftBarEffect {

    /**
     * 鼠标点击按钮背景颜色效果
     * @param button
     */
    public void buttonActionEffect(Button button, ArrayList<Button> leftBarBtnArr) {
        for(int i = 0; i<leftBarBtnArr.size(); i++) {
            if (button != leftBarBtnArr.get(i)) {
                leftBarBtnArr.get(i).setStyle("-fx-background-color: transparent");
            } else {
                button.setStyle("-fx-background-color: #0F81C7");
            }
        }
    }

    /**
     * 鼠标悬停按钮背景颜色效果
     * @param button
     */
    public void buttonMouseOnEffect(Button button, ArrayList<Button> leftBarBtnArr, Button currentBtn) {
        button.setStyle("-fx-background-color: deepskyblue");
        for (int i = 0; i<leftBarBtnArr.size(); i++) {
            Button tempBtn = leftBarBtnArr.get(i);
            if (tempBtn != button) {
                if (tempBtn != currentBtn) {
                    tempBtn.setStyle("-fx-background-color: transparent");
                } else {
                    tempBtn.setStyle("-fx-background-color: #0F81C7");
                }
            }
        }
    }

    /**
     * 鼠标移出按钮，按钮背景颜色效果
     * @param button
     */
    public void buttonMouseOutEffect(Button button, Button currentBtn) {
        button.setStyle("-fx-background-color: transparent");
        if (currentBtn != null) {
            currentBtn.setStyle("-fx-background-color: #0F81C7");
        }
    }
}

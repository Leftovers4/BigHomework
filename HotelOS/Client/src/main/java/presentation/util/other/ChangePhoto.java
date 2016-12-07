package presentation.util.other;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by wyj on 2016/12/4.
 * Description: 用户更换图片的方法
 */
public class ChangePhoto {

    public static void updatePhoto(ImageView imageView, String photoPath) {
        Image image = new Image("file:///" + photoPath);
        imageView.setImage(image);
    }
}

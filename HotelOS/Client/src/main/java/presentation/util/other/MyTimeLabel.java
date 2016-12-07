package presentation.util.other;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Hitiger on 2016/12/2.
 * Description :
 */
public class MyTimeLabel {
    public static void EnableShowTime(Label label){
        DateFormat timeFormat = new SimpleDateFormat( "YYYY-MM-dd HH:mm:ss" );
        final Timeline timeline = new Timeline( new KeyFrame( Duration.millis( 500 ), event -> {
            label.setText( timeFormat.format( System.currentTimeMillis() ) );
        }));
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }
}

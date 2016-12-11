package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import thread.AbnormalOrderAutoChanger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kevin on 2016/11/16.
 */
public class Launcher extends Application{

    @FXML private Button launchBtn;
    @FXML private Button stopBtn;

    private RemoteHelper remoteHelper;

    private static boolean running;

    private ExecutorService executorService;



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/server.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Leftovers服务器");
        primaryStage.setResizable(false);
        primaryStage.show();

        //将进程关闭
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    @FXML
    private void launchServer() {
        // 将开启按钮设为不可点击,停止按钮可点击
        launchBtn.setDisable(true);
        stopBtn.setDisable(false);

        // 改变服务器状态
        running = true;

        // 启动rmi连接
        (remoteHelper = RemoteHelper.getInstance()).run();

        // 开启线程监控订单状态（超时自动置为异常订单）
        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new AbnormalOrderAutoChanger());

    }

    @FXML
    private void stopServer() {
        remoteHelper.stop();
        running = false;
        launchBtn.setDisable(false);
        stopBtn.setDisable(true);

    }


    public static boolean isRunning() {
        return running;
    }





}

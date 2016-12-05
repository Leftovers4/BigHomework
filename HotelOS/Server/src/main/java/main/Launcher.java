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

import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/11/16.
 */
public class Launcher extends Application{

    @FXML private Button launchBtn;

    private RemoteHelper remoteHelper;

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
    }

    @FXML
    private void launchServer() {
        launchBtn.setDisable(true);
//        (remoteHelper = new RemoteHelper()).run();
    }

    @FXML
    private void stopServer() {
//        Platform.exit();
//        remoteHelper.stop();

    }








}

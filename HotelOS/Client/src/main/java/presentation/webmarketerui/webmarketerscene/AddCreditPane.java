package presentation.webmarketerui.webmarketerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import presentation.webmarketerui.webmarketercontroller.AddCreditPaneController;
import vo.user.UserVO;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AddCreditPane extends Pane{
    public AddCreditPane(Pane mainPane, UserVO userVO) {
        loadFxml(mainPane, userVO);
    }

    private void loadFxml(Pane mainPane, UserVO userVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/webmarketer/webaddcredit.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddCreditPaneController addCreditPaneController = fxmlLoader.getController();
        addCreditPaneController.launch(mainPane, userVO);
    }
}

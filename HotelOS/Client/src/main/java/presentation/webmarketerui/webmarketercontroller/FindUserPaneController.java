package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.AddCreditPane;
import vo.user.CreditVO;
import vo.user.UserVO;

import java.time.LocalDate;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class FindUserPaneController {
    private Pane mainPane;
    private AlertController alertController;
    public void launch(Pane mainPane){
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    //TODO 更好UserVo
    @FXML
    private void findUser(){
        mainPane.getChildren().remove(0);

        UserVO userVO = new UserVO("网红", "张三", true, LocalDate.of(2016,10,21),"15915651406");
        userVO.creditVO = new CreditVO(1000,null);

        mainPane.getChildren().add(new AddCreditPane(mainPane, userVO));
    }

}

package presentation.justfortest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Hitiger on 2016/11/19.
 * Description :
 */
public class PeopleController implements Initializable{

    @FXML private TableColumn orderIDColumn;
    @FXML private TableColumn userColumn;


    @FXML private TableView tableView;
    private ObservableList<People> getList(){
        ObservableList<People> list = FXCollections.observableArrayList();

        for (int i=0;i<100;i++){
            People people = new People("user",18);
            list.add(people);
        }

        return list;
    }


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.setItems(getList());
    }
}

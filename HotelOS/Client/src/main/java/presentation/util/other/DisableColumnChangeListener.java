package presentation.util.other;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Hitiger on 2016/12/6.
 * Description : 让 tableview 的列表栏 不可交换位置
 */
public class DisableColumnChangeListener implements ListChangeListener {

    private boolean suspended;
    private TableView tableView;
    private TableColumn[] columns;

    public DisableColumnChangeListener(TableView tableView, TableColumn[] columns){
        this.tableView = tableView;
        this.columns = columns;
    }
    @Override
    public void onChanged(Change change) {
        change.next();
        if (change.wasReplaced() && !suspended) {
            this.suspended = true;
            tableView.getColumns().setAll(columns);
            this.suspended = false;
        }
    }
}

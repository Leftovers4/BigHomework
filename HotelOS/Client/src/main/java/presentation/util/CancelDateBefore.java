package presentation.util;


import javafx.util.Callback;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * Created by wyj on 2016/11/26.
 * Description: 在填写订单选择日期时，使得当前日期之前的日期不可选择
 */
public class CancelDateBefore implements Callback<DatePicker, DateCell> {

    private DatePicker datePicker;
    private LocalDate localDate;
    public CancelDateBefore(DatePicker datePicker,LocalDate localDate){
        this.datePicker = datePicker;
        this.localDate = localDate;
    }
    @Override
    public DateCell call(final DatePicker datepicker) {
        return new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item.isBefore(
                        localDate)
                        ) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }

        };
    }
}

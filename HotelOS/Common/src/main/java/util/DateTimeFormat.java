package util;

import java.time.format.DateTimeFormatter;

/**
 * Created by kevin on 2016/12/8.
 */
public class DateTimeFormat {

    public static final String datePattern = "yyyy-MM-dd";

    public static final String dateHourPattern = "yyyy-MM-dd HH:mm";

    public static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter  dateFormat = DateTimeFormatter.ofPattern(datePattern);

    public static final DateTimeFormatter  dateHourFormat = DateTimeFormatter.ofPattern(dateHourPattern);

    public static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(dateTimePattern);

}

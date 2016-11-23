package data.dao._poalfactory.impl;

import javax.print.attribute.standard.Chromaticity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

/**
 * Created by Hiki on 11/23/2016.
 */
public class Lot {


    public static void main(String[] args){
        LocalDateTime a = LocalDateTime.now();

        DateTimeFormatter FDW = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS");

//        LocalDateTime c = LocalDateTime.parse("2016-11-23 09:12:07", FDW);

        String b = a.toString();

        System.out.println(b);

        System.out.println(a);

      //  System.out.println(c.toString());


        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
     //  LocalDateTime dateTime2 = LocalDateTime.parse("2012-12-21 23:22:45", format);
      //  System.out.println(dateTime2);
        LocalDateTime qingming = LocalDateTime.of(2015, 4, 5, 12, 30, 30, 30);
        System.out.println(qingming);

        LocalDateTime qingmingParsed = LocalDateTime.parse("2015/04/05 12:30:30", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

        System.out.println(qingmingParsed.toString());







    }

}

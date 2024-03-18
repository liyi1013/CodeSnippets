package TestJava.basic;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class dateTime {

    public static void main(String[] args) throws ParseException {
//        System.out.println("Hello World!");
//
//        //格式化，转当地时区时间
//
//        converDateFormat("2017-11-27T03:16:03Z");
//
//        System.out.println(getShiftDatetime(0));


//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        System.out.println(now.toEpochSecond(ZoneOffset.of("+8")));
//
//        long timestamp = now.toEpochSecond(ZoneOffset.of("+8"));
//        long instant = (timestamp / 10) * 10;
//        System.out.println(instant);
//        System.out.println(LocalDateTime.ofEpochSecond(instant, 1, ZoneOffset.of("+8")).getSecond());
//        System.out.println(LocalDateTime.ofEpochSecond(instant, 0, ZoneOffset.of("+8")).getSecond());
//
////        String[] ss= LocalDateTime.ofEpochSecond(instant,1,ZoneOffset.of("+8")).minusSeconds(600).toString().split(".");
//
//        DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        System.out.println(dfDateTime.format(now));
//        System.out.println(now.getSecond());
//
//        test2datetime();


        System.out.println(converDateFormat2("2017-11-27T03:16:03Z"));

    }

    // 时间转换
    private static String converDateFormat(String UTCtime) throws ParseException {
        //Z代表UTC统一时间:2017-11-27T03:16:03.944Z
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        SimpleDateFormat dayformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        //格式化，转当地时区时间
        Date after = format.parse(UTCtime);

        System.out.println(dayformat.format(after));
        return dayformat.format(after);
    }


    //

    /**
     * 时间转换2 （ZonedDateTime ， 推荐）
     * ZonedDateTime是Java 8中引入的一个不可变且线程安全的数据类型，用于表示带有时区的日期和时间。
     * 与LocalDateTime相比，ZonedDateTime可以存储时区信息，并能够处理模糊的本地日期时间。
     *
     * @param UTCtime
     * @return
     * @throws ParseException
     */
    private static String converDateFormat2(String UTCtime) throws ParseException {
        //Z代表UTC统一时间:2017-11-27T03:16:03.944Z
        DateTimeFormatter originFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC+0"));
        DateTimeFormatter targetFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC+8"));

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(UTCtime, originFmt);
//        System.out.println(zonedDateTime);
//        System.out.println(zonedDateTime.format(fmt2));

        // X  不能转换时区
        // LocalDateTime localDateTime = LocalDateTime.parse(UTCtime,originFmt);
        // System.out.println(localDateTime.format(fmt2));
        return zonedDateTime.format(targetFmt);
    }

    // 获取差异时间,使用 java.time.LocalDateTime;
    private static LocalDateTime getShiftDatetime(int diffSecond) {
        if (diffSecond == 0) {
            return LocalDateTime.now();
        }
        if (diffSecond > 0) {
            return LocalDateTime.now().plusSeconds(diffSecond);
        } else {
            return LocalDateTime.now().minusSeconds(-diffSecond);
        }
    }


    /**
     * 比较LocalDateTime和Date2种时间类。推荐使用LocalDateTime
     */
    private static void test2datetime() {
        System.out.println("test LocalDateTime");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now());
        System.out.println(fmt.format(LocalDateTime.now()));

        System.out.println("test Date");
        DateFormat sfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(new Date());
        System.out.println(sfmt.format(new Date()));
    }

}
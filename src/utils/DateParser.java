package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class parses Date objects using specific patterns.
 * @author Adrián Leyva Sánchez
 */
public class DateParser {
    public static final String DATE_PATTERN = "yyyy/MM/dd";
    public static final String DATE_PATTERN_V2 = "EEE, MMM d, ''yy";
    public static final String TIME_PATTERN = "HH:MM:ss";


    public static String parseCurrentDateTimeFormat(String pattern){
        Date today;
        SimpleDateFormat formatter;
        String output;

        Locale locale = Locale.US;

        formatter = new SimpleDateFormat(pattern, locale);
        today = new Date();
        output = formatter.format(today);

        return output;
    }

    public static String parseDateTimeFormat(String pattern, Date date){
        Date today;
        SimpleDateFormat formatter;
        String output;

        Locale locale = Locale.US;

        formatter = new SimpleDateFormat(pattern, locale);
        today = date;
        output = formatter.format(today);

        return output;
    }
}

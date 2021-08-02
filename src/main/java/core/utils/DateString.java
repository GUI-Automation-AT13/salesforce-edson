package core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for obtains a date as a String.
 */
public class DateString {

    /**
     * Gets the current date to transform a String.
     *
     * @return String a current with the established format.
     */
    public String dateToString() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(" dd/M/yyyy HH:mm:ss");
        return df.format(date);
    }
}

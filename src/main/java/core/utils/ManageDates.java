package core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class return different dates.
 */
public class ManageDates {
    private Calendar calendar;

    /**
     * Main for check the correct functions of this class.
     *
     * @param args for main.
     */
    public static void main(String[] args) {
        ManageDates date = new ManageDates();
        List<String> requirements = List.of("TODAY", "YESTERDAY", "TOMORROW", "2 days ago",
                "15 minutes from now", "6 months from now", "3 years ago", "7/13/2020", "1 day ago");
        requirements.stream().forEach(value -> System.out.println(value + " : " + date.dateRequired(value)));
    }

    /**
     * Method for requirement a date with specific String.
     *
     * @param dateString a date String.
     * @return a date.
     */
    public Date dateRequired(String dateString) {
        if (dateString == null) {
            throw new RuntimeException("Incorrect value, the value is null");
        }
        if (dateString.equals("")) {
            throw new RuntimeException("Incorrect value, the value is empty");
        }
        dateString = cleanString(dateString);
        calendar = Calendar.getInstance();
        if (dateString.contains("today")) {
            return formatCalendar(calendar);
        }
        if (dateString.contains("yesterday")) {
            changeDate(dateString, -1);
            return formatCalendar(calendar);
        }
        if (dateString.contains("tomorrow")) {
            changeDate(dateString, 1);
            return formatCalendar(calendar);
        }
        if (dateString.contains("ago")) {
            String []time = dateString.trim().split(" ");
            changeDate(time[1], (Integer.parseInt(time[0])) * -1);
            return formatCalendar(calendar);
        }
        if (dateString.contains("from now")) {
            String []time = dateString.trim().split(" ");
            changeDate(time[1], Integer.parseInt(time[0]));
            return formatCalendar(calendar);
        }
        if (dateString.contains("/")) {
            return changeStringToDate(dateString);
        }
        return null;
    }

    public void changeDate(String time, int amount) {
        calendar.add(EnumDate.valueOf(time).value(), amount);
    }

    /**
     * Parse a Calendar format to Date format.
     *
     * @param calendar a Calendar Object
     * @return a Date object
     */
    public Date formatCalendar(Calendar calendar) {
        DateFormat parser = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Date date;
        try {
            date = parser.parse(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(calendar.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException("The value is not valid");
        }
        return date;
    }

    /**
     * Method simply for change a string date in Date object.
     *
     * @param stringDate a String with the simple date.
     * @return a Date object.
     */
    public Date changeStringToDate(String stringDate) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = parser.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String cleanString(String dateString) {
        dateString = dateString.toLowerCase().trim();
        return dateString;
    }
}

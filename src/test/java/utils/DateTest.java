package utils;

import core.utils.ManageDates;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class DateTest {

    @Test
    public void testTodayDate() {
        ManageDates dates = new ManageDates();
        String value = "TODAY";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        assertEquals(dateResult.getDay(), calendar.getTime().getDay(), "The days is not equals");
    }

    @Test
    public void testYesterdayDate() {
        ManageDates dates = new ManageDates();
        String value = "YESTERDAY";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        assertEquals(dateResult.getDay(), calendar.getTime().getDay(), "The days is not equals");
    }

    @Test
    public void testTomorrowDate() {
        ManageDates dates = new ManageDates();
        String value = "TOMORROW";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        assertEquals(dateResult.getDay(), calendar.getTime().getDay(), "The days is not equals");
    }

    @Test
    public void test2DaysAgoDate() {
        ManageDates dates = new ManageDates();
        String value = "2 days ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.DAY_OF_YEAR, -2);
        assertEquals(dateResult.getDay(), calendar.getTime().getDay(), "The days is not equals");
    }

    @Test
    public void test15MinutesFromNowDate() {
        ManageDates dates = new ManageDates();
        String value = "15 minutes from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.MINUTE, 15);
        assertEquals(dateResult.getMinutes(), calendar.getTime().getMinutes(), "The minutes is not equals");
    }

    @Test
    public void test5MonthsFromNowDate() {
        ManageDates dates = new ManageDates();
        String value = "5 months from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.MONTH, 5);
        assertEquals(dateResult.getMinutes(), calendar.getTime().getMinutes(), "The months is not equals");
    }

    @Test
    public void test3YearsAgoDate() {
        ManageDates dates = new ManageDates();
        String value = "3 years ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.YEAR, -3);
        assertEquals(dateResult.getYear(), calendar.getTime().getYear(), "The years is not equals");
    }

    @Test
    public void testStringDateToDate() throws ParseException {
        ManageDates dates = new ManageDates();
        String value = "7/15/2021";
        Date dateResult = dates.dateRequired(value);
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Date dateExpected = parser.parse(value);
        assertEquals(dateResult, dateExpected, "The date is not equals");
    }

    @Test
    public void test1DayAgoDate() {
        ManageDates dates = new ManageDates();
        String value = "1 day ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.dateRequired(value);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        assertEquals(dateResult.getDay(), calendar.getTime().getDay(), "The days is not equals");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testEmptyStringDate() {
        ManageDates dates = new ManageDates();
        String value = "";
        Date dateResult = dates.dateRequired(value);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testNullValueDate() {
        ManageDates dates = new ManageDates();
        String value = null;
        Date dateResult = dates.dateRequired(value);
    }

    @Test
    public void testInvalidStringDate() {
        ManageDates dates = new ManageDates();
        String value = "data String invalid";
        Date dateResult = dates.dateRequired(value);
        assertEquals(dateResult, null, "Valid data");
    }
}

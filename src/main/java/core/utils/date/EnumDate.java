package core.utils.date;

/**
 * Enum for Calendar object.
 */
public enum EnumDate {
    seconds(13),
    minutes(12),
    hours(11),
    days(6),
    day(6),
    yesterday(6),
    tomorrow(6),
    months(2),
    years(1);

    private int calendarDate;

    EnumDate(int calendarDate) {
        this.calendarDate = calendarDate;
    }

    public int value() {
        return calendarDate;
    }
}

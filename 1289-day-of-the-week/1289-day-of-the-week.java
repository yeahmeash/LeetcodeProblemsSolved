import java.util.Calendar;

public class Solution {

    // Array containing the days of the week for easy reference.
    private static final String[] DAYS_OF_WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    /**
     * Returns the day of the week for a particular date.
     *
     * @param day   The day of the month (1-based).
     * @param month The month of the year (1-based, January is 1).
     * @param year  The year (e.g., 2021).
     * @return The name of the day of the week.
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        // Obtain an instance of Calendar.
        Calendar calendar = Calendar.getInstance();
      
        // Set the calendar to the specified date.
        // The month is zero-based in Calendar, hence the need to subtract 1.
        calendar.set(year, month - 1, day);
      
        // Get the day of the week from the Calendar (1 = Sunday, 7 = Saturday)
        // and adjust by subtracting 1 to align with the index of DAYS_OF_WEEK array.
        int dayOfWeekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
      
        // Return the string representation of the day of the week.
        return DAYS_OF_WEEK[dayOfWeekIndex];
    }
}
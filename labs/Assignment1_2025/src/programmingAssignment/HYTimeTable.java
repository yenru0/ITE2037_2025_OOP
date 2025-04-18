package programmingAssignment;

import java.util.Calendar;
import java.util.Scanner;

public class HYTimeTable {
    Course[][] timeTable;//•	Create a timeTable variable to store the subjects in the students' timetables.
    // This variable is a two-dimensional array and stores objects of the Course class.;

    public enum DAYS {
        // imput days monday to friday
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }

    public HYTimeTable() {
        //•	Create a constructor with no parameters.
        // This constructor initializes all the timeTable arrays and calls the initialize() method.
        timeTable = new Course[11][5];

        initialize();
    }

    private void initialize() {
        //•	Create an Initialize() method. This method can only be accessed within this class and initializes the timetable as follows.
        //1. This array has 5 column (days) and 11 rows (periods).
        //2. All timetables in hour 12 are fixed to LUNCH. Here isValid field of the Course class should be set to false.
        //3. All timetables in hour 17 are fixed to DINNER. Here isValid field of the Course class should be set to false.
        //4. All other time slots are initialized with ----. Here isValid field of the Course class should be set to true.
        for (var i = 0; i < 5; i++) {
            for (var j = 0; j < 11; j++) {
                Course k;
                if (j == 3) {
                    k = new Course(Course.CLASS_LUNCH);
                    k.isValid = false;
                } else if (j == 8) {
                    k = new Course(Course.CLASS_DINNER);
                    k.isValid = false;
                } else {
                    k = new Course(Course.CLASS_BLANK);
                }
                timeTable[j][i] = k;
            }
        }

    }

    public String getSchedule(String day, int period) {
        //•	Create a method called getSchedule(). This method receives DAY and period as arguments,
        // stores the information about the subject in that time period in a String, and returns it.
        if (period < 9 || period > 19) {
            return null;
        }
        return "At that time you have :\n" + timeTable[period - 9][DAYS.valueOf(day).ordinal()].getDetails();
    }

    public boolean setSchedule(String day, int period, String name, String tutor, String room) {
        if (19 >= period && period >= 9 && timeTable[period - 9][DAYS.valueOf(day).ordinal()].isValid) {
            //•	Create a method called setSchedule(). This method receives DAY, period, name, tutor,
            // and room as arguments. This method stores the subject information
            // at the appropriate day and time, ONLY if the time slot is empty.
            // This method returns true on success and false on failure.
            //NOTE: If the user tries to save the subject during LUNCH or DINNER
            // or a time not included between 9 to 19 or an already taken time slot, false is returned.
            timeTable[period - 9][DAYS.valueOf(day).ordinal()] = new Course(name, tutor, room);
            timeTable[period - 9][DAYS.valueOf(day).ordinal()].isValid = false;

            return true;
        } else {
            return false;
        }
    }

    public boolean deleteSchedule(String day, int period) {
        if (19 >= period && period >= 9 && !timeTable[period - 9][DAYS.valueOf(day).ordinal()].isValid) {
            //•	Create a method called deleteSchedule().
            // This method receives DAY, period and deletes the class on that time ONLY
            // if there is a class already recorded, and return true. Otherwise return False.

            timeTable[period - 9][DAYS.valueOf(day).ordinal()] = new Course(Course.CLASS_BLANK);

            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  ");
        //•	Create a method called toString(). This method returns the format for
        // the timetable as a String (SEE DOCUMENTATION).
        for (var s : DAYS.values()) {
            sb.append(String.format("%12s", s.toString()));
        }
        sb.append('\n');

        for (var i = 0; i < 11; i++) {
            sb.append(String.format("%2d", i + 9));
            for (var j = 0; j < 5; j++) {
                sb.append(String.format("%12s", timeTable[i][j].toString()));
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public String oneDaySchedule(String day) {
        StringBuilder sb = new StringBuilder();
        //•	Create a method called oneDaySchedule().
        // This method receives a day of the week as an input and returns
        // the timetable for that day in String format.
        sb.append(day).append('\n');
        for (var i = 0; i < 11; i++) {
            sb.append(timeTable[i][DAYS.valueOf(day).ordinal()].toString()).append('\n');
        }
        return sb.toString();
    }

    public String subjectSchedule(String sub) {
        //•	Create a subjectSchedule() method that receives
        // name of class as input and returns day,
        // period, tutor information as follows
        Course target = null;

        if (sub.equals(Course.CLASS_LUNCH) || sub.equals(Course.CLASS_DINNER)) {
            return "Having a Lunch or Dinner";
        } else if (sub.equals(Course.CLASS_BLANK)) {
            return "Blank Class";
        }

        int day_index = 0;
        int time = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
                if (timeTable[i][j].name.equals(sub)) {
                    target = timeTable[i][j];
                    time = i + 9;
                    day_index = j;
                }
            }
        }
        if (target == null) {
            return null;
        } else {
            return String.format("Subject: %s\nDay: %s\nPeriod: %d\nTutor: %s\nRoom: %s",
                    sub, DAYS.values()[day_index], time, target.professor, target.roomNumber);
        }

    }

    public Calendar setInputDate() {
        Scanner keyboard = new Scanner(System.in);
        //•	Create a setInputDate() method. This method receives the date of
        // the day (year month day) it wants to know as input and stores the
        // date information in the Calendar class object.
        // And returns an object of the Calendar class.(FOLLOW DOCUMENTATION)
        var s = keyboard.next().strip();
        if (s.length() != 8) { // only for YYYYMMDD
            return null;
        }

        int year, month, day;
        try {
            year = Integer.parseInt(s.substring(0, 4));
            month = Integer.parseInt(s.substring(4, 6));
            day = Integer.parseInt(s.substring(6, 8));
        } catch (NumberFormatException e) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(year,
                month - 1,
                day);

        return cal;

    }
}
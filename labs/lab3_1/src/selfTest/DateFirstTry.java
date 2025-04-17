package selfTest;

public class DateFirstTry {

    /*Write the Code*/
    public String month ="";
    public int day = 0;

    public DateFirstTry(String month, int day) {
        this.month = month;
        this.day = day;
    }

    public void makeItNewYears() {
        /*Write the Code*/
        month = "January";
        day = 1;
    }

    public String yellIfNewYear() {
        /*Write the Code*/
        if (month.equals("january") && day == 1) {
            return "Happy New Year!";
        } else {
            return "Not New Year's Day.";
        }
    }

}

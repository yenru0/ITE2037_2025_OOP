package programmingAssignment;

import java.nio.file.DirectoryStream;
import java.util.*;
import java.util.function.Predicate;

public class HYTimeTableApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final String[] weeks = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        final List<String> weeksList = List.of(weeks);

        Predicate<String> isWeekend = (String day) -> {
            var k = weeksList.indexOf(day);
            if (k == 0 || k == 6) {
                return true;
            }
            return false;
        };

        Calendar cal = Calendar.getInstance();
        HYTimeTable timeTable = new HYTimeTable(); //	this line creates a TimeTable object.
        int enter;
        int period; // all range
        String name, day, tutorName, roomName, sub;
        boolean when = true;
        do {
            System.out.println("Please enter a `enter` value (1 to 6)");
            try {
                enter = keyboard.nextInt();
                keyboard.nextLine();
            } catch (InputMismatchException e) {
                enter = 0;
                keyboard.next();
            }

            switch (enter) {
                case 0: {
                    System.out.println("Error : Variable `enter` is invalid (usually not a number)");
                    break;
                }
                case 1: {
                    //Case 1
                    //•	Using the Scanner, the name, day, and period of the course are input, and the professor and room number are received.
                    //•	Check whether it is okay to add a subject using the setSchedule() method
                    //•	If these processes are completed successfully, ”Class successfully added”
                    // message and the completed timetable is output.
                    // If not successful, "Class was NOT successfully added" and "Please select a valid time for the lesson"
                    // should appear and  the timetable is outputted without any additions.
                    System.out.println("Please enter the day to add the class");
                    day = keyboard.next().toUpperCase();
                    if (!weeksList.contains(day)) {
                        System.out.println("Please enter a valid day");
                        break;
                    } else if (isWeekend.test(day)) {
                        System.out.println("There is no schedule");
                        break;
                    }

                    System.out.println("Please enter the time to add the class");
                    if (keyboard.hasNextInt()) {
                        period = keyboard.nextInt();
                        keyboard.nextLine();
                    } else {
                        System.out.println("Error : Please enter a valid period(integer)");
                        keyboard.nextLine();
                        break;
                    }

                    System.out.println("Please enter the name of the class");
                    name = keyboard.nextLine().strip();

                    System.out.println("Please enter the name of the tutor");
                    tutorName = keyboard.nextLine().strip();

                    System.out.println("Please enter the name of the room");
                    roomName = keyboard.nextLine().strip();

                    if (timeTable.setSchedule(day, period, name, tutorName, roomName)) {
                        System.out.println("Class successfully added");
                        System.out.println(timeTable);
                    } else {
                        System.out.println("Class was NOT successfully added");
                        System.out.println("Please select a valid time for the lesson");
                    }
                    break;
                }
                case 2: {
                    //Case 2
                    //•	Input a day and period using Scanner.
                    //•	Use the deleteSchedule() method to get the bool result.
                    //•	If true delete the class at that time and print
                    // Class successfully deleted else don’t modify
                    // anything and print "Class was NOT deleted" and That time-slot is either
                    // not available or already empty.
                    System.out.println("Please enter the day of the class to delete");
                    day = keyboard.next().toUpperCase();
                    if (!weeksList.contains(day)) {
                        System.out.println("Error : Please enter a valid day");
                        break;
                    } else if(isWeekend.test(day)) {
                        System.out.println("There is no schedule");
                        break;
                    }
                    System.out.println("Please enter the time of the class to delete");
                    if (keyboard.hasNextInt()) {
                        period = keyboard.nextInt();
                        keyboard.nextLine();
                    } else {
                        System.out.println("Error : Please enter a valid period(integer)");
                        keyboard.nextLine();
                        break;
                    }

                    if (timeTable.deleteSchedule(day, period)) {
                        System.out.println("Class successfully deleted");
                        System.out.println(timeTable);
                    } else {
                        System.out.println("Class was NOT deleted");
                        System.out.println("That time-slot is either not available or already empty");
                        System.out.println(timeTable);
                    }

                    break;
                }
                case 3: {
                    //Case 3
                    //•	Input day and period using Scanner.
                    //•	Use the getSchedule() method to get the subject of the corresponding
                    // time and output the information of the subject as shown IN THE DOCUMENT.

                    System.out.println("Please enter the day of the class");
                    day = keyboard.next().toUpperCase();
                    if (!weeksList.contains(day)) {
                        System.out.println("Error : Please enter a valid day");
                        break;
                    } else if(isWeekend.test(day)) {
                        System.out.println("There is no schedule");
                    }
                    System.out.println("Please enter the time of the class");
                    if (keyboard.hasNextInt()) {
                        period = keyboard.nextInt();
                        keyboard.nextLine();
                    } else {
                        System.out.println("Error : Please enter a valid period(integer)");
                        keyboard.nextLine();
                        break;
                    }

                    sub = timeTable.getSchedule(day, period);
                    if (sub == null) {
                        System.out.println("There is no matching class");
                    } else {
                        System.out.println(sub);
                    }

                    break;
                }
                case 4: {
                    //Case 4
                    //•	Input day and period using Scanner.
                    //•	Use the subject Schedule() method to get the subject
                    // information of the subject as shown IN THE DOCUMENT.
                    //•	However if the class is not present print “There is no class” as output
                    System.out.println("Please enter the class name");
                    name = keyboard.nextLine().strip();

                    System.out.println(timeTable.subjectSchedule(name));
                    System.out.println(timeTable);
                    break;

                }
                case 5: {
                    //Case 5
                    //•	Print the entire timetable for a specific date using Scanner. EX) April 1, 2024
                    //Enter ‘20240401’
                    //•	Using the day of the entered date, only the timetable for the corresponding day is output. (see DOCUMENT)
                    //•	However, if the day of the week is a weekend (Saturday or Sunday), the string “There is no schedule” is output and exited.
                    System.out.println("Enter the date(YYYYMMDD)");
                    cal = timeTable.setInputDate();
                    if (cal == null) {
                        System.out.println("Error : Please enter a valid date(YYYYMMDD)");
                        break;
                    }
                    var index = cal.get(Calendar.DAY_OF_WEEK) - 1;
                    if (index == 0 || index == 6) {
                        System.out.println("There is no schedule");
                        break;
                    } else {
                        System.out.println(timeTable.oneDaySchedule(weeks[index]));
                    }
                    System.out.println(timeTable);

                    break;
                }
                case 6: {
                    //Case 6:
                    //•	End the program.
                    when = false;
                    break;
                }
                default:
                    System.out.println("Error : Variable `enter` is invalid (usually not a valid number)");
            }
        } while (when);

        keyboard.close();

    }


}
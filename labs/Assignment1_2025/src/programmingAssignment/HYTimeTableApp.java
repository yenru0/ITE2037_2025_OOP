package programmingAssignment;

import java.util.*;
import java.util.function.Predicate;

public class HYTimeTableApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final String[] weeks = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        final List<String> weeksList = Arrays.asList(weeks);

        Predicate<String> isWeekend = (String day) -> {
            int k = weeksList.indexOf(day);
            return k == 0 || k == 6;
        };

        Calendar cal = Calendar.getInstance();
        HYTimeTable timeTable = new HYTimeTable(); //	this line creates a TimeTable object.
        int enter;
        int period; // all range
        String name, day, tutorName, roomName, sub;
        boolean when = true;
        do {
            System.out.println("================Main Menu===============");
            System.out.println("(1) Add a class to my time table");
            System.out.println("(2) Delete a class from my time table");
            System.out.println("(3) View the class at a specific time");
            System.out.println("(4) View schedule of a specific class");
            System.out.println("(5) TimeTable corresponding to input date");
            System.out.println("(6) Exit the Program");
            System.out.println("================Main Menu===============");
            try {
                enter = keyboard.nextInt();
            } catch (InputMismatchException e) {
                enter = 0;
                keyboard.nextLine();
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
                    name = keyboard.nextLine().trim();

                    System.out.println("Please enter the name of the tutor");
                    tutorName = keyboard.nextLine().trim();

                    System.out.println("Please enter the name of the room");
                    roomName = keyboard.nextLine().trim();

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
                    } else if (isWeekend.test(day)) {
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
                    } else if (isWeekend.test(day)) {
                        System.out.println("There is no schedule");
                        break;
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
                    System.out.println(timeTable);

                    break;
                }
                case 4: {
                    //Case 4
                    //•	Input day and period using Scanner.
                    //•	Use the subject Schedule() method to get the subject
                    // information of the subject as shown IN THE DOCUMENT.
                    //•	However if the class is not present print “There is no class” as output
                    System.out.println("Please enter the class name");
                    name = keyboard.nextLine().trim();

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
                    int index = cal.get(Calendar.DAY_OF_WEEK) - 1;
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
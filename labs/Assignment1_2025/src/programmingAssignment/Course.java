package programmingAssignment;

import java.text.MessageFormat;

public class Course {
    public String name;
    public String professor;
    public String roomNumber;
    public boolean isValid = true;

    static final String CLASS_LUNCH = "LUNCH";
    static final String CLASS_DINNER = "DINNER";
    static final String CLASS_BLANK = "----";

    public Course() {
        name = "";
        professor = "";
        roomNumber = "";
        isValid = true;
    }

    public Course(String name, String tutor, String room) {
        //•	Create a constructor that initializes all variables (except isValid)
        this.name = name;
        professor = tutor;
        roomNumber = room;
    }

    public Course(String name) {
        //•	Create a constructor that initializes only the name of the subject.
        this.name = name;
    }

    public Course(Course copy) {
        //•	Create a copy constructor used to make copies of the subject.
        this.name = copy.name;
        this.professor = copy.professor;
        this.roomNumber = copy.roomNumber;
        this.isValid = copy.isValid;
    }

    public String getState() {
        //•	Create an accessor method that gets the values of name, tutor, and room.
        return getDetails();
    }

    public void setState(String tutor, String room) {
        //•	Create a mutator method to initialize the values of tutor and room
        professor = tutor;
        roomNumber = room;
    }

    public boolean equals(Course s) {
        //•	Create an equals() method that determines whether courses are equal.
        // However, returns true only when the three values of name, tutor, and room are the same,
        // otherwise returns false.

        return this.professor.equals(s.professor) && this.roomNumber.equals(s.roomNumber) && this.name.equals(s.name);
    }

    public String toString() {
        //•	Create a toString() method that returns only the name of the course.
        return name;
    }

    public String getDetails() {
        //•	Create a getDetails() method that returns the course name, professor, and roomNumber as String
        return String.format("Name : %s\nTutor : %s\nRoom : %s\n", name, professor, roomNumber);
    }
}
package selfTest;

public class Employee {

    private String name;
    private int age;
    private String position = "Engineer";
    private int salary = 15000;
    private int vacationDays = 20;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, String position, int salary) {
        this.name = name;
        this.age = age;
        if (position != null) {
            this.position = position;
        }
        this.salary = salary;
    }

    public Employee(String name, int age, String position, int salary, int vacationDays) {
        this.name = name;
        this.age = age;
        if (position != null) {
            this.position = position;
        }
        this.salary = salary;
        this.vacationDays = Math.max(vacationDays, 0);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Public method to output employee information
    public void outInfo() {
        System.out.println(this);
    }

    public String vacation(int days) {
        if (days > 0 && vacationDays >= days) {
            vacationDays -= days;
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    public boolean equals(Employee other) {
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name) && this.age == other.age;
    }

    public String toString() {
        return String.format("Name: %s\nAge: %d\nPosition: %s\nSalary: %d\nVacation Days: %d", name, age, position, salary, vacationDays);
    }

}
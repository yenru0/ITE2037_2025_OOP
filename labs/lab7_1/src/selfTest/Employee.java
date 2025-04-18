package selfTest;

public class Employee {

    private String name;
    private int employeeNum;
    private String department = "No Dept";

    public Employee(String name, int employeeNum) {
        this.name = name;
        this.employeeNum = employeeNum;
    }

    public Employee(String name, int employeeNum, String department) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Employee anotherEmp) {
        return this.name.equals(anotherEmp.name) && this.employeeNum == anotherEmp.employeeNum;
    }

    public String toString() {
        return "Name : " + name + "\nEmp# :" + employeeNum;
    }
}

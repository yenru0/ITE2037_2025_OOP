package selfTest;

public class Employee {

    private String name;
    private int employeeNum;
    private String department = "No Dept";

    public Employee(String name, int employeeNum) {
        this.name = name;
        this.employeeNum = employeeNum;
    }

    public Employee(String name, int employeeNum, String deaprtment) {
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

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return this.name.equals(((Employee)obj).name) && this.employeeNum == ((Employee)obj).employeeNum;
        }
    }

    public String toString() {
        return ("Name : " + this.name + "\nEmp# : " + this.employeeNum);
    }
}

package selfTest;

public class Manager extends Employee {

    private int officeNum;
    private String team;

    public Manager(String name, int employeeNum, int officeNum, String team) {
        super(name, employeeNum);
        this.officeNum = officeNum;
        this.team = team;
    }

    public String toString() {
        return ("Name : " + getName() + "\nLocation : " + getDepartment() + ", " + officeNum);
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return super.equals(obj) && officeNum == ((Manager)obj).officeNum && team.equals(((Manager)obj).team);
        }
    }
}

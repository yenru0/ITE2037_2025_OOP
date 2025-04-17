package selfTest;

public class EmployeeManager {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.printf("%s %s\n", "HajinJu", "2024062806");
        /* Write the code */
        var employee1 = new Employee("Walter White", 42, "Manager", 20_000);
        var employee2 = new Employee("Jesse Pinkman", 32, "Assistant Manager", 12_000, 7);
        var employee3 = new Employee("Jimmie McGill", 38);
        var employee4 = new Employee("Chunk McGill", 40);
        var employee5 = new Employee("Walter White", 42, "Manager", 20_000);

        employee1.setSalary(21_000);
        employee5.setSalary(21_000);

        employee1.outInfo();
        System.out.println();
        employee2.outInfo();
        System.out.println();

        System.out.println(employee3.vacation(10));
        System.out.println();
        System.out.println(employee2.vacation(10));
        System.out.println();

        employee3.outInfo();

        System.out.println();
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.equals(employee5));
    }

}

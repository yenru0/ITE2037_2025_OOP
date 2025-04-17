package selfTest;

public class Project02_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int intVal1, intVal2;

        // Use nested loop

        for (intVal1 = 1; intVal1 <= 5; intVal1++) {
            for (intVal2 = 5; intVal2 > 0; intVal2--) {
                System.out.printf("%d multiplied by %d = %d\n", intVal1, intVal2, intVal1 * intVal2);
            }
        }

    }
}

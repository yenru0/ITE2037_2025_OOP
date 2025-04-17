package selfTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GradeBook {
    private int numberOfStudents;
    private int numberOfQuizzes;

    private int[][] grade;

    private double[] studentAverage;
    private double[] quizAverage;

    public GradeBook() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of Students:");
        numberOfStudents = keyboard.nextInt();

        System.out.println("Enter the number of Quizzes:");
        numberOfQuizzes = keyboard.nextInt();


        grade = new int[numberOfStudents][numberOfQuizzes];

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < numberOfQuizzes; j++) {
                System.out.printf("Enther the score for student %d on quiz %d%n", i + 1, j + 1);
                grade[i][j] = keyboard.nextInt();
            }
        }

        studentAverage = new double[numberOfStudents];
        quizAverage = new double[numberOfQuizzes];


        fillStudentAverage();
        fillQuizAverage();
    }


    private void fillStudentAverage() {
        if (numberOfStudents == 0 || numberOfQuizzes == 0) return;
        var arr = Arrays.stream(grade).mapToDouble(
                row -> Arrays.stream(row).average().getAsDouble()
        ).toArray();

        for (int i = 0; i < arr.length; i++) {
            studentAverage[i] = arr[i];
        }
    }

    private void fillQuizAverage() {
        if (numberOfQuizzes == 0 || numberOfStudents == 0) return;
        var arr = IntStream.range(0, numberOfQuizzes).mapToDouble(
                i -> Arrays.stream(grade).mapToInt(j -> j[i]).average().getAsDouble()
        ).toArray();

        for (int i = 0; i < arr.length; i++) {
            quizAverage[i] = arr[i];
        }
    }


    public void display() {
        for (int studentNumber = 1; studentNumber <= numberOfStudents; studentNumber++) {
            System.out.print("Student " + studentNumber + " Quizzes: ");
            for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
                System.out.print(grade[studentNumber - 1][quizNumber - 1] + " ");
            System.out.println("Ave = " + studentAverage[studentNumber - 1]);
        }

        System.out.println("Quiz average : ");

        for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++)
            System.out.print("Quiz " + quizNumber + " Ave = " + quizAverage[quizNumber - 1] + " ");
        System.out.println();
    }


}
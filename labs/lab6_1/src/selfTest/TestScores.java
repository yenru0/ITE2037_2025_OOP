package selfTest;

import java.util.Arrays;
import java.util.Scanner;

public class TestScores {
    public static final int MAX_NUMBER_SCORES = 10;

    public static void main(String[] args) {
        double[] scores = new double[MAX_NUMBER_SCORES];
        int counting = 0;

        System.out.println("This program reads test scores and shows");
        System.out.println("how much each differs from the average.");
        System.out.println("Enter test scores:");

        counting = fillArray(scores);
        showDifference(scores, counting);

    }

    public static int fillArray(double[] arr) {
        System.out.println("Mark the end of the list with a negative number.");
        var scanner = new Scanner(System.in);
        var cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            var tmp = scanner.nextDouble();
            if (tmp < 0) {
                break;
            }
            arr[i] = tmp;
            cnt++;
        }

        return cnt;

    }

    public static void showDifference(double[] scores, int cnt) {

        if (cnt == 0) {
            System.out.println("No elements");
            return;
        }
        double average = computeAverage(scores, cnt);


        System.out.println("Average of the scores = " + average);
        System.out.println("The scores are: ");

        for (int i = 0; i < cnt; i++) {
            System.out.println(scores[i] + " differs from average by " + (scores[i] - average));
        }

    }

    public static double computeAverage(double[] arr, int cnt) {
        return Arrays.stream(arr, 0, cnt).average().getAsDouble();
    }
}

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] s = new int[n][n];
    static boolean[] isSelected = new boolean[n];
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        // input
        for (int i = 0; i < n; i++) {
            isSelected[i] = false;
            for (int j = 0; j < n; j++)
                s[i][j] = sc.nextInt();
        }

        // logic
        selectMember(0, -1);

        // output
        System.out.println(min);
    }

    public static void calculate() {
        int teamA = 0, teamB = 0, gap;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || isSelected[i] != isSelected[j]) continue;
                if (isSelected[i]) {
                    teamA += s[i][j];
                }
                else {
                    teamB += s[i][j];
                }
            }
        }

        gap = Math.abs(teamA - teamB);
        if (gap < min)
            min = gap;
    }
    public static void selectMember(int cnt, int start) {
        // finish condition
        if (cnt == n / 2) {
            calculate();
            return;
        }

        for (int i = start + 1; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selectMember(cnt + 1, i);
                isSelected[i] = false;
            }
        }
    }

}
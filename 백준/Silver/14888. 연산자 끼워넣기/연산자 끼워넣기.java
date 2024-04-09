import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] num = new int [n];
    static int[] op = new int[4];
    static int[] selectedOp = new int[n - 1];
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) {
        // input
        for (int i = 0; i < n; i++)
            num[i] = sc.nextInt();
        for (int i = 0; i < 4; i++)
            op[i] = sc.nextInt();

        // logic
        selectOp(0);

        // output
        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate() {
        int sum = num[0];
        for (int i = 0; i < n - 1; i++) {
            switch (selectedOp[i]) {
                case 0:
                    sum += num[i + 1];
                    break;
                case 1:
                    sum -= num[i + 1];
                    break;
                case 2:
                    sum *= num[i + 1];
                    break;
                case 3:
                    sum /= num[i + 1];
                    break;
            }
        }
        if (sum > max)
            max = sum;
        if (sum < min)
            min = sum;
    }
    public static void selectOp(int cnt) {
        // finish condition
        if (cnt == n - 1) {
            calculate();
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i] -= 1;
                selectedOp[cnt] = i;
                selectOp(cnt + 1);
                op[i] += 1;
            }
        }
    }
}
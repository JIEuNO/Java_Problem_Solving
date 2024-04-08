import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long count = 0L;
        double left = 0;

        // logic
        for (int i = 0; i < n; i++) {
            count += 1; // main supervisor
            left = a[i] - b;
            if (left > 0)
                count += (int) Math.ceil(left / c); // sub supervisor
        }

        // output
        System.out.println(count);
    }
}
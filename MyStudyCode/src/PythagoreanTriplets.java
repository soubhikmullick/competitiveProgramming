import java.util.HashSet;
import java.util.*;


public class PythagoreanTriplets {

    public static HashSet<Integer> hs;
    public static int arr[];
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        hs = new HashSet<>();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            hs.add(arr[i] * arr[i]);
            arr[i] = arr[i] * arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (hs.contains(arr[i] + arr[j])) {
                    System.out.println("{" + (int) Math.sqrt(arr[i]) + "," + (int) Math.sqrt(arr[j]) + "," + (int) Math.sqrt(arr[i] + arr[j]) + "}");
                }
            }
        }
    }
}

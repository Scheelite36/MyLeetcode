import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        int[][] a = new int[][] { new int[] { 1, 3 }, new int[] { 1, 2 }, new int[] { 3, 5 } };
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        };
        Collections.sort(Arrays.asList(a), c);
        for (int[] is : a) {
            System.out.println(is[0] + " " + is[1]);
        }
    }
}

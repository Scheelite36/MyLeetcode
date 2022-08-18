import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Test {

    static int[][] direct = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    static int count = 1;
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited= new boolean[m][n];
        trackBack(0, 0, m, n, k, visited);
        return count;
    }
    public static void trackBack(int x, int y, int m, int n, int k, boolean[][] visited){
        visited[x][y] = true;
        for (int[] d : direct) {
            int newx = x + d[0]; int newy = y + d[1];
            int sum = bitSum(newx, newy);
            if (newx< m && newx > -1 && newy > -1 && newy < n && sum <= k && !visited[newx][newy]){
                count++;
                trackBack(newx, newy, m, n, k, visited);
            }
        }
    }

    public static int bitSum(int x, int y){
        int sum = 0;
        while( x%10 != 0 || y%10 != 0 ){
            sum += (x % 10 + y % 10);
            x /= 10; y /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<double[]> list = new ArrayList<>();
        list.add(new double[]{0d,1d});
        list.add(new double[]{0d,3d});
        double[] d = list.get(0);
        d[1] = 4d;
        return;
    }

}

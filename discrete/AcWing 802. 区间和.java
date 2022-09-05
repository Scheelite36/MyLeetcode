package discrete;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 假定有一个无限长的数轴，数轴上每个坐标上的数都是0。
 * 
 * 现在，我们首先进行 n 次操作，每次操作将某一位置x上的数加c。
 * 
 * 接下来，进行 m 次询问，每个询问包含两个整数l和r，你需要求出在区间[l, r]之间的所有数的和。
 * 
 * 输入格式
 * 第一行包含两个整数n和m。
 * 
 * 接下来 n 行，每行包含两个整数x和c。
 * 
 * 再接下里 m 行，每行包含两个整数l和r。
 * 
 * 输出格式
 * 共m行，每行输出一个询问中所求的区间内数字和。
 * 
 * 数据范围
 * −109≤x≤109,
 * 1≤n,m≤105,
 * −109≤l≤r≤109,
 * −10000≤c≤10000
 * 
 * 样例
 * 输入样例：
 * 3 3
 * 1 2
 * 3 6
 * 7 5
 * 1 3
 * 4 6
 * 7 8
 * 输出样例：
 * 8
 * 0
 * 5
 * 
 * 作者：cht
 * 链接：https://www.acwing.com/solution/content/13350/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 将所有提到的区间下标离散化 映射到数组连续的下标
 */
class Acwing802 {
    /**
     * 数组原地去重
     * @param nums
     */
    static void unique(int[] nums) {
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i]!=nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        nums = Arrays.copyOf(nums, j);
    }
  /**
   * 二分找出离散化对应的值
   */
  static int find(int x, int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = l + r >> 1;
        if (nums[mid] >= x)
            r = mid;
        else
            l = mid + 1;
    }
    // 方便后续前缀和的操作所以加1
    return l + 1;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] index = new int[m + 2 * n];
        int[][] ops = new int[m][2];
        int[][] intervals = new int[n][2];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            index[i] = l;
            ops[i] = new int[] { l, sc.nextInt() };
        }
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            index[m + 2 * i] = l;
            index[m + 2 * i + 1] = r;
            intervals[i] = new int[] { l, r };
        }
        // 具体操作
        // 现将index数组排序并 去重复
        Arrays.sort(index);
        unique(index);
        // 目标数组
        int[] a = new int[index.length+1];
        // 修改数字操作
        for (int[] op : ops) {
            int x = find(op[0], index);
            a[x] += op[1];
        }
        // 前缀和前处理
        int[] s = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            s[i] = s[i-1] + a[i];
        }
        // 求区间和
        for (int[] i : intervals) {
            int ii = find(i[0], index);
            int jj = find(i[1], index);
            System.out.println(s[jj] - s[ii-1]);
        }
    }

}

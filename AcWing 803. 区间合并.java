import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 * 
 * 注意如果在端点处相交，也算有交集。
 * 
 * 输出合并完成后的区间个数。
 * 
 * 例如：[1,3]和[2,6]可以合并为一个区间[1,6]。
 * 
 * 输入格式
 * 第一行包含整数n。
 * 
 * 接下来n行，每行包含两个整数 l 和 r。
 * 
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 * 
 * 数据范围
 * 1≤n≤100000,
 * −109≤li≤ri≤109
 * 
 * 样例
 * 输入样例：
 * 5
 * 1 2
 * 2 4
 * 5 6
 * 7 8
 * 7 9
 * 输出样例：
 * 3
 */
class AcWing803 {
    /**
     * 自定义区间的比较器
     */
    static Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        }
    };

    static void sort(int[][] segs) {
        Collections.sort(Arrays.asList(segs), cmp);
    }

    /**
     * 对比区间进行合并 有交集的就取并集 没有的就是另一个区间
     * @param segs
     * @return
     */
    static int[][] merge(int[][] segs){
        int[] seg = segs[0];
        int j = 0;
        for (int i = 1; i < segs.length; i++) {
            if (seg[1] > segs[i][0]){
                // 如果右边更长就更新右边界
                if (seg[1] < segs[i][1]){
                    seg[1] = segs[i][1];
                }
            }else {
                segs[j++] = seg;
                seg = segs[i];
            }
        }
        return Arrays.copyOf(segs, j);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segs = new int[n][2];
        for (int i = 0; i < n; i++) {
            segs[i] = new int[]{sc.nextInt(),sc.nextInt()};
        }
        sort(segs);
        System.out.println(merge(segs).length);
    }
}

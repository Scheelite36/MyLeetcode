package sort;

public class quickSortTemp {
    public static void main(String[] args) {
        quickSortTemp qt = new quickSortTemp();
        int[] q = new int[] { 1, 3, 4, 3, 2, 2, 5, 3, 5 };
        qt.quickSort(q, 0, q.length - 1);
        System.out.println(q);
    }

    public void quickSort(int[] q, int l, int r) {
        if (l >= r)
            return;
        // 扩大一格边界 因为循环内默认直接+1
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) {
            }
            while (q[--j] > x) {
            }
            // 交换
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
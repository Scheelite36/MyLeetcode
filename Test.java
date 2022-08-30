import java.util.ArrayList;
import java.util.List;

import sort.mergeSortTemp;
import sort.quickSortTemp;

public class Test {

    public static void main(String[] args) {
        mergeSortTemp qt = new mergeSortTemp();
        int[] q = new int[] { 1, 3, 4, 3, 2, 2, 5, 3, 5 };
        qt.mergeSort(q, 0, q.length - 1);
        System.out.println(q);
    }

}

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public int[] sortArray(int[] nums) {
        // mergeSort(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[++i] < x) {
            }
            while (nums[--j] > x) {
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.sortArray(new int[] { 5, 1, 2, 6, 5, 2, 1 });
    }
}

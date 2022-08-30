package sort;

public class mergeSortTemp {
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // 归并 用临时数组保存合并后的数组，k对应临时数组的下标
        int k = 0, i = l, j = mid + 1;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= r)
            temp[k++] = nums[j++];
        // 将temp数组合并进入nums
        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }
    }
}

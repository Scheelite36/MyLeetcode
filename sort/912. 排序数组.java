package sort;

class Solution912 {
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快排
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[++i] <= x) {
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

    // 归并
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= r)
            temp[k++] = nums[j++];
        for (i = l, j = 0; i < r; i++, j++) {
            nums[i] = temp[j];
        }
    }
}

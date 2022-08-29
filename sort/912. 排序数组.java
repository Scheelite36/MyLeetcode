package sort;

class Solution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int l, int r){
        if (l >= r) return;
        int x = nums[l], i = l-1, j = r+1;
        while(i < j){
            while(nums[++i] < x){}
            while(nums[--j] > x){}
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j+1, r);
    }
}

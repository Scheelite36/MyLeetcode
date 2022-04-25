import java.util.Random;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    private int[] array;

    private int[] arrayC;

    public Solution(int[] nums) {
        this.array = nums;
        this.arrayC = nums.clone();
    }

    public int[] reset() {
        return arrayC;
    }

    public int[] shuffle() {
        Random r = new Random();
        int n = array.length;
        // iterate the array from last one, and randomly get one from before, 
        // than exchange them;
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

import java.util.regex.Pattern;

public class Test {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while(right<nums.length){
            if (nums[left] != nums[right]){
                if(right-left == 1){
                    right++;
                    left++;
                }else{
                    nums[++left]=nums[right++];
                }
            }else{
                right++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Test t = new Test();
        int[] nums = new int[]{1,1,2};
        System.out.println(t.removeDuplicates(nums));
    }
}

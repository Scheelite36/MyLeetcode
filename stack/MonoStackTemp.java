package stack;

public class MonoStackTemp {
	int[] nums;
	// 保存单调递增或者单调递减的一个数组（单调栈）
  	int[] stk;
  	int tt;
  	public void monoStack(){
    	for (int i=0; i<nums.length; i++) {
        	while (tt>0 && check(stk[tt],i)) tt--;
            stk[++tt] = nums[i];
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> fbl = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 15 == 0) {
                fbl.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fbl.add("Fizz");
            } else if (i % 5 == 0) {
                fbl.add("Buzz");
            }else{
                fbl.add(Integer.toString(i));
            }   
        }
        return fbl;
    }
}
// @lc code=end

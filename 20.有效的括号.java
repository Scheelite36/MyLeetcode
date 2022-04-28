import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        String left = "({[";
        for (char c : s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                charStack.push(c);
            } else if (!charStack.isEmpty()
                    && (c - charStack.peek() == 2 || c - charStack.peek() == 1)) {
                charStack.pop();
            } else {
                return false;
            }
        }
        return charStack.isEmpty();
        // if (s.isEmpty())
        //     return true;
        // Stack<Character> stack = new Stack<Character>();
        // for (char c : s.toCharArray()) {
        //     if (c == '(')
        //         stack.push(')');
        //     else if (c == '{')
        //         stack.push('}');
        //     else if (c == '[')
        //         stack.push(']');
        //     else if (stack.empty() || c != stack.pop())
        //         return false;
        // }
        // return stack.isEmpty();
    }
}
// @lc code=end

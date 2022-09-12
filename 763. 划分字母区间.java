import java.util.ArrayList;
import java.util.List;
/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 
 *  
 * 
 * 示例：
 * 
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        // 记录最后一次出现的位置
        for (int i = 0; i < n; i++) {
            lastIndex[chars[i]-'a'] = i;
        }
        int max = lastIndex[chars[0]-'a'];
        int j = 0;
        // 遍历更新每一段的边界
        for (int i = 0; i < n; i++) {
            if (i < max){
                max = Math.max(lastIndex[chars[i]-'a'], max);
            } else {
                res.add(max-j+1);
                if (i != n-1){
                    j = i + 1;
                    max = lastIndex[chars[j]-'a'];
                }
            }
        }
        return res;
    }
    // 另一种就是合并区间啦 略
}
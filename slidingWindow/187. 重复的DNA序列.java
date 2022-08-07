package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    // hash +滑动窗口
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length()-9; i++) {
            if (!set.add(s.substring(i, i+10)) && !list.contains(s.substring(i, i+10))){
                list.add(s.substring(i, i+10));
            }
        }
        return list;
    }

}

class Solution2 {
    private int l = 10;
    private Map<Character, Integer> alpha = new HashMap<>(){{
        put('A',0);
        put('C',1);
        put('G',2);
        put('T',3);
    }};
    // 滑动窗口+ hash +位运算
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n < l){
            return res;
        }
        int x = 0;
        // 取到前9个数
        for (int i=0; i<l-1; i++){
            x = (x << 2)|alpha.get(s.charAt(i)); 
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i <= n-l;i++){
            // 添加最后一位，并删除最前面的
            x = ((x << 2) | alpha.get(s.charAt(i+l-1))) & ((1 << (2*l)) - 1);
            map.put(x, map.getOrDefault(x, 0)+1);
            if (map.get(x) == 2){
                res.add(s.substring(i, i+l));
            }
        }
        return res;
    }

}
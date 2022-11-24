package string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String u = getUniqueStr(str);
            List<String> o = map.getOrDefault(u, new ArrayList<>());
            o.add(str);
            map.put(u, o);
        }
        // for (Map.Entry<String, List<String>> entry: map.entrySet()) {
        //     res.add(entry.getValue());
        // }
        
        return new ArrayList<List<String>>(map.values());
    }

    String getUniqueStr(String str){
        if (str.length() == 0) return "";
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        return new String(strs);
    }
    public static void main(String[] args) {
        Solution49 s = new Solution49();
        s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}

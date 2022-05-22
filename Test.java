import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Test {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums1){
            if (!map.containsKey(n)){
                map.put(n,1);
            }else{
                map.put(n, map.get(n)+1);
            }
        }
        for (int n: nums2){
            if (map.containsKey(n) && map.get(n) > 0){
                map.put(n, map.get(n)-1);
                res.add(n);
            }
        }
        int[] ress = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            ress[i] = res.get(i);
        }
        return ress;
    }

    public static void main(String[] args) {
        intersect(new int[]{1,2,3},new int[]{2,2,3});

    }
}

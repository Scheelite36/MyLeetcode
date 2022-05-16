import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Test {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            if (!set.add(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Set<List<Integer>> sets = new HashSet<>();
        sets.add(Arrays.asList(1,2));
        System.out.println(sets.add(Arrays.asList(1,2)));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(sets.add(list));
    }
}

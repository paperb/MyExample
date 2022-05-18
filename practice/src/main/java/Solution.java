import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Object> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = nums.length;
        int size = set.size();
        if (length != size) {
            return true;
        } else return false;
    }


}

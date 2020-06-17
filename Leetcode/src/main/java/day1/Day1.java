package day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: HeYin
 * @date: 2020/06/18
 */
public class Day1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.err.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i],i);
        }
        throw new IllegalArgumentException("no solution!");
    }

}

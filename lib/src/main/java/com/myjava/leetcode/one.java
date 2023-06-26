package com.myjava.leetcode;

import com.myjava.test.Person;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class one {
    public static int[] twoSum(int[] nums, int target) {
        int[] s = new int[2];
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    s[0] = i;
                    s[1] = j;
                    return s;
                }
            }
        }
        return s;

//        Map<Integer, Integer> map = new HashMap<>();
//        int N = nums.length;
//        for (int i = 0; i < N; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[]{map.get(complement), i};
//            } else {
//                map.put(nums[i], i);
//            }
//        }
//
//        return null;
    }

    private static MultiValueMap<String, Person> mMapCodeToEventListener = new MultiValueMap<String, Person>();

    public static void main(String[] args) {
//        int[] a = new int[]{2, 7, 6, 8};
//        int[] b = twoSum(a, 13);
//        System.out.println(b[0] + "***" + b[1]);
//        mMapCodeToEventListener.get(0);
        double e = 5454.4544454f;
        System.out.format("%f%n",e);
        System.out.format(Locale.GERMAN,"%10.4f%n%n",e);//前面的数字决定补空格，小数点有四位，加上小数点有5位，所以前面至少有5位，少了补空格
    }
}

/*
 
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2. = nums1 - nums2
answer[1] is a list of all distinct integers in nums2 which are not present in nums1. = nums2 - nums1

Note that the integers in the lists may be returned in any order. 
 
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class FindDifferenceTwoArrays {

    public static int find(int x, int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == x) return i;
        }
        return -1;
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> diff1 = new HashSet<>();
        Set<Integer> diff2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        
        for(int i=0; i<nums1.length; i++) {
            if (diff1.contains(nums1[i])) continue;
            if (common.contains(nums1[i])) continue;
            
            int found = find(nums1[i], nums2);
            if (found > -1) common.add(nums1[i]);
            else diff1.add(nums1[i]);
        }

        for(int i=0; i<nums2.length; i++) {
            if (common.contains(nums2[i])) continue;
            else diff2.add(nums2[i]);
        }

        answer.add(List.copyOf(diff1));
        answer.add(List.copyOf(diff2));
        return answer;
    }

    public static void main(String[] args) {
        //int[] nums1 = {1,1,2,2,2,500};
        //int[] nums2 = {2,2,3,3,600};
        // diff1 = {1,500}
        // common: {2}
        // diff2 = {3,600}
        
        //int[] nums1 = {1,2,3};
        //int[] nums2 = {2,4,6};
        
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        
        List<List<Integer>> answer = findDifference(nums1, nums2);
        for(Integer a: answer.get(0)) {
            p(a.intValue());
        }
        p();
        for(Integer a: answer.get(1)) {
            p(a.intValue());
        }
    }

    public static void p(int x) {
        System.out.println(x);
    }
    public static void p() {
        System.out.println("");
    }

}

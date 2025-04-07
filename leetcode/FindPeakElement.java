/*
https://leetcode.com/problems/find-peak-element/description/

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

E.g.1
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

E.g.2
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/

class FindPeekElement {
  public static void main(String[] args) {
    // int[] nums = {1,2,3,4};
    // int[] nums = {4,3,2,1};
    // int[] nums = {1,2,3,1};
    int[] nums = {5,4,3,4};
    int ans = findPeakElement(nums);
    System.out.println(ans);
  }
  public static int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while(left < right) {
      int mid = left + (right - left) / 2; // to avoid integer overflow
      // int mid = (left + right) / 2;
    
      // System.out.println("left: " + left + ", " + nums[left]);
      // System.out.println("right: " + right + ", " + nums[right]);
      // System.out.println("mid: "+ mid + ", " + nums[mid]);
      // System.out.println("");

      if (left == mid) {
        if (nums[left] < nums[right]) return right;
        if (nums[left] > nums[right]) return left;
      }

      if (nums[mid] < nums[mid+1]) left = mid;
      else right = mid;

    }
    return 0;
  }
}


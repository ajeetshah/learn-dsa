/*

URL: https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

Problem: You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:

n == nums.length
1 <= k <= n <= 10^5
-10^4 <= nums[i] <= 10^4

*/
import java.util.stream.IntStream;
import java.util.Arrays;

public class MaxAvgSubArray{
  
  public static double findMaxAverage(int[] nums, int k) {
    // concept: sliding window

    int start1, start2;
    int end1, end2;
    Double answer = null;

    // no need to calculate sum of sub array agian and again
    int flag1 = 0;
    int flag2 = 0;
  
    double average1 = 0.0;
    double average2 = 0.0;

    for(start1 = 0, end1 = k-1, start2 = nums.length-1-(k-1), end2 = nums.length-1; 
        start1 < nums.length && end1 < nums.length &&
        start2 < nums.length && end2 < nums.length; 
        start1++, end1++, start2--, end2--) {
  
      // window1
      if (flag1 == 0) {
        int[] window1 = Arrays.copyOfRange(nums, start1, end1 + 1);
        average1 = IntStream.of(window1).sum();
        flag1 = 1;
      } else {
        average1 = average1 - nums[start1-1] + nums[end1];
      }
      if (answer == null) answer = average1;
      else if (average1 > answer.doubleValue()) answer = average1;

      // window2
      if(flag2 == 0) {
        int[] window2 = Arrays.copyOfRange(nums, start2, end2 + 1);
        average2 = IntStream.of(window2).sum();
        flag2 = 1;
      } else {
        average2 = average2 + nums[start2] - nums[end2+1];
      }
      if (answer == null) answer = average2;
      else if (average2 > answer.doubleValue()) answer = average2;

      if (start1 == start2 && end1 == end2) break;
    }

    return answer / (double) k;
  }

  public static void main(String[] args) {
    //int[] nums = {5};
    //int k= 1;

    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;

    //int[] nums = {1,2,3, 4, 5};
    //int k = 2;

    double answer = findMaxAverage(nums, k);
    System.out.println(answer);
  }

}

// Note: I have used 2 winodws in above code, but it is ok to use just 1 window as well


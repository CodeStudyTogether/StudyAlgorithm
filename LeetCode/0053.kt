53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.size == 0){
            return 0
        }
        if(nums.size == 1){
            return nums[0]
        }
        var max1 = nums[0]
        var max2 = nums[0]
        for (i in 1 until nums.size) {//o(n)
            max2 = Math.max(max2 + nums[i], nums[i])//比较下一个数，和更大的话就记录下来，然后和记录的sum比较，sum会是最后的答案（这一步最重要）
            max1 = Math.max(max1, max2)
        }
        return max1
    }
}

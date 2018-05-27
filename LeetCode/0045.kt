//45. Jump Game II
什么时候step需要加1？答案是当前的i超过了前一步的最远位置。所以记录上一步能到达的最远位置。当遍历到i的时候，如果i超过了上一步能到达的最远位置e，说明步数需要加1，此时仍需要更新last为当前最远位置reach。全程只需遍历1次数组，而且空间复杂度为常量。
时间复杂度：O(n)
空间复杂度：O(1)
class Solution {
    fun jump(nums: IntArray): Int {
        var sc = 0
        var e = 0
        var max = 0
        for(i in 0 until nums.size - 1) {//不包括A.size - 1
            max = Math.max(max, i + nums[i])
            if(i == e) {
                sc++
                e = max
            }
        }
        return sc
    }
}
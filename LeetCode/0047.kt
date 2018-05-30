//47. Permutations II
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        var ans: MutableList<List<Int>> = ArrayList()
        if (nums.size == 0) return ans
        val temp = ArrayList<Int>()
        temp.add(nums[0])
        ans.add(temp)//ans is [[1]]
        for (i in 1 until nums.size) {
            val new_ans = ArrayList<List<Int>>()//create a new [[]]
            for (j in 0..i) {
                for (l in ans) {
                    val new_l = ArrayList(l)
                    new_l.add(j, nums[i])
                    new_ans.add(new_l)
                }
            }
            ans = new_ans
        }
        return ans.distinct()//kotlin功能好强大，这种函数都有
    }
}


//这个效率高一些
/*
https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
Sort the array "int[] nums" to make sure we can skip the same value.
when a number has the same value with its previous, we can use this number only if his previous is used
*/

import java.util.ArrayList
import java.util.Arrays

class Solution {
    fun permuteUnique(nums: IntArray?): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        if (nums == null || nums.size == 0) return res
        val used = BooleanArray(nums.size)
        val list = ArrayList<Int>()
        Arrays.sort(nums)//排序
        dfs(nums, used, list, res)
        return res
    }

    fun dfs(nums: IntArray, used: BooleanArray, list: MutableList<Int>, res: MutableList<List<Int>>) {
        if (list.size == nums.size) {
            res.add(ArrayList(list))
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue//用过了不再考虑
            used[i] = true
            list.add(nums[i])
            dfs(nums, used, list, res)
            used[i] = false
            list.removeAt(list.size - 1)
        }
    }
}
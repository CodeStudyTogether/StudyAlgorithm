//https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51636861
//本题用一个数 reach 表示能到达的最远下标，一步步走下去，如果发现在 reach 范围之内某处能达到的范围大于 reach，那么我们就用更大的范围来替换掉原先的 reach，这样一个局部的最优贪心策略，在全局看来也是最优的，因为 局部能够到达的最大范围也是全局能够到达的最大范围：
class Solution {
    fun canJump(A: IntArray): Boolean {
        var max = 0
        for (i in A.indices) {
            if (i > max) {
                return false
            }
            max = Math.max(A[i] + i, max)//表示最远能去的距离，距离数组开头，这个是与上一次相比较。如果不能超出上一次的最远距离，那还是以上一次的最远距离为准
        }
        return true
    }
}

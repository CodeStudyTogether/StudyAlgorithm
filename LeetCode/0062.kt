//https://leetcode.com/problems/unique-paths/discuss/22981/My-AC-solution-using-formula
//https://www.cnblogs.com/z941030/p/5609042.html
//m*n的棋盘，一共需要走(m-1)+(n-1)步，向右走m-1步，向下走n-1步，这(m-1)+(n-1)步中，只要确定了哪些步向右，即同时确定了哪些步向下走，反之亦然。
//答案为C(m+n-2,m-1)，最简单的排列组合。。。
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val N = n + m - 2// how much steps we need to do 我们要走几步
        val k = m - 1 //  我们要向右走几步
        var res = 1.0
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (i in 1..k)
            res = res * (N - k + i) / i
        return res.toInt()
    }
}

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val ret = Array(n) { IntArray(n) }//kotlin中创建二维数组
        var left = -1
        var top = 0
        var right = n - 1
        var down = n - 1
        var count = 1
        while (left <= right) {
            for (j in ++left..right) ret[top][j] = count++
            for (i in ++top..down) ret[i][right] = count++
            for (j in --right downTo left) ret[down][j] = count++
            for (i in --down downTo top) ret[i][left] = count++
        }
        return ret
    }
}
这道题的解法就是直线逻辑

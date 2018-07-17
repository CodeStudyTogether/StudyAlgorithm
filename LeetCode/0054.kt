54. Spiral Matrix

class Solution {//这一题就是顺序思维，直接想怎么做就是如下的解法
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()

        if (matrix.isEmpty()) {
            return res
        }

        var rowBegin = 0
        var rowEnd = matrix.size - 1
        var colBegin = 0
        var colEnd = matrix[0].size - 1

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (j in colBegin..colEnd) {//kotlin的循环，从colBegin到colEnd
                res.add(matrix[rowBegin][j])
            }
            rowBegin++

            // Traverse Down
            for (j in rowBegin..rowEnd) {
                res.add(matrix[j][colEnd])
            }
            colEnd--

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (j in colEnd downTo colBegin) {//kotlin的循环(for( i in 5 downTo 1) println ( i )//输出 5 到 1 的数字  downTo实现倒序循环)
                    res.add(matrix[rowEnd][j])
                }
            }
            rowEnd--

            if (colBegin <= colEnd) {
                // Traver Up
                for (j in rowEnd downTo rowBegin) {
                    res.add(matrix[j][colBegin])
                }
            }
            colBegin++
        }

        return res
    }
}

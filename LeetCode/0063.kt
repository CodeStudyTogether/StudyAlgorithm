internal class Solution {//来自于leetcode的官方解法
    fun uniquePathsWithObstacles(inputGrid: Array<IntArray>): Int {
        val row = inputGrid.size//行
        val column = inputGrid[0].size//列

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (inputGrid[0][0] == 1) {//一些特殊状况的处理
            return 0
        }

        // Number of ways of reaching the starting cell = 1.
        inputGrid[0][0] = 1

        // Filling the values for the first column
        for (i in 1 until row) {//0 until 9 指的是[0,9)，包含0不包含9。
            inputGrid[i][0] = if (inputGrid[i][0] == 0 && inputGrid[i - 1][0] == 1) 1 else 0
        }

        // Filling the values for the first row
        for (i in 1 until column) {//前一个是1，现在是0的话，还是变成1
            inputGrid[0][i] = if (inputGrid[0][i] == 0 && inputGrid[0][i - 1] == 1) 1 else 0
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (i in 1 until row) {
            for (j in 1 until column) {
                if (inputGrid[i][j] == 0) {
                    inputGrid[i][j] = inputGrid[i - 1][j] + inputGrid[i][j - 1]//如果该位置不是障碍，则到达该点的路径条数为能到达它的两个点的路径之和
                } else {
                    inputGrid[i][j] = 0//如果该位置是障碍，则到达该点的路径条数为0
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return inputGrid[row - 1][column - 1]
    }
}

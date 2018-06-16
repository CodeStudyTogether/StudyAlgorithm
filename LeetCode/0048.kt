class Solution {//实在不行，这是一种固定思路，记住即可
    fun rotate(matrix: Array<IntArray>) {//看不懂这两个循环的话，自己在草稿纸上画一画就行了
        for (i in matrix.indices) {//按照主对角线，将对称元素交换
            for (j in i until matrix[0].size) {//not include matrix[0].size
                var temp = 0
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        for (i in matrix.indices) {//按照列，将对称列元素全部交换
            for (j in 0 until matrix.size / 2) {
                var temp = 0
                temp = matrix[i][j]
                matrix[i][j] = matrix[i][matrix.size - 1 - j]
                matrix[i][matrix.size - 1 - j] = temp
            }
        }
    }
}


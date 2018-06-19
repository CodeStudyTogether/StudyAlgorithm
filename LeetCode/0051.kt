import java.util.ArrayList
import java.util.LinkedList

class Solution {//经典的N皇后问题，基本所有的算法书中都会包含的问题
    fun solveNQueens(n: Int): List<List<String>> {//经典解法为回溯递归，一层一层的向下扫描
        val board = Array(n) { CharArray(n) }//对于每种原生类型的数组都有一个特化的类,基本类型的二维数组
        for (i in 0 until n)
            for (j in 0 until n)
                board[i][j] = '.'
        val res = ArrayList<List<String>>()
        dfs(board, 0, res)
        return res
    }
//这种棋盘类的题目一般是回溯法, 依次放置每行的皇后。在放置的时候，要保持当前的状态为合法，即当前放置位置的同一行、同一列、两条对角线上都不存在皇后。
    private fun dfs(board: Array<CharArray>, colIndex: Int, res: MutableList<List<String>>) {
        if (colIndex == board.size) {//表示每行都加好了
            res.add(construct(board))
            return
        }

        for (i in board.indices) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q'
                dfs(board, colIndex + 1, res)
                board[i][colIndex] = '.'
            }
        }
    }

    private fun validate(board: Array<CharArray>, x: Int, y: Int): Boolean {
        for (i in board.indices) {
            for (j in 0 until y) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false
            }
        }

        return true
    }

    private fun construct(board: Array<CharArray>): List<String> {
        val res = LinkedList<String>()
        for (i in board.indices) {
            val s = String(board[i])
            res.add(s)
        }
        return res
    }
}

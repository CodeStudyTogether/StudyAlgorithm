import java.util.HashSet

class Solution {//HashSet 是一个没有重复元素的集合。 它是由HashMap实现的（HashSet中大量调用了HashMap的方法，其内部封装了一个HashMap ），不保证元素的顺序，而且HashSet允许使用 null 元素。
    val qSet = HashSet<Int>()
    val qSet1 = HashSet<Int>()//这两个表示占据的对角线
    val qSet2 = HashSet<Int>()
    fun totalNQueens(n: Int): Int {
        return help(0, 0, n)
    }
//深度优先搜索,我们仅仅用一个一维数组来表示棋盘，即board[i] = j意味着在第i行的皇后放在第j列
    fun help(row: Int, count: Int, n: Int): Int {
        var count = count
        for (col in 0 until n) {//对列进行遍历
            if (qSet.contains(col))//同一个列已经有了，那么立刻返回
                continue
            val diag1 = row - col//这两句是这一题最精妙的地方
            if (qSet1.contains(diag1))
                continue
            val diag2 = row + col//这两句是这一题最精妙的地方
            if (qSet2.contains(diag2))
                continue
            // we can now place a queen here
            if (row == n - 1)
                count++
            else {
                qSet.add(col)
                qSet1.add(diag1)
                qSet2.add(diag2)
                count = help(row + 1, count, n)
                // recover
                qSet.remove(col)
                qSet1.remove(diag1)
                qSet2.remove(diag2)
            }
        }
        return count
    }
}
//同样可以套用上一题的代码，只不过当递归返回条件时，不是将一种可行解加入结果集，而是另计数变量自增，来统计可行解的数量。

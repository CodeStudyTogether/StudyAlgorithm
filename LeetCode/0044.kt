//题意：'?' 可以匹配任何单个字符。'*' 可以匹配任意字符串（包括空字符串）。两个串完全匹配才算匹配成功。
//图（graph）：是一种较线性表和树更为复杂的数据结构，图形结构中，结点之间的关系可以是任意的，图中任意两个数据元素之间都可能相关
//线性表：数据元素之间仅有线性关系，每个数据元素只有一个直接前驱和一个直接后继 
//树：树形结构中，数据元素之间有着明显的层次关系，并且每一层上的数据元素可能和下一层中多个元素（即其孩子结点）相关，但只能和上一层中一个元素（即其双亲结点）相关
//使用深度优先搜索 + 记忆化的版本。
//用一个二维的 boolean 数组来当记忆化数组，记录 s 从 sIndex 开始的后缀 能够匹配上 p 从 pIndex 开始的后缀,this 2d array is important
//Recursive alse very common in algorithm
本质上仍然是搜索+回溯
class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    fun isMatch(s: String?, p: String?): Boolean {
        if (s == null || p == null) {//consider the Boundary conditions
            return false
        }

        val memo = Array(s.length) { BooleanArray(p.length) }//kotlin create 2D Array
        val visited = Array(s.length) { BooleanArray(p.length) }
        return isMatchHelper(s, 0, p, 0, memo, visited)
    }

    private fun isMatchHelper(s: String, sIndex: Int,
                              p: String, pIndex: Int,
                              memo: Array<BooleanArray>,
                              visited: Array<BooleanArray>): Boolean {
        // 如果 p 从pIdex开始是空字符串了，那么 s 也必须从 sIndex 是空才能匹配上
        if (pIndex == p.length) {
            return sIndex == s.length
        }

        // 如果 s 从 sIndex 是空，那么p 必须全是 *
        if (sIndex == s.length) {
            return allStar(p, pIndex)
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex]
        }

        val sChar = s[sIndex]
        val pChar = p[pIndex]
        val match: Boolean

        if (pChar == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited) || isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited)
        } else {
            match = charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited)
        }

        visited[sIndex][pIndex] = true
        memo[sIndex][pIndex] = match
        return match
    }

    private fun charMatch(sChar: Char, pChar: Char): Boolean {
        return sChar == pChar || pChar == '?'
    }

    private fun allStar(p: String, pIndex: Int): Boolean {
        for (i in pIndex until p.length) {//one kotlin array write method
            if (p[i] != '*') {
                return false
            }
        }
        return true
    }
}

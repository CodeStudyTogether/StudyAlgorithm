class Solution {
  //答案来源于leetcode discussion排名第一的答案
  //给定ｎ个数字让求第k个序列
  //假设有四位数字{1， 2， 3， 4}，那么他们能够产生的排列数是什么呢？
  /*
  1 + {2, 3, 4}
  2 + {1, 3, 4}
  3 + {1, 2, 4}
  4 + {1, 2, 3}
  */
    fun getPermutation(n: Int, k: Int): String {
        var k = k
        val pos = 0
        val numbers: ArrayList<Int> = arrayListOf()//kotlin新建arraylist
        val factorial = IntArray(n + 1)
        val sb = StringBuilder()//使用StringBuilder效率更高

        // create an array of factorial(阶乘) lookup(查找)
        var sum = 1
        factorial[0] = 1
        for (i in 1..n) {
            sum *= i
            factorial[i] = sum
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
      //factorial[] = {1, 1!, 2!, 3!, 4!, ... n!}

        // create a list of numbers to get indices（指数）
        for (i in 1..n) {
            numbers.add(i)
        }
        // numbers = {1, 2, 3, 4}

        k--

      //就是比如我是n=4，k=9这种情况：我应该看n=3有多少个数，应该是3！为6个，那么我就用9/6，那么我就是2开头，1，3，4这个组合里找我的后面三位数，同样按照顺序排序。这些都是思路，具体实现可能要多注意，不能在边界条件出错。
        for (i in 1..n) {
            val index = k / factorial[n - i]
            sb.append(numbers.get(index).toString())
            numbers.removeAt(index)
            k -= index * factorial[n - i]
        }

        return sb.toString()
    }
}

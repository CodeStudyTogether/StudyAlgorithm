//43. Multiply Strings
//num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]//这个要举个例子分析一下，把乘法公式写出来
//计算num1[i] * num2[j]的结果，并放在pos[i + j, i + j + 1] 上
//举例999*999=998001不超过6位数
class Solution {
    fun multiply(num1: String, num2: String): String {
        var m: Int = num1.length
        var n: Int = num2.length
        var pos: IntArray = IntArray(m+n)//依次填在这个数组里，最后汇总形成答案
        for(i in m - 1 downTo 0) {
            for(j in n - 1 downTo 0) {
                var mul: Int = (num1.get(i) - '0') * (num2.get(j) - '0')//个位数乘以个位数还是能在这里使用的
                var p1: Int = i + j
                var p2: Int = i + j + 1
                var sum: Int = mul + pos[p2]//计算乘积与进位之和

                pos[p1] += sum / 10
                pos[p2] = (sum) % 10
            }
        }  
        var sb = StringBuilder()
        for(p in pos) 
            if(!(sb.length == 0 && p == 0)) 
                sb.append(p)
        return if(sb.length == 0) "0" else sb.toString()
    }
}
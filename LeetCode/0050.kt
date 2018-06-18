class Solution {//最直观容易想到的方法就是用递归方法求n个x的乘积，注意考虑n的正负号，时间复杂度为O(n),这是直线思维，也是最基本的，下面这个的复杂度应该是logn
    fun myPow(x: Double, m: Int): Double {
        var temp = x
        if (m == 0)
            return 1.0
        temp = myPow(x, m / 2)//折半，这样更快
        return if (m % 2 == 0)
            temp * temp
        else {
            if (m > 0)
                x * temp * temp
            else
                temp * temp / x
        }
    }
}

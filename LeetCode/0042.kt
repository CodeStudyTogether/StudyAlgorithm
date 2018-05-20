//42. Trapping Rain Water
//这一题的题意很好懂，在这里使用kotlin为了更好的了解其语法
//开辟两个数组空间，逐个遍历数组，找出该位置左边的最大值与右边的最大值，分别放到两个数组中。然后对整个数组进行遍历，位置装水后的值不能超过该位置左右最高值中的最小数。该算法需三次遍历数组，但是时间复杂度为O(n)；空间需开辟两个数组空间，空间复杂度为O(n)。
//我发现了一个tip，那就是很多题可以多次循环，也就是顺序逻辑上有多个循环，这样的代码可能也不是那么丑陋
//很多题都是顺序思维，要勇敢的去想，比如这一题，就是每个元素在纵向上能放多少水，加在一起就是最后的答案了
class Solution {
    fun trap(height: IntArray): Int {
        var length: Int
        var maxLeftHeight: Int = 0
        var maxRightHeight: Int = 0;
        var result: Int = 0;
        var temp: Int;
        if (height == null)
            return 0;
        length = height.size
        if (length == 0)
            return 0;
        var leftMaxHeight = IntArray(length);
        var rightMaxHeight = IntArray(length);
        for (i in height.indices) {//顺序遍历，找出每个位置左边的最大值
            leftMaxHeight[i] = maxLeftHeight;
            maxLeftHeight = Math.max(maxLeftHeight, height[i]);//max函数和java用法很类似
        }
        for (i in length - 1 downTo 0) {//倒序遍历，找出每个元素右边的最大值
            rightMaxHeight[i] = maxRightHeight;
            maxRightHeight = Math.max(maxRightHeight, height[i]);
        } 
        for (i in height.indices) {
            temp = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (temp >= height[i])
                result += temp - height[i];
        }
        return result;
    }
}

//42. Trapping Rain Water
//这一题的题意很好懂
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
        for (i in height.indices) {
            leftMaxHeight[i] = maxLeftHeight;
            maxLeftHeight = Math.max(maxLeftHeight, height[i]);
        }
        for (i in length - 1 downTo 0) {
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

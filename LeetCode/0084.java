//https://blog.csdn.net/katrina95/article/details/79125613
//栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
//用栈来做，从左向右扫，当右边大于等于左边，或者栈为空，则将数字压栈；如果右边小于左边，则开始pop栈里的元素并且计算此元素之前的可能的最大面积并更新max，直到遇见比当前元素小的，这些更小的元素往后走还可以更新其长度，因此要留在栈里。基本思想就是，将数值压栈，直到这些数值代表的高度的柱子不能向右再扩展长度了，就计算其面积大小，pop出来，留下还可以拓展的，一直到最后。
//优化的方法可以考虑：双指针节省空间，二分节省时间，加入预判断来剪枝以防止极端值。
class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int length = height.length, maxArea = 0, num = 0;
        for (int i = 0; i <= length; i++) {
            num = (i == length ? 0 : height[i]);
            if (stack.isEmpty() || num >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int temp = stack.pop(), len = 0;
                if (stack.isEmpty()) len = i;
                else len = i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height[temp] * len);
                i--;
            }
        }
        return maxArea;
    }
}

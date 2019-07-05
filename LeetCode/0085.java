//参考自 https://blog.csdn.net/katrina95/article/details/79135307
//https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/LeetCode/Data%20Structure/Stack/LeetCode%20-%2085.%20Maximal%20Rectangle.md
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col + 1];
        height[col] = 0;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= col; j++) {
                if (j == col) {
                    height[j] = 0;
                } else if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
                if (stack.isEmpty() || height[j] >= height[stack.peek()]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                        int temp = stack.pop(), len = 0;
                        if (stack.isEmpty()) len = j;
                        else len = j - 1 - stack.peek();
                        maxArea = Math.max(maxArea, height[temp] * len);
                    }
                    //注意这里不能再用j--,而要用stack.push(j),不然15行的height[j]++就要再加一次，会影响结果。
                    stack.push(j);
                }
            }
        }
        return maxArea;
    }
}

//https://blog.csdn.net/lemon_tree12138/article/details/51176153
class Solution {
    public void setZeroes(int[][] matrix) {
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
      //与上面矩阵对应的是两个标记数组，数组中，如果此行或是此列中存在 0 就置为 0，如果不存在 0 就置为 1。
        boolean[] rawFlags = new boolean[rawLength];
        boolean[] colFlags = new boolean[colLength];
        for (int i = 0; i < rawLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rawFlags[i] = true;
                    colFlags[j] = true;
                }
            }
        }

        // 调整每一行置0
        for (int i = 0; i < rawLength; i++) {
            if (rawFlags[i]) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 调整每一列置0
        for (int i = 0; i < colLength; i++) {
            if (colFlags[i]) {
                for (int j = 0; j < rawLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
//这一题没什么难的，就是顺序思维即可。

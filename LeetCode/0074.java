//将二维数组按行展开的话，就是一个排序的一维数组，因此通过一维数组的二分查找很容易得到答案。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        if(rows > 0){//防止特殊情况[]
            int cols=matrix[0].length;
            int left=0,right=(rows*cols-1);
            int mid,r,c,val;
            while(left<=right){
                mid=left+((right-left)>>1);//右移运算符，num >> 1,相当于num除以2
                r=mid/cols;
                c=mid%cols;
                if(matrix[r][c]==target)
                    return true;
                if(matrix[r][c]<target)
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return false;
    }
}

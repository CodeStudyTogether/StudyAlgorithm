//这是我的答案
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int total = 0;
        for(int i = 0; i < nums.length - 2 - total; i++){
            if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]){
                total++;
                for(int j = i + 2; j < nums.length - total; j++){
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        return nums.length - total;
    }
}

//这是leetcode的答案
//这里允许最多重复的次数是两次，那么我们就需要用一个变量count来记录还允许有几次重复，count初始化为1，如果出现过一次重复，则count递减1，那么下次再出现重复，快指针直接前进一步，如果这时候不是重复的，则count恢复1，由于整个数组是有序的，所以一旦出现不重复的数，则一定比这个数大，此数之后不会再有重复项。
class Solution {
    public int removeDuplicates(int A[]) {
        if (A.length <= 2) return A.length;
        int pre = 0, cur = 1, count = 1;
        while (cur < A.length) {
            if (A[pre] == A[cur] && count == 0) ++cur;
            else {
                if (A[pre] == A[cur]) --count;
                else count = 1;
                A[++pre] = A[cur++];
            }
        }
        return pre + 1;
    }
}

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
在计算机科学中，一个原地算法（in-place algorithm）是一种使用小的，固定数量的额外之空间来转换资料的算法。 当算法执行时，输入的资料通常会被要输出的部份覆盖掉。 
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
two-pass是一种找连通域的算法，只要对图做两次遍历，就能够对相同连通域内的点打上相同的label。
计数排序  
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
  
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length > 1){
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = 0; j < nums.length - 1 - i; j++){
                    if(nums[j] > nums[j + 1]){
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }
}

如果只能扫一遍，很容易想到的就是左边存放0和1，右边存放2.两边往中间靠。
class Solution {
   public void sortColors(int[] nums) {
		int j = 0, k = nums.length - 1;
		for (int i = 0; i <= k; i++) {
			// 遇到0和前面的交换
			if (nums[i] == 0)
				swap(nums, i, j++);
			// 遇到2和后面的交换
			else if (nums[i] == 2)
				swap(nums, i--, k--);
		}
	}
 
	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}

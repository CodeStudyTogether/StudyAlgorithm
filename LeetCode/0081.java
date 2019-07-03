这一题不按照题者思路写，可以暴力遍历，当然效率很低，不可取
class Solution {
    public boolean search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                return true;
            }
        }
        return false;
    }
}

https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51602234

排序好的东西找元素，优先考虑二分查找法
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) left++;
            else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}

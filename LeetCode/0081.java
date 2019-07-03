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

public class Solution {
  //还是利用递归的方式，在前一种情况的基础上遍历下一轮的组合情况。
    private void solve(List<List<Integer>> res, int[] nums, List<Integer> tmpList, int index){
        if(index==nums.length){
            res.add(new LinkedList(tmpList));
            return;
        }
        solve(res,nums,tmpList,index+1);
        tmpList.add(nums[index]);
        solve(res,nums,tmpList,index+1);
        tmpList.remove(tmpList.size()-1);
    }
  
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmpList = new LinkedList<>();

        Arrays.sort(nums);//先排序
        solve(res, nums, tmpList, 0);

        return res;
    }
}

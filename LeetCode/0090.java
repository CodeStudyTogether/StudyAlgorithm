/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
**/

//http://www.noteanddata.com/leetcode-90-Subsets-II-amazon-interview-problem-java-solution-note.html
//https://blog.csdn.net/shenzhu0127/article/details/51902099
//https://www.cnblogs.com/grandyang/p/4310964.html
//https://zhanghuimeng.github.io/post/leetcode-90-subsets-ii/
//Amazon
//主要过程仍然是在n个数里面选k个数的组合模版， 然后对k从0到n进行循环

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);/先排序
        Set<List<Integer>> allList = new HashSet<>();//set没有重复元素
        for(int i = 0; i <= nums.length; ++i) {
            backtrack(nums, 0, i, new ArrayList<>(), allList);    
        }

        return new ArrayList<>(allList);
    }

    public void backtrack(int[] nums, int from, int count, List<Integer> list, Set<List<Integer>> allList) {
        if(list.size() == count) {
            allList.add(new ArrayList<>(list));
            return;
        }
        for(int i = from; i < nums.length; ++i) {
            list.add(nums[i]);
            backtrack(nums, i+1, count, list, allList);
            list.remove(list.size()-1);
        }
    }
}

//https://blog.csdn.net/fuxuemingzhu/article/details/70209865
//根据BST的定义，左子树的值要在(min,mid)之间，右子树的值在(mid,max)之间，这个mid值并不是中位数而是当前节点的值。
//https://www.cnblogs.com/xiaoba1203/p/5997741.html

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long)(Integer.MIN_VALUE)-1, (long)(Integer.MAX_VALUE)+1);
    }
    private boolean dfs(TreeNode root, long gt, long lt){
        if(root == null) return true;
        if(root.val >= lt || root.val <= gt) return false;
        return dfs(root.left, gt, root.val) && dfs(root.right, root.val, lt);
    }
}

//https://blog.csdn.net/github_34514750/article/details/52211896
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
二叉搜索树BST：
从微观上来讲，BST的每个节点都大于其左节点，且小于其右节点。
从宏观上来将，BST的每个节点都大于其左子树的每个节点，且小于其右子树的每个节点。
一棵BST的中序遍历是有序的。这个性质我们称为BST的单调性。

本题用动态规划
分治法和动态规划
相同点：都是将原问题分而治之,分解成若干个规模较小
区别：
分治法常常利用递归求解，分解后的子问题看成相互独立的
动态规划通常利用迭代自底向上求解，或者具有记忆能力对桂法自顶向下，其分解的子问题理解成相互有联系的
思路：
1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
3. 最后，把根结点放入list中。
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
         if(n < 1) {
             return new ArrayList<TreeNode>();//特殊状况
         }
         return generate(1,n);
    }

    public List<TreeNode> generate(int start,int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 加null至关重要
        if(start > end) {
            list.add(null);
            return list;
        }

        // 确定根节点
        for(int i = start;i <= end;i++) {//把每个节点都遍历一遍
            // 确定左右子树
            List<TreeNode> left = generate(start,i-1);
            List<TreeNode> right = generate(i+1,end);
            for(TreeNode leftT:left) {
                for(TreeNode rightT:right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftT;
                    root.right = rightT;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
//当前的递归中，假设root为i。那么显然左子树是由[1,i-1]构成的所有可能的组合，显然右子树是由[i+1,n]构成的所有可能的组合（可以统一记录为，用[start, end]去构建树）。在有了左子树，root，右子树的情况下，根据乘法原理很容易计算得出在当前情况下的所有的树。
//http://www.liuhaihua.cn/archives/527583.html

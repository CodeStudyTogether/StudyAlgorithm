首先，沿着95题，但是这么写在test case比较大的时候会超时
public class Solution {
    public int numTrees(int n) {
         if(n < 1) {
             return 0;//特殊状况
         }
        List<TreeNode> list = generate(1,n);
         return list.size();
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

这是别人的答案：https://blog.csdn.net/mine_song/article/details/70552503

public class Solution {
    	public int numTrees(int n) {
            // 注意细节n+1
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // n>=2时处理方式
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++)
                    dp[i] += dp[j - 1] * dp[i - j];
            }
            return dp[n];
	    }
}

二叉搜索树：又称二叉查找树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。

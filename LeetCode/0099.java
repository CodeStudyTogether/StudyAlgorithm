/**
https://www.cnblogs.com/xiaoba1203/p/5998745.html
给定一个排序二叉树，然后任意交换了其中两个节点，要求在使用常数个空间和不改变结构的前提下恢复原来的二叉树。
https://www.cnblogs.com/grandyang/p/4298069.html
first，second分别表示第一个和第二个错乱位置的节点，pre指向当前节点的中序遍历的前一个节点。这里用传统的中序遍历递归来做，不过再应该输出节点值的地方，换成了判断pre和当前节点值的大小，如果pre的大，若first为空，则将first指向pre指的节点，把second指向当前节点。这样中序遍历完整个树，若first和second都存在，则交换它们的节点值即可。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode pre;        
    TreeNode first;    
    TreeNode second;
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null){
                    first = pre;        
                }
                second = root;        
            }
            pre = root;                
        }
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        pre = null;            
        first = null;
        second = null;
        inorder(root);
        if(first!=null && second!=null){    
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}

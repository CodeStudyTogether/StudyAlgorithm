// inorder traversal  中序遍历
// binary tree 二叉树
//二叉树的意思就是说：每个节点不能多于有两个儿子
//无论是在遍历树、查找深度、查找最大值都用到了递归，递归在非线性的数据结构中是用得非常多的...
//https://blog.csdn.net/NoMasp/article/details/50930671

//这是遍历的方案：
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> arrayList = new ArrayList();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            arrayList.add(root.val);
            inorderTraversal(root.right);
        }
        return arrayList;
    }
}

//https://blog.csdn.net/u013564276/article/details/51232927
//中序遍历就是先访问左孩子的值，再访问父节点的值，最后访问右孩子的值。这样的话，一棵树的最最左边的子节点的值一定是第一个被访问的
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 一棵树的最最左边的子节点的值一定是第一个被访问的
 所以实现起来的思路就是，沿着树一直向左走，直到走不动为止，这个时候再看看当前节点是否有右节点，如果有的话对该又节点进行前面的操作。
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack stack = new Stack(); // 创建堆栈对象 
        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = (TreeNode)stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}

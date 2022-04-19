/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    leftDepth := maxDepth(root.Left)
    rightDepth := maxDepth(root.Right)
    if leftDepth >= rightDepth {
        return 1 + leftDepth
    }
    return 1 + rightDepth
}

//我们的思路是对于求整棵树的深度，就是根节点的左子树的深度或者根结点的右子树的深度加1，那么，使用递归的方式就是
//depth(root)=1+max(depth(root.Left),depth(root.Right))

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 二叉树
append主要用于给某个切片（slice）追加元素
如果该切片存储空间（cap）足够，就直接追加，长度（len）变长；如果空间不足，就会重新开辟内存，并将之前的元素和新的元素一同拷贝进去
第一个参数为切片，后面是该切片存储元素类型的可变参数
跟arraylist类似，记住新的是旧的拷贝得到的
 * }
 https://www.youtube.com/watch?v=Tuij96VBdu8
 DFS & BFS
 */
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	var ret [][]int
	for child := []*TreeNode{root}; child != nil; child = levelSubTreeNode(child) {
		vals := make([]int, len(child))
		for i, n := range child {
			vals[i] = n.Val
		}
		ret = append(ret, vals)
	}
	return ret
}

func levelSubTreeNode(nodes []*TreeNode) (child []*TreeNode) {
	for _, n := range nodes {
		if n.Left != nil {
			child = append(child, n.Left)
		}
		if n.Right != nil {
			child = append(child, n.Right)
		}
	}
	return
}

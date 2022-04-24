/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
    if len(preorder) == 0 {
        return nil
    }

    root := &TreeNode {
        Val : preorder[0],
        Left: nil,
        Right: nil,
    }

    i := 0;
    for ;i < len(inorder); i++ {
        if root.Val == inorder[i] {
            break
        }
    }

    root.Left = buildTree(preorder[1:i+1], inorder[:i])//递归,将 arr 中从下标 startIndex 到 endIndex-1 下的元素创建为一个新的切片。
    root.Right = buildTree(preorder[i+1:], inorder[i+1:])//Go 语言切片是对数组的抽象。
    return root //Go 数组的长度不可改变，在特定场景中这样的集合就不太适用，Go 中提供了一种灵活，功能强悍的内置类型切片("动态数组")，与数组相比切片的长度是不固定的，可以追加元素，在追加时可能使切片的容量增大。
}

//经典的二叉建树题目
//给定前序遍历和中序遍历可以建立唯一二叉树，给定后序遍历和中序遍历可以建立二叉树。
/*
    根据preorder找到根节点，即preorder[0]
    在inorder中找到左子树和右子树 即inorder[:i]以及inorder[i+1:]
    在preorder中找到左子树和右子树，preorder[1:i+1]以及inorder[i+1:]
    递归构建左子树和右子树
    */

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

//切片是会自动扩容的，当前容量不足时，会自动根据最佳情况进行扩容（这里就不展开了），但是要知道一点，扩容是重新申请一块内存，也就是说之前的内存没有用上了
//如果从新的slice再切，那么新创建的两个切片都共享这个底层的匿名数组。
//当然，这种结构也不是完美无暇，共用底层数组，在部分修改操作的时候，可能带来副作用，同时如果一个很大的数组，那怕只有一个元素被切片应用，那么剩下的数组都不会被垃圾回收，这往往也会带来额外的问题。

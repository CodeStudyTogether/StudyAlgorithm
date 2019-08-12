/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 * 使用递归法（Recursive）解决。
 */
var isSame = function (left, right) {
    if (!left && !right) return true;
    if (!left || !right || right.val !== left.val) return false;
    return isSame(left.left, right.right) && isSame(left.right, right.left);//逐级比较
};

var isSymmetric = function(root) {
    if (!root) return true;
    return isSame(root.left, root.right);//从根目录开始遍历
};

package org.example

import kotlin.math.abs

object Workshop {


    // 110. Balanced Binary Tree
    fun isBalanced(root: TreeNode?): Boolean {
        return treeNodeHeight(root) != -1
    }

    private fun treeNodeHeight(node: TreeNode?): Int {
        node ?: return 0
        val leftHeight = treeNodeHeight(node.left)
        val rightHeight = treeNodeHeight(node.right)
        if (leftHeight == -1 || rightHeight == -1) return -1
        if (abs(leftHeight - rightHeight) > 1) return -1
        return maxOf(leftHeight, rightHeight) + 1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
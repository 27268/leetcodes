package convertBSTtoBiLink;

import Utils.TreeNode;

public class Solution {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     *
     * 思路：BST的中序遍历是有序序列
     * 提示：跟着中序走一遍，确定代码执行的时机
     */
    TreeNode max = null;
    TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        /**
         * 用例:
         * {10,6,14,4,8,12,16}
         *
         * 对应输出应该为:
         *
         * From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
         *
         * 你的输出为:
         *
         * From left to right are:16;From right to left are:16,14,12,10,8,6,4;
         * 更正：返回head
         */
        if(pRootOfTree==null)
            return null;
        Convert(pRootOfTree.left);
        if(max == null){ // 到BST的最左端才能执行到
            max = pRootOfTree;
            head = pRootOfTree;
        }else {
            max.right = pRootOfTree;
            pRootOfTree.left = max;
            max = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;//
    }
}

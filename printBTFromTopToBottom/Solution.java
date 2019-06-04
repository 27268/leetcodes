package printBTFromTopToBottom;

import java.util.ArrayList;
import Utils.TreeNode;

public class Solution {
    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        TreeNode temp =  null;
        while (!queue.isEmpty()){
            temp  = queue.remove(0);
            result.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return result;
    }
}

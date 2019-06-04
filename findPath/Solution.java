package findPath;

import java.util.ArrayList;
import Utils.TreeNode;

public class Solution {
    /**
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     *
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null) return result;
        target-=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && target==0){
            result.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //基本数据类型传值，函数中修改无效；引用类型传递引用，在函数中修改有效
        path.remove(path.size()-1);
        return result;
    }

}

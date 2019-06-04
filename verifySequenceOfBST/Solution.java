package verifySequenceOfBST;

public class Solution {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return isBiTree
     *
     *       10
     *     /    \
     *    6     14
     *   / \   /  \
     *  4  8  13  16
     *
     * 二叉搜索树：
     *     若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     *     若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     *     它的左、右子树也分别为二叉排序树。
     * 后序遍历：4, 8, 6, 13, 16, 14, 10
     *
     * 参考Mark in 牛客：
     * BST的后序序列的合法序列是，对于一个序列S，
     * 最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
     * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
     * 且这两段（子树）都是合法的后序序列。完美的递归定义。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        switch (sequence.length){
            case 0:
            case 1:
            case 2:return true;
            case 3:
                if(sequence[0]<sequence[2] && sequence[1]>sequence[2])
                    return true;
                else
                    return false;
            default:
                return verifyBST(sequence, 0, sequence.length-1);
        }
    }
    //[7,4,6,5]
    boolean verifyBST(int[] sequence, int start, int end){
        //确定左右子树的分界点：sequene[i]<root && sequence[i+1]>root
        //[start, i] 左子树, [i+1, end-1] 右子树
        if(start>=end) return true;
        int right = end, i=start; // right = i+1
        for ( ;i<end;i++){
            if(sequence[i]<sequence[end]){
            }else {
                right = i;
                break;
            }
        }
        for(;i<end;i++){
            if(sequence[i] < sequence[end]){
                return false;
            }
        }
        return verifyBST(sequence, start,right-1) && verifyBST(sequence, right, end-1);
    }
}

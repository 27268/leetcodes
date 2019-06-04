package clone;

import Utils.RandomListNode;

public class Solution {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * 难点：随机指针的复制
     */
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) //空链表
            return null;
        RandomListNode p = pHead;
        RandomListNode temp;
        while (p!=null){ //复制节点,p = 1
            temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        p = pHead;
        //循环终止条件：
        while (p!=null){//复制random指针, p=1, q=1';
//            p.next.random = p.random.next;
            p.next.random = p.random==null?null:p.random.next;
            p = p.next.next;
        }
        RandomListNode newHead = pHead.next;
        p = pHead;
        RandomListNode q;
        while (p!=null){//拆分链表,终止条件：
            q = p.next; //若 p.next = null, q.next 空指针？
            p.next = q.next;
            q.next = q.next==null?null:q.next.next;
            p = p.next;
        }
        return newHead; //空指针异常
    }

}

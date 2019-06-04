import java.util.Iterator;
import java.util.Stack;

public class MinStack {
    //定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
    private Stack<Integer> stack = new Stack<Integer>();
    // private int min;
    public void push(int node) {
        //if( node<min ){
        //    min = node;
        //}
        stack.push(node);
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        int temp, min = stack.peek();
        Iterator it = stack.iterator();
        while (it.hasNext()){
            temp = (int)it.next();
            if(temp<min){
                min = temp;
            }
        }
        return min;
    }
}

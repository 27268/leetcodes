package getLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //运行时间：26ms
        //占用内存：9668k
        ArrayList<Integer> res = new ArrayList<>();
        if(k>input.length)
            return res;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(k>input.length || k==0)
            return res;
        PriorityQueue<Integer> maxList = new PriorityQueue(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1; //默认是o1-o2，head是最小的数字，这里需要head是最大的
            }
        });
        for(int i=0;i<k;i++){
            maxList.add(input[i]);
        }
        for(int i=k; i<input.length; i++){
            if(input[i]< maxList.peek()){
                maxList.poll();
                maxList.add(input[i]);
                //max的更新是个问题
                //只要res有序，每次对最大元素操作即可
            }
        }
        return new ArrayList<>(maxList); //运行时间：32ms 占用内存：9636k
    }

}

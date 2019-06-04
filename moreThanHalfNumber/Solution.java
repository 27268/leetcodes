package moreThanHalfNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 18 ms	9304K
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> bag = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(bag.containsKey(array[i])){
                bag.put(array[i], bag.get(array[i])+1);
            }else {
                bag.put(array[i], 1);
            }
        }
        int most = 0, res=0, current;
        Iterator it = bag.keySet().iterator();
        while (it.hasNext()){
            current = (int)it.next();
            if(bag.get(current)>most){
                most = bag.get(current);
                res = current;
            }
        }
        if(most*2 > array.length){
            return res;
        }else {
            return 0;
        }

    }
    /**
     * 若存在出现的次数超过数组长度的一半，则对数组排序后中间的数字一定是这个值
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        if(array.length==0)
            return 0;
        Arrays.sort(array);
        int middle = array[array.length/2], times = 0;
        for(int i=0;i<array.length;i++){
            if(middle==array[i]){
                times++;
            }
        }
        if(times > array.length>>1){
            return middle;
        }else {
            return 0;
        }
    }
    /**
     * 符合条件的数在数组中出现的次数比其他所有数出现的次数之和更多，
     * 记录出现次数最多的数字，判断该数字出现的次数是否大于数组长度的一版
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int [] array){
        //16ms, 9072kb
        if(array.length==0)
            return 0;
        int res = array[0], times = 1;
        for (int i=1;i<array.length;i++){
            if(array[i]==res){
                times++;
            }else {
                times--;
            }
            if(times==0){
                times = 1;
                res = array[i];
            }
        }
        times = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==res){
                times++;
            }
        }
        if(times > array.length>>1){
            return res;
        }else {
            return 0;
        }
    }

}

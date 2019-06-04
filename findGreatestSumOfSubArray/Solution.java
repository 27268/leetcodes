package findGreatestSumOfSubArray;

public class Solution {

    /**
     * 给一个数组，返回它的最大连续子序列的和，
     * 状态定义: 参考 小新没有蜡笔~ in nowcoder
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     *
     * 最大子序列的和为:max(F(i))
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = array[0];
        for(int i=1; i<array.length; i++){
            sum = Math.max(sum+array[i], array[i]); //F(i)
            max = Math.max(max, sum); //max(F(i))
        }
        return max;
    }

}

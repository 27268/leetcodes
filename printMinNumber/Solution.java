package printMinNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    public String PrintMinNumber(int [] numbers) {
        //运行时间：35ms
        //
        //占用内存：9696k
        List<String> stringList = new LinkedList<>();
        String s;
        int length = 0;
        for(int i=0;i<numbers.length;i++){
            s = "" + numbers[i];
            length += s.length();
            stringList.add("" + numbers[i]);
        }
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 参考 飞dsadsadasd in nowcoder
                //总结: 要找拼接起来比较小的序列, 就用 拼接结果 作为比较器 进行排序
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        String res = "";
        for(int i=0;i<stringList.size();i++){
            res += stringList.get(i);
        }
        return res;
    }

}

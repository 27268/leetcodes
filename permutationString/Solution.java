package permutationString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 输入说明：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * 输出：可以直接在返回之前对ArrayList排序
     * 运行时间：170ms, 占用内存：12076k
     */
    ArrayList<String> stringList = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        permutationInArray(chars, 0);
        Set<String> set = new HashSet<>(stringList);
        Collections.sort(stringList);
        return stringList;
    }
    void permutationInArray(char[] chars, int start){
        if(start==chars.length-1){
            String s = new String(chars);
            if(!stringList.contains(s)){
                stringList.add(s);
            }
            return;
        }
        char temp;
        for(int i=start; i<chars.length; i++){
            if(chars[start]==chars[i] && start!=i)
                continue;//剪枝后：运行时间：194ms，占用内存：12232k？
            temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
            permutationInArray(chars,start+1);
            temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
        }
    }

}

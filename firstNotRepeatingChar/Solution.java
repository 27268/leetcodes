package firstNotRepeatingChar;

import java.util.*;

public class Solution {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中
     * 找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.
     *
     */
    public int FirstNotRepeatingChar(String str) {
        //运行时间：57ms
        //
        //占用内存：10076k
        char[] chars = str.toCharArray();
        List<Character> charSet = new LinkedList<>();
        List<Integer> timesSet = new LinkedList<>();
        int index;
        for(int i=0;i<chars.length;i++){
            if(charSet.contains(chars[i])){
                index = charSet.indexOf(chars[i]);
                timesSet.set(index, 1+timesSet.get(index));
            }else {
                charSet.add(chars[i]);
                timesSet.add(1);
            }
        }
        for(int i=0;i<timesSet.size();i++){
            if (timesSet.get(i)==1){
                return str.indexOf(charSet.get(i));
            }
        }
        return -1;
    }
    public int FirstNotRepeatingChar1(String str) {
        //运行时间：46ms
        //
        //占用内存：9784k
        List<Character> charSet = new LinkedList<>();
        List<Integer> timesSet = new LinkedList<>();
        int index;
        for(int i=0;i<str.length();i++){
            if(charSet.contains(str.charAt(i))){
                index = charSet.indexOf(str.charAt(i));
                timesSet.set(index, 1+timesSet.get(index));
            }else {
                charSet.add(str.charAt(i));
                timesSet.add(1);
            }
        }
        for(int i=0;i<timesSet.size();i++){
            if (timesSet.get(i)==1){
                return str.indexOf(charSet.get(i));
            }
        }
        return -1;
    }
    //Map的顺序遍历问题:map底层是红黑树,要按字符串中的顺序遍历
    public int FirstNotRepeatingChar2(String str) {
        //运行时间：50ms
        //
        //占用内存：10048k
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++){
            map.put(str.charAt(i), map.get(str.charAt(i))==null?1:(map.get(str.charAt(i))+1));
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 参考 风林火山_kelvin: 思路有问题,eg: 测试用例aaa,正确输出:-1, 实际输出:0
     *         if(str == null || str.length()==0) return -1;
     *         List<Character> list = new ArrayList<>();
     *         for(int i=0;i<str.length();i++){
     *             char ch = str.charAt(i);
     *             if(!list.contains(ch)){
     *                 list.add(Character.valueOf(ch));
     *             }else{
     *                 list.remove(Character.valueOf(ch));
     *             }
     *         }
     *         if(list.size() <=0) return -1;
     *         return str.indexOf(list.get(0));
     */
    public int FirstNotRepeatingChar3(String str) {
        //运行时间：51ms
        //
        //占用内存：9752k
        List<Character> list = new LinkedList<>();
        Set<Character> removed = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(!list.contains(ch)){
                if(!removed.contains(ch))
                    list.add(ch);
            }else {
                removed.add(ch);
                list.remove(ch);
            }
        }
        if(list.size()>0){
            return str.indexOf(list.get(0));
        }
        return -1;

    }


}

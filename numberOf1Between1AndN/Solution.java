package numberOf1Between1AndN;

public class Solution {
    /**
     * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        //运行时间：25ms
        //占用内存：9336k
        int count = 0;
        for(int i=1; i<=n; i++){
            count += numberOf1(i);
        }
        return count;
    }
    int numberOf1(int n){
        int count = 0, r = n%10;
        while (n!=0){
            count += r==1?1:0;
            n = n/10;
            r = n%10;
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution1(int n){
        //运行时间：19ms
        //
        //占用内存：9304k
        /**
         * 个位上的1: r = n / 10, s = n % 10, k=1
         *     r+ (s==0?0:1), 即 r+min(1, s-0)
         *
         * 十位上的1: r = n /100, s = n % 100 k = 10
         *     r*10 + min(10, s-9)
         *
         * 百位上的1: r = n / 1000, s = n % 1000 k=100
         *     r*100 + min(100, s-99)
         *
         * n = 13: 个位上的1: 1+1 = 2
         *         十位上的1: 0+min(13-9)=4
         * n = 233: 个位: 23 + 1 = 24
         *          十位: 2*10 + min(10, 33-9) = 30
         *          百位: 0 + min(100, 233-99) = 100
         */
        int count = 0;
        int r, s, t, k=1, tempN = n;
        while (n>=k){
            r = tempN/10;
            s = n - r*k*10;
            if(s>0){
                t = Math.min(k, s-k+1);
            }else{
                t = 0;
            }

            count = count + r*k + t;
            tempN = tempN / 10;
            k = k*10;
        }
        return count;
    }

}

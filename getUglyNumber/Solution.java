package getUglyNumber;

public class Solution {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *
     * f(n) = min()
     *
     * 丑数 = 2^m * 3^n * 5^t
     * 2 4 8
     * 3 6 9
     * 5 10
     *
     * (0, 0, 0) - 1
     * (0, 0, 1) - 2  2
     * (0, 1, 0) - 3
     * (0, 0, 2) - 4
     * (1, 0, 0) - 5
     *
     * (0, 1, 1) - 6
     * (0, 0, 3) - 8  7
     * (0, 2, 0) - 9
     * (1, 0, 1) - 10
     * (0, 1, 2) - 12
     * (1, 1, 0) - 15
     * (0, 0, 4) - 16  12
     * (0, 2, 1) - 18
     * (1, 0, 2) - 20
     * (0, 1, 3) - 24
     * (2, 0, 0) - 25
     * (0, 3, 0) - 27
     * (1, 1, 1) - 30
     * (0, 0, 5) - 32 - 19
     * (0, 2, 2) - 36
     * (1, 0, 3) - 40
     * (1, 2, 0) - 45
     * (0, 1, 4) - 48
     * (2, 0, 1) - 50
     * (0, 3, 1) - 54
     *
     */
    public int GetUglyNumber_Solution(int index) {
        //超时
        if(index<7)
            return index;
        int uglyNumbers[] = new int[index];
        int currentIndex = 1, currentNum = 2;
        uglyNumbers[0] = 1;
        while (currentIndex<index){
            if(isUgly(currentNum)){
                uglyNumbers[currentIndex] = currentNum;
                currentIndex++;
            }
            currentNum++;
        }
        return uglyNumbers[index-1];
    }
    boolean isUgly(int n){
        while (n%2 == 0){
            n = n/2;
        }
        while (n%3 == 0){
            n = n/3;
        }
        while (n%5 == 0){
            n = n/5;
        }
        if(n==1)
            return true;
        else
            return false;
    }
    /**
     * 参考:http://wiki.jikexueyuan.com/project/for-offer/question-thirty-four.html
     * uglyNumbers[p2]*2>=uglyNumbers[current] && uglyNumbers[p2 - 1]*2 < uglyNumbers[current]
     * uglyNumbers[p3]*3>=uglyNumbers[current] && uglyNumbers[p3 - 1]*3 < uglyNumbers[current]
     * uglyNumbers[p5]*5>=uglyNumbers[current] && uglyNumbers[p5 - 1]*5 < uglyNumbers[current]
     *
     * 下一个数添加到 current 的位置
     */
    public int GetUglyNumber_Solution1(int index) {
        //运行时间：17ms
        //
        //占用内存：9328k
        int [] uglyNumbers = new int[index];
        int current = 1;
        uglyNumbers[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        for(; current<index; current++){
            uglyNumbers[current] = min(2*uglyNumbers[p2], 3*uglyNumbers[p3], 5*uglyNumbers[p5]);
            if(uglyNumbers[current] == 2*uglyNumbers[p2]){
                p2++;
            }
            if(uglyNumbers[current] == 3*uglyNumbers[p3]){
                p3++;
            }
            if(uglyNumbers[current] == 5*uglyNumbers[p5]){
                p5++;
            }
        }
        return uglyNumbers[index-1];
    }
    int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

}

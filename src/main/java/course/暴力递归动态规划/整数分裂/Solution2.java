package course.暴力递归动态规划.整数分裂;

import org.junit.Test;

/**
 * @author by catface
 * @date 2021/4/16 2:24 下午
 */
public class Solution2 {

    //给定一个正数n，求n的裂开方法数，
    //规定：后面的数不能比前面的数小
    //比如4的裂开方法有：
    //1+1+1+1、1+1+2、1+3、2+2、4
    //5种，所以返回5

    public int splitInteger(int number) {
        return process(1, number);
    }

    public int process(int currentInt, int leftNumber) {
        // 剩余数字为0,找到一种分裂方案
        if (leftNumber == 0) {
            return 1;
        }
        // 剩余可分裂的数字小于0,说明之前的分裂组合无效
        if (leftNumber < 0) {
            return 0;
        }
        // 在以上情况未命中的前提下,尝试用于裂变的数字已经超过剩余的数值,无效的分裂组合
        if (currentInt > leftNumber) {
            return 0;
        }

        // 常规情况下
        int ways = 0;
        for (int chooseTimes = 0; chooseTimes * currentInt <= leftNumber; chooseTimes++) {
            ways += process(currentInt + 1, leftNumber - chooseTimes * currentInt);
        }
        return ways;
    }

    public int process2(int currentInt, int leftNumber) {
        // 剩余数值和当前尝试的数字相等,发现一种方案
        // TODO 此处与leftNumber==0效果相同,但是,在构建动态规划时,base case 填表的逻辑不相同
        if (currentInt == leftNumber){
            return 1;
        }
        // 剩余可分裂的数字小于0,说明之前的分裂组合无效
        if (leftNumber < 0) {
            return 0;
        }
        // 在以上情况未命中的前提下,尝试用于裂变的数字已经超过剩余的数值,无效的分裂组合
        if (currentInt > leftNumber) {
            return 0;
        }

        // 常规情况下
        int ways = 0;
        for (int chooseTimes = 0; chooseTimes * currentInt <= leftNumber; chooseTimes++) {
            ways += process2(currentInt + 1, leftNumber - chooseTimes * currentInt);
        }
        return ways;
    }

    public static class TestClass {
        @Test
        public void test1() {
            int number = 4;
            Solution2 solution = new Solution2();
            int ways = solution.splitInteger(number);
            System.out.println("分裂方案数:" + ways);
        }

        @Test
        public void test2() {
            for (int number = 1; number < 50; number++) {
                Solution2 solution = new Solution2();
                int ways = solution.splitInteger(number);
                int ways2 = Code03_SplitNumber.dp1(number);
                if (ways != ways2) {
                    System.out.println("裂变不一致:" + number);
                }
                assert ways == ways2;
            }
            System.out.println("Good,you success!");
        }
    }

}

package com.algorithm.leetcode.动态规划.P198打家劫舍;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics 动态规划
// 👍 1418 👎 0

import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 超时
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return process(nums, 0);
    }

    private int process(int[] nums, int current) {

        if (current >= nums.length) {
            return 0;
        }

        // 选择当前房屋进行抢劫,下一个房间不能抢劫
        int chooseCurrent = nums[current] + process(nums, current + 2);

        // 不选择当前房屋进行抢劫
        int notChooseCurrent = process(nums, current + 1);

        return Math.max(chooseCurrent, notChooseCurrent);
    }

    public static class TestClass {

        //输入：[1,2,3,1]
        //输出：4
        //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        //     偷窃到的最高金额 = 1 + 3 = 4 。
        @Test
        public void test1() {
            int[] nums = {1, 2, 3, 1};
            Solution solution = new Solution();
            int ans = solution.rob(nums);
            System.out.println(ans);
        }

        //输入：[2,7,9,3,1]
        //输出：12
        //解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        @Test
        public void test2() {
            int[] nums = {2, 7, 9, 3, 1};
            Solution solution = new Solution();
            int ans = solution.rob(nums);
            System.out.println(ans);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


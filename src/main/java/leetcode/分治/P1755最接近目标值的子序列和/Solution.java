package leetcode.分治.P1755最接近目标值的子序列和;

//给你一个整数数组 nums 和一个目标值 goal 。
//
// 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum -
// goal) 。
//
// 返回 abs(sum - goal) 可能的 最小值 。
//
// 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [5,-7,3,5], goal = 6
//输出：0
//解释：选择整个数组作为选出的子序列，元素和为 6 。
//子序列和与目标值相等，所以绝对差为 0 。
//
//
// 示例 2：
//
// 输入：nums = [7,-9,15,-2], goal = -5
//输出：1
//解释：选出子序列 [7,-9,-2] ，元素和为 -4 。
//绝对差为 abs(-4 - (-5)) = abs(1) = 1 ，是可能的最小值。
//
//
// 示例 3：
//
// 输入：nums = [1,2,3], goal = -7
//输出：7
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 40
// -107 <= nums[i] <= 107
// -109 <= goal <= 109
//
// Related Topics 分治算法
// 👍 40 👎 0

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.ArrayUtil;

//leetcode submit region begin(Prohibit modification and deletioni)
@Slf4j
public class Solution {

    // 5:38 下午	info
    //				运行失败:
    //				Time Limit Exceeded
    //				测试用例:[3346,-3402,-9729,7432,2475,6852,5960,-7497,3229,6713,8949,9156,3945,-8686,1528,5022,-9791,
    //				-3782,-191,-9820,7720,-6067,-83,6793,340,7793,8742,8067]
    //				-20357
    //				stdout:

    Set<Integer> left = new HashSet<>();
    Set<Integer> right = new HashSet<>();

    public int minAbsDifference(int[] nums, int goal) {
        // 数据量范围
        // 1 <= nums.length <= 40
        // -107 <= nums[i] <= 107
        // -109 <= goal <= 109

        // 数组分左右两部分,各自计算子序列和
        // 最接近目标的子序列,要么出现在左侧,要么出现在右侧,要么左右两侧各有一部分
        int mid = nums.length >> 1;
        process(nums, 0, mid - 1, 0, left);
        process(nums, mid, nums.length - 1, 0, right);
        int minRange = Integer.MAX_VALUE;
        for (Integer lSum : left) {
            minRange = Math.min(minRange, Math.abs(lSum - goal));
        }
        for (Integer rSum : right) {
            minRange = Math.min(minRange, Math.abs(rSum - goal));
        }
        int lrSum;
        for (Integer lSum : left) {
            for (Integer rSum : right) {
                lrSum = rSum + lSum;
                minRange = Math.min(minRange, Math.abs(lrSum - goal));
            }
        }
        return minRange;
    }

    public void process(int[] nums, int index, int end, int sum, Set<Integer> sums) {
        if (index > end) {
            sums.add(sum);
            return;
        }
        // 当前位置参与子序列计算
        process(nums, index + 1, end, sum + nums[index], sums);
        // 当前位置不参与子序列计算
        process(nums, index + 1, end, sum, sums);
    }

    public static class TestClass {
        @Test
        public void testForce() {
            for (int i = 0; i < 1000; i++) {
                Solution solution = new Solution();
                int size = (int)(Math.random() * 39) + 1;
                int goal = (int)(Math.random() * 109) * (Math.random() > 0.5 ? 1 : -1);
                int[] arr = ArrayUtil.randomIntArray(size, -107, 107);
                int ans = solution.minAbsDifference(arr, goal);
                System.out.println(ans);
            }
        }

        // 5:18 下午	info
        //				运行成功:
        //				测试用例:[5,-7,3,5]
        //				6
        //				测试结果:1
        //				期望结果:0
        //				stdout:
        @Test
        public void test1() {
            int[] arr = {5, -7, 3, 5};
            int goal = 6;
            Solution solution = new Solution();
            int ans = solution.minAbsDifference(arr, goal);
            int ans2 = Code06_ClosestSubsequenceSum.minAbsDifference(arr, goal);
            log.info("arr:{},ans1:{},ans2:{}", arr, ans, ans2);
        }

        // 5:32 下午	info
        //				解答失败:
        //				测试用例:[7,-9,15,-2]
        //				-5
        //				测试结果:3
        //				期望结果:1
        //				stdout:
        @Test
        public void test2() {
            int[] arr = {7, -9, 15, -2};
            int goal = -5;
            Solution solution = new Solution();
            int ans = solution.minAbsDifference(arr, goal);
            int ans2 = Code06_ClosestSubsequenceSum.minAbsDifference(arr, goal);
            log.info("arr:{},ans1:{},ans2:{}", arr, ans, ans2);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

